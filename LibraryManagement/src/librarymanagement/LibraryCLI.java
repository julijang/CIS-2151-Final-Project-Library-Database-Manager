package librarymanagement;

import java.net.IDN;
import java.util.*;

public class LibraryCLI {

    private Library library;
    Scanner keyboard;

    public void start() {
        library = new Library();
        library.loadBooksFromFile();
        library.loadUsersFromFile();
        int input = 0;

        while (input != 8) {
            try {
                System.out.println("Welcome to the Library database");
                System.out.println("Please select an option: ");
                System.out.println("1. Add a book");
                System.out.println("2. Display all books");
                System.out.println("3. Add a user");
                System.out.println("4. Remove a user");
                System.out.println("5. List users");
                System.out.println("6. Borrow books");
                System.out.println("7. Return books");
                System.out.println("8. Exit application");
                input = Integer.parseInt(keyboard.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid User Input: " + e.getMessage());
            }

            switch (input) {
                case 1:
                    addBook();
                    break;
                case 2:
                    displayBooks();
                    break;
                case 3:
                    addUser();
                    break;
                case 4:
                    removeUser();
                    break;
                case 5:
                    listUsers();
                    break;
                case 6:
                    borrowBook();
                    break;
                case 7:
                    returnBook();
                    break;
                case 8:
                    System.out.println("Thank you for using the Library database.");
                    library.saveBooksToFile();
                    library.saveUsersToFile();
                    break;
            }
        }

        System.out.println("Goodbye!");

    }

    public void addBook() {
        try {
            System.out.println("Please enter the book's title: ");
            String title = keyboard.nextLine();
            System.out.println("Please enter the book's author: ");
            String author = keyboard.nextLine();
            System.out.println("Please enter the book's ISBN: ");
            String ISBN = keyboard.nextLine();
            System.out.println("Please enter the book's publication date: ");
            String pubDate = keyboard.nextLine();
            Book book = new Book(title, author, ISBN, pubDate);
            library.addBook(book);
        } catch (Exception e) {
            System.out.println("Invalid User Input: " + e.getMessage());
        }
    }

    public void displayBooks() {
        System.out.println("List of Books:");
        List<Book> bookList = FileManager.loadBooks();
    }

    public void addUser() {
        try {
            System.out.println("Please enter the user's name: ");
            String name = keyboard.nextLine();
            System.out.println("Please enter the user's ID: ");
            String ID = keyboard.nextLine();
            User user = new User(name, ID);
            library.addUser(user);
            library.saveUsersToFile();
        } catch (Exception e) {
            System.out.println("Invalid User Input: " + e.getMessage());
        }
    }

    public void removeUser() {
        try {
            System.out.println("Please enter the user's ID: ");
            String ID = keyboard.nextLine();
            User user = library.getUser(ID);
            if (user != null) {
                library.removeUser(user);
            } else {
                System.out.println("User not found.");
            }
        } catch (Exception e) {
            System.out.println("Invalid User Input: " + e.getMessage());
        }
    }

    public void listUsers() {
        List<User> userList = FileManager.loadUsers();
        Collections.sort(userList, Comparator.comparing(User::getName));

        System.out.println("List of Users:");
        for (User user : userList) {
            System.out.println(user);
        }
    }

    public void borrowBook() {
        try {
            System.out.println("Please enter your user ID: ");
            String ID = keyboard.nextLine();
            User user = library.getUser(ID);

            if (user != null) {
                System.out.println("Please enter the book ISBN: ");
                String ISBN = keyboard.nextLine();
                Book book = library.getBook(ISBN);

                if (book != null) {
                    library.checkOutBook(book, user);
                } else {
                    System.out.println("Book not found.");
                }
            } else {
                System.out.println("User not found.");
            }
        } catch (Exception e) {
            System.out.println("Invalid User Input: " + e.getMessage());
        }
    }

    public void returnBook() {
        try {
            System.out.println("Please enter your user ID: ");
            String ID = keyboard.nextLine();
            User user = library.getUser(ID);

            if (user != null) {
                System.out.println("Please enter the book ISBN: ");
                String ISBN = keyboard.nextLine();
                Book book = library.getBook(ISBN);

                if (book != null) {
                    library.returnBook(book, user);
                } else {
                    System.out.println("Book not found.");
                }
            } else {
                System.out.println("User not found.");
            }
        } catch (Exception e) {
            System.out.println("Invalid User Input: " + e.getMessage());
        }
    }
}