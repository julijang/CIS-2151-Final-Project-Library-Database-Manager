package librarymanagement;

import java.util.*;

public class LibraryCLI {

    private Library library;
    Scanner keyboard = new Scanner(System.in);

    public void start() {
        library.loadBooksFromFile();
        library.loadUsersFromFile();

        while (true) {

            String input = keyboard.nextLine();
            System.out.println("Welcome to the Library database" + "\n");
            System.out.println("Please select an option: " + "\n");


        }

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
            System.out.println("All books sorted by title: ");
            List<Book> sortedBooks = new ArrayList<>(library.getBooks());
            Collections.sort(sortedBooks, Comparator.comparing(Book::getTitle));
            for (Book book : sortedBooks) {
                System.out.println(book.toString());
            }
        }

        public void addUser() {
            try {
                System.out.println("Please enter the user's name: ");
                String name = keyboard.nextLine();
                System.out.println("Please enter the user's ID: ");
                String ID = keyboard.nextLine();
                User user = new User(name, ID);
                library.addUser(user);
            } catch (Exception e) {
                System.out.println("Invalid User Input: " + e.getMessage());
            }
        }

        public void removeUser(User user) {
            try {
                System.out.println("Please enter the user's ID: ");
                String ID = keyboard.nextLine();
                if(user.getId().equals(ID)) {
                    library.removeUser(user);
                } else {
                    System.out.println("User not found.");
                }
            } catch (Exception e) {
                System.out.println("Invalid User Input: " + e.getMessage());
            }
        }

        public void listUsers() {
            System.out.println("All users sorted by name: ");
            List<User> sortedUsers = new ArrayList<>(library.getUsers());
            Collections.sort(sortedUsers, Comparator.comparing(User::getName));
            for (User user : sortedUsers) {
                System.out.println(user.toString());
            }
        }

        public void borrowBook(User user, Book book) {
            System.out.println("Please enter your user ID: ");
            String ID = keyboard.nextLine();
            System.out.println("Please enter the book's ISBN: ");
            String ISBN = keyboard.nextLine();
            if(user.getId().equals(ID) && book.getISBN().equals(ISBN)) {
                library.checkOutBook(book, user);
            } else if (!user.getId().equals(ID)) {
                System.out.println("User not found.");
            } else if (!book.getISBN().equals(ISBN)) {
                System.out.println("Book not found.");
            } else {
                System.out.println("Invalid information provided.");
            }
        }

        public void returnBook(User user, Book book) {
            System.out.println("Please enter your user ID: ");
            String ID = keyboard.nextLine();
            System.out.println("Please enter the book's ISBN: ");
            String ISBN = keyboard.nextLine();
            if(user.getId().equals(ID) && book.getISBN().equals(ISBN)) {
                library.returnBook(book, user);
            } else if (!user.getId().equals(ID)) {
                System.out.println("User not found.");
            } else if (!book.getISBN().equals(ISBN)) {
                System.out.println("Book not found.");
            } else {
                System.out.println("Invalid information provided.");
            }
        }

    }
