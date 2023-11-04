package Lab_Thuvien.service;

import Bvn.utility.Utility;
import Lab_Thuvien.entites.Book;
import Lab_Thuvien.entites.TicketBook;
import Lab_Thuvien.entites.User;

import java.util.Map;
import java.util.Scanner;

public class TicketBookService {
    Utility utility = new Utility();
    BookService bookService = new BookService();
    UserService userService = new UserService();

    public void inputTicket(Map<Integer, Book> bookMap, Map<Integer, User> bookUser, Map<Integer, TicketBook> ticketBookMap, Scanner scan) {
        while (true) {
            TicketBook ticketBook = new TicketBook();
            System.out.print("Nhap id sach: ");
            Book book = new Book(bookService.findBook(bookMap, scan).getBookName());
            book.setQuantity(book.getQuantity() - 1);
            if (book.getQuantity() == 0) {
                System.out.println("Da het sach " + book);
                break;
            }
            ticketBook.setBook(book.getId());
            System.out.print("Nhap ten user: ");
            ticketBook.setUser(userService.findUserByName(bookUser, scan).getId());
            System.out.print("Nhap ngay muon: ");
            ticketBook.setBorrowDate(utility.inputString(scan));
            System.out.print("Nhap ngay tra: ");
            ticketBook.setReturnDate(utility.inputString(scan));
            ticketBookMap.put(ticketBook.getTicketId(), ticketBook);
            System.out.println("Tiep tuc nhap ? y/n");
            if (utility.inputString(scan).equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    public void returnBook(Map<Integer, TicketBook> ticketBookMap, Scanner scan) {

        while (true) {
            System.out.println("Nhap id phieu muon: ");
            int removeId = utility.inputInt(scan);
            if (ticketBookMap.containsKey(removeId)) {
                ticketBookMap.remove(removeId);
                System.out.println("Tra sach thanh cong");
                System.out.println("Tiep tuc tra sach ? y/n");
                if (utility.inputString(scan).equalsIgnoreCase("n")) {
                    break;
                } else {
                    System.out.println("KKhong tim thay id phieu muon ban muon thu lai ? y/n");
                    if (utility.inputString(scan).equalsIgnoreCase("n")) {
                        break;
                    }
                }
            }
        }
    }
}
