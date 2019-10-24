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
public class AuthorsCollection implements Iterable, Cloneable, Serializable {
    
    private final ArrayList<Author> collection;
    
    public AuthorsCollection()
    {
        collection = new ArrayList<>();
    }
    
    public AuthorsCollection(ArrayList<Author> array)
    {
        collection = array;
    }
    
    public void addAuthor(Author e)
    {
        if(!collection.contains(e))
           collection.add(e);
    }
    
    public ArrayList<Author> getAuthorsByName()
    {
        collection.sort((new Author()).new FirstNameComparator());
        return collection;
    }
    
    public void removeAuthor(Author AuthorToRemove)
    {
        if(collection.contains(AuthorToRemove))
           collection.remove(AuthorToRemove);
    }

    public Author AuthorAt(int idx)
    {
        return collection.get(idx);
    }
    
    public int getSize()
    {
        return collection.size();
    }
 
    public boolean containsAuthor(Author author)
    {
        return collection.contains(author);
    }
    
    private ArrayList<Author> getCopy()
    {
        ArrayList<Author> copy = new ArrayList<>();
        for (int i = 0; i < collection.size(); i++) {
            copy.add((Author) collection.get(i).clone());
        }        
        return copy;
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {    
        return new AuthorsCollection(getCopy());
    }

    class AuthorsIterator implements Iterator
    {
        private int currentIndex = 0;
        
        @Override
        public boolean hasNext() {
            return currentIndex < collection.size();
        }

        @Override
        public Author next() {
            if(hasNext())
                return (Author) collection.get(currentIndex++);
            return null;
        }
        
        @Override
        public void remove() {
            if(hasNext())
                collection.remove(currentIndex);
        }        
    }    
    
    @Override
    public Iterator iterator() {
        return new AuthorsIterator();
    }
}

