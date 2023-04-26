/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarymanagement;

/**
 *
 * @author ssdawood
 */
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileManager {
    private static final String BOOKS_FILE = "LibraryManagement/books.txt";
    private static final String USERS_FILE = "LibraryManagement/users.txt";
    private static final String COLUMN_SEP = ",";

    public static List<Book> loadBooks() {
        List<Book> books = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(BOOKS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] bookData = line.split(",");
                Book book = new Book(bookData[0], bookData[1], bookData[2], bookData[3]);
                books.add(book);
            }
        } catch (IOException e) {
            System.out.println("Error reading books file: " + e.getMessage());
        }
        return books;
    }

    public static void saveBooks(Collection<Book> books) {        
        try (PrintWriter out = new PrintWriter(
                               new BufferedWriter(
                               new FileWriter(BOOKS_FILE)))) {
            // write all products to the file
            for (Book book : books) {
                out.print(book.getTitle() + COLUMN_SEP);
                out.print(book.getAuthor() + COLUMN_SEP);
                out.print(book.getISBN() + COLUMN_SEP);
                out.println(book.getPublicationDate());
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

    public static List<User> loadUsers() {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                users.add(new User(userData[0], userData[1]));
            }
        } catch (IOException e) {
            System.out.println("Error reading users file: " + e.getMessage());
        }
        return users;
    }

    public static void saveUsers(Collection<User> users) {
        try (PrintWriter out = new PrintWriter(
                               new BufferedWriter(
                               new FileWriter(USERS_FILE)))) {
            // write all products to the file
            for (User user : users) {
                out.print(user.getID() + COLUMN_SEP);
                out.println(user.getName());
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}


