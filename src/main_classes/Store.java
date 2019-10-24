/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
/**
 *
 * @author Amal
 */
public class Store implements Comparable, Serializable {
    private final int storeID;
    private String name;
    private String city;
    private String country;
    public String adress;
    public ArrayList<BookData> BooksData;
   
    private static int lastID;
    private int getValidID()
    {
        return ++lastID;            
    }
    
    public final void setName(String name)
    {
//         if(((int)(name.charAt(0)) <= (int)('z')) && ((int)(name.charAt(0)) >= (int)('a')))
//        {
//            String temp = (char)(((int)(name.charAt(0)) - (int)('a')) + (int)('A')) + name.substring(1);
//            this.name = temp;
//        }
//        else
            this.name = name; 
    }
    
    public final void setCity(String city)
    {
//        if(((int)(city.charAt(0)) <= (int)('z')) && ((int)(city.charAt(0)) >= (int)('a')))
//        {
//            String temp = (char)(((int)(city.charAt(0)) - (int)('a')) + (int)('A')) + city.substring(1);
//            this.city = temp;
//        }
//        else
            this.city = city; 
    }
    
    public final void setCountry(String country)
    {
//        if(((int)(country.charAt(0)) <= (int)('z')) && ((int)(country.charAt(0)) >= (int)('a')))
//        {
//            String temp = (char)(((int)(country.charAt(0)) - (int)('a')) + (int)('A')) + country.substring(1);
//            this.country = temp;
//        }
//        else
            this.country = country; 
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getCity()
    {
        return city;
    }
    
    public String getCountry()
    {
        return country;
    }
    
    public Store()
    {
        this.storeID = getValidID();
        BooksData = new ArrayList<>();
    }
    
    public Store(String name, String city, String country, String address, ArrayList<BookData> booksData)
    {
        this.storeID = getValidID();
        setName(name);
        setCity(city);
        setCountry(country);
        this.adress = address;
        
        BooksData = booksData;
    }
    
    public Store(Store other)
    {
        this.storeID = other.storeID;
        this.name = other.name;
        this.city = other.city;
        this.country = other.country;
        this.adress = other.adress;
        this.BooksData = (ArrayList<BookData>) other.BooksData.clone();     
    }
    
    @Override
    public Object clone()
    {
        return new Store(this);
    }

    @Override
    public int compareTo(Object other) {
        if(((Store)other).storeID < this.storeID)
            return 1;
        if(((Store)other).storeID > this.storeID)
            return -1;
        return 0;
    }
    
    @Override
    public boolean equals(Object other) {
        return storeID == ((Store) other).storeID;
    }
   
    class NameComparator implements Comparator
    {
        @Override
        public int compare(Object o1, Object o2) {
            return ((Store)o1).name.compareTo(((Store)o2).name);
        }        
    }
    
    class LocationComparator implements Comparator
    {
        @Override
        public int compare(Object o1, Object o2) {
            if(((Store)o1).country.compareTo(((Store)o2).country) > 0)
                return 1;
            if(((Store)o1).country.compareTo(((Store)o2).country) < 0)
                return -1;
            if(((Store)o1).city.compareTo(((Store)o2).city) > 0)
                return 1;
            if(((Store)o1).city.compareTo(((Store)o2).city) < 0)
                return -1;
            if(((Store)o1).adress.compareTo(((Store)o2).adress) > 0)
                return 1;
            if(((Store)o1).adress.compareTo(((Store)o2).adress) < 0)
                return -1;
            return 0;
        }        
    }
}
