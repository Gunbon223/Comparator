package Lab_Thuvien.service;

import Lab_Thuvien.entites.Book;
import Lab_Thuvien.entites.User;
import Lab_Thuvien.utility.Utility;

import javax.swing.*;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class UserService implements Iservice<User>{

    Utility utility = new Utility();

    public User findUserByName(Map<Integer,User> bookUser,Scanner scan) {
        while (true) {
            String id= utility.inputString(scan);
            if (bookUser.containsKey(id)) {
                return bookUser.get(id);
            }
            else {
                System.out.println("khong tim thay sai nhap lai");
            }
        }
    }


    @Override
    public void insert(Scanner scan, Map<Integer, User> bookUser) {
        while (true) {
            User user = new User();
            System.out.println("Nhap ten sach: ");
            user.setName(utility.inputString(scan));
            System.out.println("nhap dia chi:");
            user.setAddress(utility.inputString(scan));
            System.out.println("Nhap so dien thoai: ");
            user.setPhoneNumber(utility.inputString(scan));
            bookUser.put(user.getId(), user);
            System.out.println("Tiep tuc nhap ? y/n");
            if (utility.inputString(scan).equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    @Override
    public void update(Scanner scan, Map<Integer, User> bookUser) {
        String choice = "";
        do {
            System.out.println("Nhap ten user muon doi: ");
            String userFind= utility.inputString(scan);
            Set<Integer> set = bookUser.keySet();
            for (Integer key:
                    set) {
                if (bookUser.get(key).getName().equalsIgnoreCase(userFind)) {
                    System.out.println("Nhap ten: ");
                    bookUser.get(key).setName(utility.inputString(scan));
                    System.out.println("nhap dia chi:");
                    bookUser.get(key).setPhoneNumber(utility.inputString(scan));
                    System.out.println("Nhap sdt: ");
                    bookUser.get(key).setPhoneNumber(utility.inputString(scan));
                } else {
                    System.out.println("khong tim thay lam lai ? y/n");
                    choice = utility.inputString(scan);
                }
            }
        }

        while (choice.equalsIgnoreCase("y"));
    }

    @Override
    public void delete(Scanner scan, Map<Integer, User> bookUser) {
        String choice = "";
        do {
            System.out.println("Nhap ten user muon xoa: ");
            String userFind= utility.inputString(scan);
            Set<Integer> set = bookUser.keySet();
            for (Integer key:
                    set) {
                if (bookUser.get(key).getName().equalsIgnoreCase(userFind)) {
                    bookUser.remove(key);
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

