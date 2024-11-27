package StudentManagement;

import java.util.ArrayList;
import java.util.Objects;

public class ArrayListRemoveStudent {
    public void removeStudentById(ArrayList<Student> students, String id) {
        boolean found = false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).id.equals(id)) {
                students.remove(i);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new IllegalArgumentException("Student ID not found for removal: " + id);
        }
    }
}


