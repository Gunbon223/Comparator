package Lab_Thuvien.entites;

public class TicketBook {

    private int userId;
    private int bookId;
    private String borrowDate;
    private String returnDate;
    private int ticketId;
    private static int autoId;

    public TicketBook() {
        this.ticketId=++autoId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public int getUser() {
        return userId;
    }

    public void setUser(int user) {
        this.userId = user;
    }

    public int getBook() {
        return bookId;
    }

    public void setBook(int book) {
        this.bookId = book;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
}
