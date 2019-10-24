/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Amal
 */
public class BooksDistributer implements Serializable {
    
    private BooksCollection Books;    
    private AuthorsCollection Authors;
    private StoresCollection Stores;
    
    public BooksDistributer()
    {
        Books = new BooksCollection();
        Authors = new AuthorsCollection();
        Stores = new StoresCollection();
    }
    
    public BooksDistributer(BooksDistributer other)
    {
        try {
            Books = (BooksCollection) other.Books.clone();
            Authors = (AuthorsCollection) other.Authors.clone();
            Stores = (StoresCollection) other.Stores.clone();
        } catch (CloneNotSupportedException ex) { }
    }
    
    public static void Serialize(String path, BooksDistributer toWriteBookDestributer)
    {

        try(ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(path))) {
            obj.writeObject(toWriteBookDestributer);
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static BooksDistributer DeSerialize(String path)
    {
        try(ObjectInputStream obj = new ObjectInputStream(new FileInputStream(path))) {
            BooksDistributer readBooksDistributer =  (BooksDistributer)obj.readObject();
            return readBooksDistributer;
        }
        catch (FileNotFoundException e){ System.out.println(e.getMessage()); }
        catch (ClassNotFoundException e){ System.out.println(e.getMessage()); }
        catch (IOException e){ System.out.println(e.getMessage()); }
        catch (Exception e){ System.out.println(e.getMessage()); }

        return null;
    }
    
    public ArrayList<Book> getBooksByName()
    {
        return Books.getBooksByName();
    }
    
    public ArrayList<Book> getBooksByAuthor(Author author)
    {
        author.books.sort((new Book()).new UpToDateComparator());
        return author.books;
    }
    
    public ArrayList<BookData> getBooksByStore(Store store)
    {
        store.BooksData.sort(null);
        return store.BooksData;
    }
    
    public void addBook(Book newBook)
    {
        Books.addBook(newBook);

        for (int i = 0; i < newBook.Authors.size(); i++) {
            Authors.addAuthor(newBook.Authors.get(i));
        }
    }
    
    public ArrayList<Author> detectAuthorsHaveOneBook(Book book)
    {
        ArrayList<Author> AuthorsHaveOneBook = new ArrayList<>();
        
        for (int i = 0; i < book.Authors.size(); i++) {
            if(book.Authors.get(i).books.size() == 1)
                AuthorsHaveOneBook.add(book.Authors.get(i));
        }
        
        return AuthorsHaveOneBook;
    }
    
    public void removeBook(Book BookToRemove)
    {                
        for (int i = 0; i < BookToRemove.Authors.size(); i++) {
            if(BookToRemove.Authors.get(i).books.size() == 1)
                Authors.removeAuthor(BookToRemove.Authors.get(i));
            else
                BookToRemove.Authors.get(i).books.remove(BookToRemove);
        }
                 
        Books.removeBook(BookToRemove);
    }

    public ArrayList<Author> getAuthorsByName()
    {
        return Authors.getAuthorsByName();
    }
    
    public ArrayList<Author> getAuthorsByBook(Book book)
    {
        return book.Authors;
    }
    
    public void addAuthor(Author newAuthor)
    {
        Authors.addAuthor(newAuthor);
     
        for (int i = 0; i < newAuthor.books.size(); i++) {
            Books.addBook(newAuthor.books.get(i));
        }
    }
    
    public ArrayList<Book> detectBooksHavaOneAuthor(Author author)
    {
        ArrayList<Book> BooksHaveOneAuthor = new ArrayList<>();
        
        for (int i = 0; i < author.books.size(); i++) {
            if(author.books.get(i).Authors.contains(author) && author.books.get(i).Authors.size() == 1)
                BooksHaveOneAuthor.add(author.books.get(i));
        }
        
        return BooksHaveOneAuthor;
    }
    
    public void removeAuthor(Author AuthorToRemove)
    {   
        for (int i = 0; i < AuthorToRemove.books.size(); i++)
        {
            if(AuthorToRemove.books.get(i).Authors.size() == 1)
               Books.removeBook(AuthorToRemove.books.get(i));
            else
                AuthorToRemove.books.get(i).Authors.remove(AuthorToRemove);
        }  
        
        Authors.removeAuthor(AuthorToRemove);
    }
    
    public ArrayList<Store> getStoresByLocation()
    {
        return Stores.getStoresByLocation();
    }
    
    public ArrayList<Store> getStoresByBookAndAuthor(Book book, Author author)
    {
        return Stores.getStoresByBookAndAuthor(book, author);
    }
    
    public void addStore(Store store)
    {
       Stores.addStore(store);
    }
    
    public void removeStore(Store store)
    {
        Stores.removeStore(store);
    }
}
