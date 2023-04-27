package librarymanagement;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private String ID;

    private List<Book> borrowedBooks;

    public User(String name, String ID) {
        this.name = name;
        this.ID = ID;
        borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void borrowABook(Book book){
        borrowedBooks.add(book);
    }

    public void returnABook(Book book){
        borrowedBooks.remove(book);
    }

    public void displayUserInformation() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + ID);
        System.out.println("Borrowed books: ");
        for (Book book : borrowedBooks) {
            System.out.println(book.getTitle());
        }
        if (borrowedBooks.isEmpty()) {
            System.out.println("(empty)");
        }
    }

}
