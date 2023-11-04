package Lab_Thuvien.service;

import java.util.Map;
import java.util.Scanner;

public interface Iservice<T> {
    void insert (Scanner scanner, Map<Integer,T> t);
    void update(Scanner scanner, Map<Integer,T> t);
    void delete (Scanner scanner, Map<Integer,T> t);
}
