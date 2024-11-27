import StudentManagement.*;
import java.util.ArrayList;

public class TestStudentManagement {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        ArrayListAddStudent st = new ArrayListAddStudent();
        ArrayListEditStudent edit = new ArrayListEditStudent();
        ArrayListRemoveStudent removeSt = new ArrayListRemoveStudent();
        ArrayListSearchStudent searchSt = new ArrayListSearchStudent();

        // Test 1: Adding Students
        System.out.println("Testing Student Addition:");

        // Test Case 1.1: Valid Student Addition
        try {
            st.addStudent(students, new Student("BH001", "Tran Tuan Thanh", 8.0));
            System.out.println("Added: BH001");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Test Case 1.2: Invalid Mark (Below 0)
        try {
            st.addStudent(students, new Student("BH002", "Invalid Mark", -1.0));
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding student with invalid mark: " + e.getMessage());
        }

        // Test Case 1.3: Invalid Mark (Above 10)
        try {
            st.addStudent(students, new Student("BH003", "Invalid Mark", 11.0));
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding student with invalid mark: " + e.getMessage());
        }

        // Test Case 1.4: Duplicate ID
        try {
            st.addStudent(students, new Student("BH001", "Duplicate ID", 7.0));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Test 2: Editing Students
        System.out.println("\nTesting Student Editing:");

        // Test Case 2.1: Valid Edit
        try {
            edit.editStudent(students, 0, new Student("BH001", "Updated Name", 9.0));
            System.out.println("Edited student at position 0");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Test Case 2.2: Invalid Position
        try {
            edit.editStudent(students, 5, new Student("BH002", "Out of Bounds", 6.5));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Test Case 2.3: Edit by Non-existent ID
        try {
            edit.editStudentById(students, "BH999", new Student("BH999", "Non-existent", 5.0));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Test 3: Removing Students
        System.out.println("\nTesting Student Removal:");

        // Test Case 3.1: Valid Removal
        try {
            removeSt.removeStudentById(students, "BH001");
            System.out.println("Removed student with ID BH001");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Test Case 3.2: Removal of Non-existent ID
        try {
            removeSt.removeStudentById(students, "BH999");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Test 4: Searching for Students
        System.out.println("\nTesting Student Search:");

        // Test Case 4.1: Searching in an Empty List
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
