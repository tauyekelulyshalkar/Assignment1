/*
 Rectangle.java

 ТҮСІНІКТЕМЕЛЕР:
 public  – класс немесе метод кез келген жерден қолжетімді
 private – тек осы класс ішінде ғана қолжетімді (инкапсуляция)
 static  – объектіге емес, классқа тиесілі
 this    – ағымдағы объектіні білдіреді
 new     – жаңа объект жасау үшін
 return  – методтан мән қайтару үшін
 void    – метод ешқандай мән қайтармайды
 @Override – ата-кластағы методты қайта жазу
*/

// public — бұл классты басқа файлдардан да қолдануға болады
public class Rectangle {

    // private — өрістерді сырттан тікелей өзгертуге болмайды
    private double width;
    private double height;

    // әр Rectangle объектісінің жеке идентификаторы
    private int id;

    // static — барлық Rectangle объектілеріне ортақ айнымалы
    private static int idGen = 1;

    // public — конструкторды кез келген жерден шақыруға болады
    public Rectangle() {
        // this — ағымдағы объект
        this.width = 1.0;
        this.height = 1.0;
        this.id = idGen++; // id тағайындау және генераторды арттыру
    }

    // public — параметрлі конструктор
    public Rectangle(double width, double height) {
        // this() — осы кластың default конструкторын шақырады
        this();
        setWidth(width);
        setHeight(height);
    }

    // getter — мәнді қайтару
    public double getWidth() {
        return width;
    }

    // setter — мәнді тексеріп орнату
    public void setWidth(double width) {
        if (width <= 0) {
            // throw — қате тастау
            throw new IllegalArgumentException("Width must be greater than 0");
        }
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be greater than 0");
        }
        this.height = height;
    }

    public int getId() {
        return id;
    }

    // аудан есептеу
    public double area() {
        return width * height;
    }

    // периметр есептеу
    public double perimeter() {
        return 2 * (width + height);
    }

    // Object класындағы методты қайта жазу
    @Override
    public String toString() {
        return "Rectangle{id=" + id +
                ", width=" + width +
                ", height=" + height + "}";
    }
}

