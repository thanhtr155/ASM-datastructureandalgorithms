package StudentManagement;

import java.util.ArrayList;
import java.util.Objects;

public class ArrayListRemoveStudent {
    public void removeStudentById(ArrayList<Student> students, String id){
        for (int i = 0; i < students.size(); i++) {
            if(Objects.equals(students.get(i).id, id)){
                students.remove(i);
            }
        }
    }
}
