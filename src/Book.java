/*
 Book.java

 ТҮСІНІКТЕМЕЛЕР:
 class   – объект жасауға арналған шаблон
 public  – барлық жерден қолжетімді
 private – тек класс ішінде қолжетімді
 static  – барлық объектілерге ортақ
 boolean – true немесе false мәнін сақтайды
 throw   – қате (exception) тастайды
 new     – жаңа объект жасайды
*/

import java.time.Year; // ағымдағы жылды алу үшін

public class Book {

    private int id;
    private static int idGen = 1;

    private String title;
    private String author;
    private int year;

    // true – кітап бар, false – кітап алынған
    private boolean available;

    // default конструктор
    public Book() {
        this.id = idGen++;
        this.available = true;
    }

    // параметрлі конструктор
    public Book(String title, String author, int year) {
        this(); // басқа конструкторды шақыру
        setTitle(title);
        setAuthor(author);
        setYear(year);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    // title бос болмауы керек
    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title must not be empty");
        }
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    // author бос болмауы керек
    public void setAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author must not be empty");
        }
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    // жыл 1500 мен ағымдағы жыл арасында болуы керек
    public void setYear(int year) {
        int currentYear = Year.now().getValue();
        if (year < 1500 || year > currentYear) {
            throw new IllegalArgumentException("Invalid year");
        }
        this.year = year;
    }

    public boolean isAvailable() {
        return available;
    }

    // кітапты алынған деп белгілеу
    public void markAsBorrowed() {
        available = false;
    }

    // кітапты қайтару
    public void markAsReturned() {
        available = true;
    }

    @Override
    public String toString() {
        return "Book{id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", available=" + available + "}";
    }
}
