package Lab_Thuvien.entites;

public class Book {
    private int id;
    private static int autoid=0;
    private  String bookName;
    private  String category;
    private String author;
    private int quantity;
    private static int remaningBook;

    public Book() {
        this.id=++autoid;
    }

    public Book(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", category='" + category + '\'' +
                ", author='" + author + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    public static void setRemaningBook(int remaningBook) {
        Book.remaningBook = remaningBook;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
