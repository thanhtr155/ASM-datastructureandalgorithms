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
        try {
            ArrayListRemoveStudent removeSt = new ArrayListRemoveStudent();
            removeSt.removeStudentById(students, "BH009");
        } catch (IllegalArgumentException e) {
            System.out.println("Error removing student: " + e.getMessage());
        }
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


        ArrayListEditStudent edit = new ArrayListEditStudent();
        ArrayListRemoveStudent removeSt = new ArrayListRemoveStudent();
        ArrayListSearchStudent searchSt = new ArrayListSearchStudent();

        // Test 1: Adding Students
        System.out.println("Testing Student Addition:");

        // Valid addition
        try {
            st.addStudent(students, new Student("BH001", "Tran Tuan Thanh", 8.0));
            System.out.println("Added: BH001");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Invalid mark
        try {
            st.addStudent(students, new Student("BH002", "Invalid Mark", -1.0));
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding student with invalid mark: " + e.getMessage());
        }

        // Duplicate ID
        try {
            st.addStudent(students, new Student("BH001", "Duplicate ID", 7.0));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Test 2: Editing Students
        System.out.println("\nTesting Student Editing:");

        // Valid edit
        try {
            edit.editStudent(students, 0, new Student("BH001", "Updated Name", 9.0));
            System.out.println("Edited student at position 0");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Invalid position
        try {
            edit.editStudent(students, 5, new Student("BH002", "Out of Bounds", 6.5));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Edit by non-existent ID
        try {
            edit.editStudentById(students, "BH999", new Student("BH999", "Non-existent", 5.0));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Test 3: Removing Students
        System.out.println("\nTesting Student Removal:");

        // Valid removal
        try {
            removeSt.removeStudentById(students, "BH001");
            System.out.println("Removed student with ID BH001");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Removal of non-existent ID
        try {
            removeSt.removeStudentById(students, "BH999");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Test 4: Searching for Students
        System.out.println("\nTesting Student Search:");

        // Searching in an empty list
        try {
            searchSt.binarySearch(students, "BH001");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Add a student and search
        try {
            st.addStudent(students, new Student("BH001", "Tran Tuan Thanh", 8.0));
            int index = searchSt.binarySearch(students, "BH001");
            System.out.println("Found student at index: " + index);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
