package StudentManagement;

import java.util.ArrayList;

public class ArrayListAddStudent {
    public void addStudent(ArrayList<Student> students, Student objectData) {
        for (Student student : students) {
            if (student.id.equals(objectData.id)) {
                throw new IllegalArgumentException("Student ID already exists: " + objectData.id);
            }
        }
        students.add(objectData);
    }
}


