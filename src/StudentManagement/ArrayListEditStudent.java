package StudentManagement;

import java.util.ArrayList;
import java.util.Objects;

public class ArrayListEditStudent {
    public void editStudent(ArrayList<Student> students, int position, Student object) {
        if (position < 0 || position >= students.size()) {
            throw new IndexOutOfBoundsException("Invalid position: " + position);
        }
        students.set(position, object);
    }

    public void editStudentById(ArrayList<Student> students, String id, Student data) {
        boolean found = false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).id.equals(id)) {
                students.set(i, data);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new IllegalArgumentException("Student ID not found: " + id);
        }
    }
}
