import StudentManagement.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<Student>();
        ArrayListAddStudent st = new ArrayListAddStudent();
        System.out.println("****** Add Student ********");
        try {
            st.addStudent(students, new Student("BH001", "Tran Tuan Thanh", 8.0));
            st.addStudent(students, new Student("BH002", "Nguyen Tien Nam", 7.5));
            st.addStudent(students, new Student("BH003", "Tran Viet Anh", 6.0));
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
        System.out.println("********* List data of students **********");
        for (Student s : students){
            System.out.println("ID = " + s.id +" , fullName = " + s.fullName + " , mark = " + s.mark + " , rank = " + s.rank);
        }

        System.out.println("********************** Edit Student ****************************");
        try {
            ArrayListEditStudent edit = new ArrayListEditStudent();
            edit.editStudent(students, 1, new Student("BH009", "Nguyen Manh Hung", 4));
        } catch (Exception e) {
            System.out.println("Error editing student: " + e.getMessage());
        }
        System.out.println("********* List data of students after updated **********");
        for (Student s : students){
            System.out.println("ID = " + s.id +" , fullName = " + s.fullName + " , mark = " + s.mark + " , rank = " + s.rank);
        }
        System.out.println("********* Edit Student By Id **********");
        try {
            ArrayListEditStudent edit = new ArrayListEditStudent();
            edit.editStudentById(students, "BH009", new Student("BH009", "Ngo Phuong Nam", 9.0));
        } catch (Exception e) {
            System.out.println("Error editing student: " + e.getMessage());
        }
        System.out.println("********* List data of students after updated by ID **********");
        for (Student s : students){
            System.out.println("ID = " + s.id +" , fullName = " + s.fullName + " , mark = " + s.mark + " , rank = " + s.rank);
        }
        System.out.println("********************* Remove Student ***************************");
        ArrayListRemoveStudent removeSt = new ArrayListRemoveStudent();
        removeSt.removeStudentById(students, "BH009");
        System.out.println("********* List data of students after removed by ID **********");
        for (Student s : students){
            System.out.println("ID = " + s.id +" , fullName = " + s.fullName + " , mark = " + s.mark + " , rank = " + s.rank);
        }
        System.out.println("********************* Binary Search Student By Id ***************************");
        try {
            ArrayListSearchStudent searchSt = new ArrayListSearchStudent();
            String numberId = "BH001";
            int findSt = searchSt.binarySearch(students, numberId);
            if (findSt == -1) {
                System.out.println("Cannot find ID = " + numberId);
            } else {
                System.out.println("Found ID = " + numberId);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error searching student: " + e.getMessage());
        }

        System.out.println("************** Sort Student by ID ***************");
        Collections.sort(students, Student.IdStudentComparator);
        System.out.println("********* After sort *************");
        for (Student str : students){
            System.out.println(str);
        }
        System.out.println("************** Sort Student by Full name ***************");
        Collections.sort(students, Student.FullNameStduComparator);
        System.out.println("********* After sort *************");
        for (Student str : students){
            System.out.println(str);
        }
        System.out.println("************** Sort Student by mark ***************");
        Collections.sort(students, Student.MarkStduComparator);
        System.out.println("********* After sort *************");
        for (Student str : students){
            System.out.println(str);
        }
    }
}