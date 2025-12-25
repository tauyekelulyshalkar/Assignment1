package assignment1;

import java.util.Scanner; //пернетақта

// LibraryApp — кітапхана жүйесі (main application)
public class LibraryApp {

    // Book массиві — кітаптарды сақтау
    private Book[] books = new Book[10];
    private int count = 0; // қанша кітап бар

    // Scanner — қолданушыдан input алу
    private Scanner scanner = new Scanner(System.in);

    // main method — программа осы жерден басталады
    public static void main(String[] args) {
        LibraryApp app = new LibraryApp();
        app.run();
    }

    // Программаны жүргізу (main logic)
    public void run() {
        int choice;

        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // buffer тазалау

            switch (choice) {
                case 1 -> printBooks();
                case 2 -> addBook();
                case 3 -> searchBook();
                case 4 -> borrowBook();
                case 5 -> returnBook();
                case 6 -> deleteBook();
                case 7 -> exit();
                default -> System.out.println("Қате таңдау!");
            }

        } while (choice != 7);
    }

    // Мәзір (menu)
    private void showMenu() {
        System.out.println("\n--- Library Menu ---");
        System.out.println("1. Барлық кітаптарды шығару");
        System.out.println("2. Жаңа кітап қосу");
        System.out.println("3. Кітап іздеу (title)");
        System.out.println("4. Кітап алу");
        System.out.println("5. Кітап қайтару");
        System.out.println("6. Кітап өшіру");
        System.out.println("7. Шығу");
        System.out.print("Таңдауыңыз: ");
    }

    // Барлық кітаптарды шығару
    private void printBooks() {
        if (count == 0) {
            System.out.println("Кітап жоқ");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println(books[i]);
        }
    }

    // Кітап қосу
    private void addBook() {
        System.out.print("Кітап атауы: ");
        String title = scanner.nextLine();

        System.out.print("Автор: ");
        String author = scanner.nextLine();

        books[count++] = new Book(title, author);
        System.out.println("Кітап қосылды");
    }

    // Кітап іздеу
    private void searchBook() {
        System.out.print("Атауы: ");
        String title = scanner.nextLine();

        for (int i = 0; i < count; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                System.out.println(books[i]);
                return;
            }
        }
        System.out.println("Кітап табылмады");
    }

    // Кітап алу
    private void borrowBook() {
        System.out.print("Кітап ID: ");
        int id = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            if (books[i].getId() == id) {
                if (!books[i].isBorrowed()) {
                    books[i].borrow();
                    System.out.println("Кітап алынды");
                } else {
                    System.out.println("Кітап already borrowed");
                }
                return;
            }
        }
        System.out.println("ID табылмады");
    }

    // Кітап қайтару
    private void returnBook() {
        System.out.print("Кітап ID: ");
        int id = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            if (books[i].getId() == id) {
                books[i].returnBook();
                System.out.println("Кітап қайтарылды");
                return;
            }
        }
        System.out.println("ID табылмады");
    }

    // Кітап өшіру
    private void deleteBook() {
        System.out.print("Кітап ID: ");
        int id = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            if (books[i].getId() == id) {
                books[i] = books[count - 1];
                books[count - 1] = null;
                count--;
                System.out.println("Кітап өшірілді");
                return;
            }
        }
        System.out.println("ID табылмады");
    }

    // Шығу
    private void exit() {
        System.out.println("Программа аяқталды");
    }
}
