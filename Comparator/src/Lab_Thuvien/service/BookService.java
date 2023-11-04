package Lab_Thuvien.service;

import Lab_Thuvien.entites.Book;
import Lab_Thuvien.utility.Utility;

import javax.swing.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class BookService implements Iservice<Book>{
    Utility utility = new Utility();
    
    public Book findBook(Map<Integer,Book> bookMap,Scanner scan) {
        while (true) {
            int id = utility.inputInt(scan);
            if (bookMap.containsKey(id)) {
                return bookMap.get(id);
            }
            else {
                System.out.println("Khong tm thay doi tuong nhap lai");
            }
        }
    }



    @Override
    public void insert(Scanner scan, Map<Integer, Book> bookMap) {
        Book book = new Book();
        System.out.println("Nhap ten sach: ");
        book.setBookName(utility.inputString(scan));
        System.out.println("nhap tac gia:");
        book.setAuthor(utility.inputString(scan));
        System.out.println("Nhap chu de: ");
        book.setCategory(utility.inputString(scan));
        System.out.println("Nhap so luong: " );
        book.setQuantity(utility.inputInt(scan));
        bookMap.put(book.getId(),book);
    }

    @Override
    public void update(Scanner scan, Map<Integer, Book> bookMap) {
        String choice = "";
        do {
            System.out.println("Nhap ten sach muon doi: ");
            String bookFind= utility.inputString(scan);
            Set<Integer> set = bookMap.keySet();
            for (Integer key:
                    set) {
                if (bookFind.equalsIgnoreCase(bookMap.get(key).getBookName())) {

                    System.out.println("Nhap ten sach: ");
                    bookMap.get(key).setBookName(utility.inputString(scan));
                    System.out.println("nhap tac gia:");
                    bookMap.get(key).setAuthor(utility.inputString(scan));
                    System.out.println("Nhap chu de: ");
                    bookMap.get(key).setCategory(utility.inputString(scan));
                    System.out.println("Nhap so luong: " );
                    bookMap.get(key).setQuantity(utility.inputInt(scan));
                }
                else {
                    System.out.println("khong tim thay lam lai ? y/n");
                    choice = utility.inputString(scan);
                }
            }
        }
        while (choice.equalsIgnoreCase("y"));
    }

    @Override
    public void delete(Scanner scan, Map<Integer, Book> bookMap) {
        String choice = "";
        do {
            System.out.println("Nhap ten sach muon xoa: ");
            String bookFind= utility.inputString(scan);
            Set<Integer> set = bookMap.keySet();
            for (Integer key:
                    set) {
                if (bookFind.equalsIgnoreCase(bookMap.get(key).getBookName())) {
                    bookMap.remove(key);
                    System.out.println("da xoa sach tim thay");
                }
                else {
                    System.out.println("khong tim thay lam lai ? y/n");
                    choice = utility.inputString(scan);
                }
            }
        }
        while (choice.equalsIgnoreCase("y"));
    }
}
