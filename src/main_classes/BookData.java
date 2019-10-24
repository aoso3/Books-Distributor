/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_classes;

import java.io.Serializable;

/**
 *
 * @author Amal
 */
public class BookData implements Comparable, Serializable {

    public Book book;
    private int copies;
    
    public BookData(Book book, int copies)
    {
        this.book = book;
        this.copies = copies;
    }
    
    public void setCopies(int count)
    {
        if(count < 0)
            count *= -1;
        copies = count;
    }
    
    public int getCopies()
    {
        return copies;
    }
   

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BookData other = (BookData) obj;
        return other.book.equals(book);
    }

    @Override
    public int compareTo(Object other) {
        if(((BookData)other).copies < copies)
            return -1;
        if(((BookData)other).copies > copies)
            return 1;
        return 0;        
    }    
}
