package librarymanagement;

import java.io.*;
import java.util.HashMap;

public class Library {

    private HashMap<String, Book> books;
    private HashMap<String, User> users;

    public Library() {
        this.books = new HashMap<>();
        this.users = new HashMap<>();
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
            book.isCheckedOut(true);
            user.addBorrowedBook(book);
        } else {
            System.out.println("This book has already been checked out.");
        }
    }

    public void returnBook(Book book, User user) {
        if (user.hasBorrowedBook(book)) {
            book.isCheckedOut(false);
            user.removeBorrowedBook(book);
        } else {
            System.out.println("This book has not been checked out.");
        }
    }

    public void getBooks() {
        for (Book book : books.values()) {
            System.out.println(users.toString());
        }
    }

    public void getUsers() {
        for (User user : users.values()) {
            System.out.println(users.toString());
        }
    }

    public void loadBooksFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("books.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] bookInfo = line.split(",");
                Book book = new Book(bookInfo[0], bookInfo[1], bookInfo[2], bookInfo[3]);
                addBook(book);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while loading books from file.");
            e.printStackTrace();
        }
    }

    public void loadUsersFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String id = parts[0];
                String name = parts[1];
                User user = new User(name, id);
                addUser(user);
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    public void saveBooksToFile() {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("books.txt")))) {
            for (Book book : books.values()) {
                out.print(book.getTitle() + "\n");
                out.print(book.getAuthor() + "\n");
                out.println(book.getISBN() + "\n");
                out.println(book.getPublicationDate());
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void SaveUsersToFile() {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("users.txt")))) {
            for (User user : users.values()) {
                out.print(user.getId() + "\n");
                out.print(user.getName() + "\n");
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

