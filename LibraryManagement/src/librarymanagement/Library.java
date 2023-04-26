package librarymanagement;

import java.io.*;
import java.util.HashMap;
import java.util.List;

public class Library {

    private HashMap<String, Book> books;
    private HashMap<String, User> users;

    public Library(HashMap<String, Book> books, HashMap<String, User> users) {
        this.books = books;
        this.users = users;
    }

    public void addBook(Book book) {
        books.put(book.getISBN(), book);
    }

    public void addUser(User user) {
        users.put(user.getID(), user);
    }

    public void removeUser(User user) {
        users.remove(user.getID());
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
        List<Book> bookList = FileManager.loadBooks();
        for (Book book : bookList) {
            books.put(book.getISBN(), book);
        }
    }

    public void loadUsersFromFile() {
        List<User> userList = FileManager.loadUsers();
        for (User user : userList) {
            users.put(user.getID(), user);
        }
    }

    public void saveBooksToFile() {
        FileManager.saveBooks(books.values());
    }

    public void saveUsersToFile() {
        FileManager.saveUsers(users.values());
    }
}

