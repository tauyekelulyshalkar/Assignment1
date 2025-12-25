package assignment1;

// Book class — кітапты сипаттайтын класс
public class Book {

    // static variable — барлық кітаптарға ортақ санағыш
    private static int count = 0;

    // instance variables — әр кітапқа жеке
    private int id;           // unique id
    private String title;     // book title
    private String author;    // author name
    private boolean borrowed; // book status (borrowed or not)

    // Parameterized constructor — кітап жасау
    public Book(String title, String author) {
        this.title = title;     // this → current object
        this.author = author;
        this.borrowed = false;  // initially not borrowed

        count++;
        this.id = count;        // auto id
    }

    // Getter methods — access data
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    // Borrow book — кітапты алу
    public void borrow() {
        borrowed = true;
    }

    // Return book — кітапты қайтару
    public void returnBook() {
        borrowed = false;
    }

    // toString — экранға шығару
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", borrowed=" + borrowed +
                '}';
    }
}
