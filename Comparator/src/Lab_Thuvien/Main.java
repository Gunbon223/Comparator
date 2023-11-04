package Lab_Thuvien;

import Lab_Thuvien.entites.Book;
import Lab_Thuvien.entites.TicketBook;
import Lab_Thuvien.entites.User;
import Lab_Thuvien.service.BookService;
import Lab_Thuvien.service.TicketBookService;
import Lab_Thuvien.service.UserService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<Integer, User> userMap =new HashMap<>();
        Map<Integer, Book> bookMap =new HashMap<>();
        Map<Integer, TicketBook> ticketBookMap =new HashMap<>();
        UserService userService = new UserService();
        BookService bookService = new BookService();
        TicketBookService ticketBookService = new TicketBookService();
        Scanner scan = new Scanner(System.in);
        userService.insert(scan,userMap);
        userService.update(scan,userMap);
        userService.delete(scan,userMap);
        bookService.insert(scan,bookMap);
        bookService.update(scan,bookMap);
        bookService.delete(scan,bookMap);

        ticketBookService.inputTicket(bookMap,userMap,ticketBookMap,scan);
        ticketBookService.returnBook(ticketBookMap,scan);
    }

}
