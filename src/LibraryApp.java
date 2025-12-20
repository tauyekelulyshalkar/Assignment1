/*
 LibraryApp.java

 ТҮСІНІКТЕМЕЛЕР:
 List / ArrayList – объектілер тізімін сақтау
 Scanner          – қолданушыдан енгізу алу
 while            – шарт true болғанша қайталанады
 switch / case    – таңдау жасау
 static main      – программаның басталу нүктесі
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryApp {

    // кітаптар тізімі
    private List<Book> books = new ArrayList<>();

    // консольден енгізу үшін
    private Scanner scanner = new Scanner(System.in);

    // негізгі программа логикасы
    public void run() {
        boolean running = true;

        while (running) {
            printMenu();
            int choice = readInt("Choose an option: ");

            switch (choice) {
                case 1 -> printAllBooks();
                case 2 -> addNewBook();
                case 3 -> searchByTitle();
                case 4 -> borrowBook();
                case 5 -> returnBook();
                case 6 -> deleteBook();
                case 7 -> running = false;
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private void printMenu() {
        System.out.println("\nWelcome to Library App!");
        System.out.println("1. Print all books");
        System.out.println("2. Add new book");
        System.out.println("3. Search books by title");
        System.out.println("4. Borrow a book");
        System.out.println("5. Return a book");
        System.out.println("6. Delete a book by id");
        System.out.println("7. Quit");
    }

    private void printAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    private void addNewBook() {
        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Author: ");
        String author = scanner.nextLine();

        int year = readInt("Year: ");

        try {
            Book book = new Book(title, author, year);
            books.add(book);
            System.out.println("Book added.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void searchByTitle() {
        System.out.print("Enter title part: ");
        String query = scanner.nextLine().toLowerCase();

        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(query)) {
                System.out.println(book);
            }
        }
    }

    private void borrowBook() {
        int id = readInt("Enter id: ");
        Book book = findBookById(id);

        if (book != null && book.isAvailable()) {
            book.markAsBorrowed();
            System.out.println("Book borrowed.");
        } else {
            System.out.println("Book not available.");
        }
    }

    private void returnBook() {
        int id = readInt("Enter id: ");
        Book book = findBookById(id);

        if (book != null && !book.isAvailable()) {
            book.markAsReturned();
            System.out.println("Book returned.");
        }
    }

    private void deleteBook() {
        int id = readInt("Enter id: ");
        Book book = findBookById(id);

        if (book != null) {
            books.remove(book);
            System.out.println("Book deleted.");
        }
    }

    private Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    private int readInt(String message) {
        System.out.print(message);
        while (!scanner.hasNextInt()) {
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    // static main — JVM бірінші болып осы методты іске қосады
    public static void main(String[] args) {
        new LibraryApp().run();
    }
}
