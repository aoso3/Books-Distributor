/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

/**
 *
 * @author Amal
 */
public class Author implements Cloneable, Comparable, Serializable
{
    private final int authorID;
    private String firstName;
    private String lastName;

    public ArrayList<Book> books;
    
    private static int lastID;

    private int getValidID()
    {
        return ++lastID;            
    }
    
    public final void setFirstName(String name)
    {
//        if(((int)(name.charAt(0)) <= (int)('z')) && ((int)(name.charAt(0)) >= (int)('a')))
//        {
//            String temp = (char)(((int)(name.charAt(0)) - (int)('a')) + (int)('A')) + name.substring(1);
//            this.firstName = temp;
//        }
//        else
            this.firstName = name;            
    }
    
    public final void setLastName(String name)
    {
//        if(((int)(name.charAt(0)) <= (int)('z')) && ((int)(name.charAt(0)) >= (int)('a')))
//        {
//            String temp = (char)(((int)(name.charAt(0)) - (int)('a')) + (int)('A')) + name.substring(1);
//            this.lastName = temp;
//        }
//        else
            this.lastName = name;            
    }
    
    public int getAuthorID()
    {
        return authorID;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public Author()
    {
        this.authorID = getValidID();
        setFirstName("");
        setLastName("");
    }
    
    public Author(String firstName, String lastName)
    {
        this.authorID = getValidID();
        setFirstName(firstName);
        setLastName(lastName);
    }
    
    public Author(String firstName, String lastName, ArrayList<Book> hisBooks)
    {
        this(firstName, lastName);

        this.books = hisBooks;
        books = new ArrayList<>();
        if(hisBooks != null)
            for (int i = 0; i < hisBooks.size(); i++) {
                hisBooks.get(i).addAuthor(this);
            }                    
    }
   
    public Author(Author other)
    {
        this.authorID = other.authorID;
        this.firstName = other.firstName;
        this.lastName = other.lastName;
        this.books = (ArrayList<Book>) other.books.clone();
    }

    @Override
    public Object clone()
    {
        return new Author(this);
    }

    @Override
    public int compareTo(Object other)
    {
        if(((Author)other).authorID < this.authorID)
            return 1;
        if(((Author)other).authorID > this.authorID)
            return -1;
        return 0;
    }
    
    @Override
    public boolean equals(Object other) {
        return ((Author)other).authorID == authorID;
    }
    
    class FirstNameComparator implements Comparator
    {
        @Override
        public int compare(Object o1, Object o2) 
        {
            if(((Author)o1).firstName.compareTo(((Author)o2).firstName) == 1)
                return 1;
            if(((Author)o1).firstName.compareTo(((Author)o2).firstName) == -1)
                return -1;
            if(((Author)o1).lastName.compareTo(((Author)o2).lastName) == 1)
                return 1;  
            if(((Author)o1).lastName.compareTo(((Author)o2).lastName) == -1)
                return -1;
            return 0;

        }   
    }
    
    public void addBook(Book book)
    {
        if(!books.contains(book))
            books.add(book);
        if(!book.Authors.contains(this))
            book.addAuthor(this);
    }
    
    public void removeBook(Book book)
    {
        if(book.Authors.contains(this))
            book.removeAuthor(this);
        books.remove(book);   
    }
    
    @Override
    public String toString() {
        return "authorID : " + authorID + ",\n firstName : " + firstName + ",\n lastName : " + lastName + ",\n books : " + books;
    }
}

