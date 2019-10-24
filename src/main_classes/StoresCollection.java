/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_classes;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Amal
 */
public class StoresCollection implements Cloneable, Serializable {
        
    private final ArrayList<Store> collection;
    
    public StoresCollection()
    {
        collection = new ArrayList<>();
    }
    
    public StoresCollection(ArrayList<Store> array)
    {
        collection = (ArrayList<Store>) array.clone();
    }

    public ArrayList<Store> getStoresByLocation()
    {
        collection.sort((new Store()).new LocationComparator());
        return (ArrayList<Store>) collection.clone();
    }
    
    public ArrayList<Store> getStoresByBookAndAuthor(Book book, Author author)
    {
        ArrayList<Store> stores = new ArrayList<>();
        for (int i = 0; i < collection.size(); i++) {
            for (int j = 0; j < collection.get(i).BooksData.size(); j++) {
                if(collection.get(i).BooksData.get(i).book.getTitle().equals(book.getTitle()) && collection.get(i).BooksData.get(i).book.Authors.contains(author))
                {
                    stores.add(collection.get(i));
                    break;
                }
            }
        }
        stores.sort((new Store()).new LocationComparator());
        return stores;
    }
    
    public void addStore(Store e)
    {
        collection.add(e);
    }
   
    public void removeStore(Store e)
    {
        collection.remove(e);
    }
    
    public Store StoreAt(int idx)
    {
        return collection.get(idx);
    }
    
    public int getSize()
    {
        return collection.size();
    }
    
    private ArrayList<Store> getCopy()
    {
        ArrayList<Store> copy = new ArrayList<>();
        for (int i = 0; i < collection.size(); i++) {
            copy.add((Store) collection.get(i).clone());
        }        
        return copy;
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {    
        return new StoresCollection(getCopy());
    }
}

