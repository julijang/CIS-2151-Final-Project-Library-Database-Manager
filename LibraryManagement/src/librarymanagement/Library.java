package librarymanagement;

import java.io.*;
import java.util.HashMap;
import java.util.List;

public class Library {

    private HashMap<String, Book> books;
    private HashMap<String, User> users;
    FileManager fileManager;

    public Library() {
        this.books = new HashMap<>();
        this.users = new HashMap<>();
        this.fileManager = new FileManager();

        List<Book> bookList = fileManager.loadBooks();
        for (Book book : bookList) {
            books.put(book.getISBN(), book);
        }
        List<User> userList = fileManager.loadUsers();
        for (User user : userList) {
            users.put(user.getID(), user);
        }
    }

    public void addBook(Book book) {
        books.put(book.getISBN(), book);
        fileManager.saveBooks(books.values());
    }

    public void addUser(User user) {
        users.put(user.getID(), user);
        fileManager.saveUsers(users.values());
    }

    public void removeUser(User user) {
        users.remove(user.getID());
        fileManager.saveUsers(users.values());
    }

    public void checkOutBook(Book book, User user) {
        if (!book.getCheckedOut() && users.containsKey(user.getID())) {
            book.setCheckedOut(true);
            user.borrowABook(book);
            System.out.println("Book checked out successfully.");
        } else {
            System.out.println("This book has already been checked out.");
        }
    }

    public void returnBook(Book book, User user) {
        if (book.getCheckedOut() && users.containsKey(user.getID())) {
            book.setCheckedOut(false);
            user.returnABook(book);
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("This book has not been checked out.");
        }
    }

    public Book getBook(String ISBN) {
        return books.get(ISBN);
    }

    public User getUser(String ID) {
       return users.get(ID);
    }



    public void loadBooksFromFile() {
        List<Book> bookList = fileManager.loadBooks();
        for (Book book : bookList) {
            books.put(book.getISBN(), book);
        }
    }

    public void loadUsersFromFile() {
        List<User> userList = fileManager.loadUsers();
        for (User user : userList) {
            users.put(user.getID(), user);
        }
    }

    public void saveBooksToFile() {
        this.fileManager.saveBooks(books.values());
    }

    public void saveUsersToFile() {
        this.fileManager.saveUsers(users.values());
    }
}

