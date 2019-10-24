/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_classes;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
/**
 *
 * @author Amal
 */
public class Book implements Cloneable, Comparable, Serializable
{
    private final int ISPN;
    private String title; 
    private Date publishDate;
    private final SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private int pageCount;

    public ArrayList<Author> Authors;
        
    private static int lastISPN;

    private int getValidISPN()
    {
        return ++lastISPN;            
    }
    
    public final void setTitle(String title)
    {
//        if(((int)(title.charAt(0)) <= (int)('z')) && ((int)(title.charAt(0)) >= (int)('a')))
//        {
//            String temp = (char)(((int)(title.charAt(0)) - (int)('a')) + (int)('A')) + title.substring(1);
//            this.title = temp;
//        }
//        else
            this.title = title;            
    }
    
    public final void setPageCount(int pageCount)
    {
        if(pageCount < 0)
            pageCount *= -1;
        this.pageCount = pageCount;
    }
    
    public int getISPN()
    {
        return ISPN;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public int getPageCount()
    {
        return pageCount;
    }

    public final void setPublishDate(String date)
    {
        try {
            publishDate = DateFormat.parse(date);
        } catch (ParseException ex) {
            publishDate = null;
        }
    }
    
    public String getPublishDate()
    {
        return publishDate.toString();
    }
    
    public Book(String title, int pageCount, String date, ArrayList<Author> Authors)
    {
        this.ISPN = getValidISPN();
        
        setPageCount(pageCount);
        setTitle(title);
        setPublishDate(date);
        
        this.Authors = new ArrayList<>();
        if(Authors != null)
        {
            for (Author author : Authors) {
                this.addAuthor(author);
            }
        }            
    }
    
    public Book()
    {
        this("", 0, "", new ArrayList<>());
    }
    
    public Book(Book other)
    {
      ISPN = other.ISPN;
      title = other.title;
      pageCount = other.pageCount;
      publishDate = other.publishDate;  
      Authors = (ArrayList<Author>) other.Authors.clone();
    }    
    
    @Override
    public Object clone()
    {
        return new Book(this);
    }

    @Override
    public int compareTo(Object other) 
    {
        Book otherBook = (Book)other;
        if(otherBook.ISPN < this.ISPN)
            return 1;
        if(otherBook.ISPN > this.ISPN)
            return -1;
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return ((Book)obj).ISPN == ISPN;
    }
    
    class TitleComparator implements Comparator
    {
        @Override
        public int compare(Object o1, Object o2) 
        {
            return ((Book)o1).title.compareTo(((Book)o2).title);
        }
    }
    
    class UpToDateComparator implements Comparator
    {
        @Override
        public int compare(Object o1, Object o2) 
        {
            return -1 * ((Book)o1).publishDate.compareTo(((Book)o2).publishDate);
        }        
    }
    
    class PageCountComparator implements Comparator
    {
        @Override
        public int compare(Object o1, Object o2) 
        {
            if(((Book)o1).pageCount > ((Book)o2).pageCount)
                return 1;
            if(((Book)o1).pageCount < ((Book)o2).pageCount)
                return -1;
            return 0;
        }        
    }
    
    public final void addAuthor(Author author)
    {
        if(!Authors.contains(author))
            Authors.add(author);
        if(!author.books.contains(this))
            author.addBook(this);
    }
    
    public void removeAuthor(Author author)
    {
        if(author.books.contains(this))
            author.removeBook(this);
        Authors.remove(author);
    }
        
    @Override
    public String toString() {
        return "ISPN : " + ISPN + ",\n title : " + title + ",\n publishDate : " + publishDate + ",\n DateFormat : " + DateFormat + ",\n pageCount : " + pageCount + ", Authors : " + Authors + "\n";
    }
   
}

