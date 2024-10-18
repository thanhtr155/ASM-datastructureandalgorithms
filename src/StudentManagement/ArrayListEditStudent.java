package StudentManagement;

import java.util.ArrayList;
import java.util.Objects;

public class ArrayListEditStudent {
    public void editStudent(ArrayList<Student> students, int position, Student object){
        students.set(position, object);
    }

    public void editStudentById(ArrayList<Student> students, String id, Student data){
        for (int i = 0; i < students.size(); i++){
            if(Objects.equals(students.get(i).id, id)){
                students.set(i,data);
            }
        }
    }
}
