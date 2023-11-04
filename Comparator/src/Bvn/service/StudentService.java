package Bvn.service;

import Bvn.entites.Student;
import Bvn.utility.Utility;

import java.util.Map;
import java.util.Scanner;

public class StudentService {
    Utility utility = new Utility();
    public Student inputStudent(Scanner scan) {
        Student student = new Student();
        System.out.println("nhap ten: ");
        student.setName(utility.inputString(scan));
        System.out.println("nhap diem: ");
        student.setScore(utility.inputInt(scan));
        return student;
    }

    public void run(Map<Integer,Student> integerStudentMap,Scanner scan) {
        System.out.println("Nhap so hs muon them: ");
        int n= utility.inputInt(scan);
        for (int i = 0; i < n; i++) {
            Student student= inputStudent(scan);
            integerStudentMap.put(student.getId(),student);
        }

    }

    public void removeStudent(int id,Map<Integer,Student> studentMap) {
        if (studentMap.containsKey(id)) {
            studentMap.remove(id);
        }
    }
    
    public void getStudentByIdAndDelete(Map<Integer,Student> studentMap, Scanner scan) {
//        while (true) {
//            System.out.println("Nhap id hs can tim: ");
//            int inputId = Integer.parseInt(scan.nextLine());
//            if (!studentMap.containsKey(inputId)) {
//                System.out.println("k co hs id nay");
//                System.out.println("Tim tiep? y/n");
//                if(utility.inputString(scan).equalsIgnoreCase("n")) {
//                    break;
//                }
//            } else {
//                System.out.println(studentMap.get(inputId));
//                System.out.println("Ban co muon xoa hs nay ? y/n" );
//                if(utility.inputString(scan).equalsIgnoreCase("y")) {
//                    removeStudent(studentMap,studentMap);
//                }
//                break;
//            }
//        }
    }


    public void getAverageScore(Map<Integer,Student> studentMap) {
        int count=studentMap.size();
        double sum=0;
        for (Map.Entry<Integer,Student> entry:
             studentMap.entrySet()) {
              sum+=entry.getValue().getScore();
        }
        System.out.println("Diem trung binh hoc sinh la: "+ (sum/count));
    }

}
