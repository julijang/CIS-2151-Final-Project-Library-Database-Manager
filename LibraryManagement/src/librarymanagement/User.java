package librarymanagement;

import java.util.ArrayList;

public class User {

    private String name;
    private String Id;
    private ArrayList<Book> borrowedBooks;

    public User(String name, String ID) {
        this.name = name;
        this.Id = Id;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return Id;
    }

    public void setID(String ID) {
        this.Id = ID;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void addBorrowedBook(Book book) {
        this.borrowedBooks.add(book);
    }

    public void removeBorrowedBook(Book book) {
        this.borrowedBooks.remove(book);
    }

    public boolean hasBorrowedBook(Book book) {
        return this.borrowedBooks.contains(book);
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", Id=" + Id + ", borrowedBooks=" + borrowedBooks + '}';
    }

}
