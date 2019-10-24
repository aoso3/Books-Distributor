/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Amal
 */
public class BooksCollection implements Iterable, Cloneable, Serializable {

    private final ArrayList<Book> collection;
    
    public BooksCollection()
    {
        collection = new ArrayList<>();
    }
    
    public BooksCollection(ArrayList<Book> array)
    {
        collection = (ArrayList<Book>) array;
    }
    
    public ArrayList<Book> getBooksByName()
    {
        collection.sort((new Book()).new TitleComparator());
        return (ArrayList<Book>) collection.clone();
    }
    
    public void addBook(Book newBook)
    {
        if(!collection.contains(newBook))
           collection.add(newBook);
    }
    
    public void removeBook(Book BookToRemove)
    {
        if(collection.contains(BookToRemove))
            collection.remove(BookToRemove);
    }
    
    public Book BookAt(int idx)
    {
        return collection.get(idx);
    }
    
    public int getSize()
    {
        return collection.size();
    }
    
    public boolean containsAuthor(Book book)
    {
        return collection.contains(book);
    }
    
    private ArrayList<Book> getCopy()
    {
        ArrayList<Book> copy = new ArrayList<>();
        for (int i = 0; i < collection.size(); i++) {
            copy.add((Book) collection.get(i).clone());
        }        
        return copy;
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {    
        return new BooksCollection(getCopy());
    }

    class BooksIterator implements Iterator
    {
        private int currentIndex = 0;
        
        @Override
        public boolean hasNext() {
            return currentIndex < collection.size();
        }

        @Override
        public Book next() {
            if(hasNext())
                return (Book) collection.get(currentIndex++);
            return null;
        }     
    }    
    
    @Override
    public Iterator iterator() {
        return new BooksIterator();
    }
        
}

