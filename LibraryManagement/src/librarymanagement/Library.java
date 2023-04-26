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
        fileManager = new FileManager();

        List<Book> bookList = fileManager.loadBooks();
        for (Book book : bookList) {
            books.put(book.getISBN(), book);
        }

        List<User> userList = fileManager.loadUsers();
        for (User user : userList) {
            users.put(user.getId(), user);
        }

    }

    public void addBook(Book book) {
        books.put(book.getISBN(), book);
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public void removeUser(User user) {
        users.remove(user.getId());
    }

    public void checkOutBook(Book book, User user) {
        if (!book.getCheckedOut() && users.containsKey(user.getId())) {
            book.setCheckedOut(true);
            user.addBorrowedBook(book);
            System.out.println("Book checked out successfully.");
        } else {
            System.out.println("This book has already been checked out.");
        }
    }

    public void returnBook(Book book, User user) {
        if (user.hasBorrowedBook(book)) {
            book.setCheckedOut(false);
            user.removeBorrowedBook(book);
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

    public HashMap loadBooksFromFile() {
        List<Book> booksFromFile = FileManager.loadBooks();
        for (Book book : booksFromFile) {
            addBook(book);
        }
        return books;
    }

    public HashMap loadUsersFromFile() {
        List<User> usersFromFile = FileManager.loadUsers();
        for (User user : usersFromFile) {
            addUser(user);
        }
        return users;
    }

    public void saveBooksToFile() {
        FileManager.saveBooks(books.values());
    }

    public void saveUsersToFile() {
        FileManager.saveUsers(users.values());
    }
}

