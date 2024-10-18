package StudentManagement;

import java.util.ArrayList;
import java.util.Objects;

public class ArrayListSearchStudent {
    public int binarySearch(ArrayList<Student> students, String id){
        int left = 0;
        int right = students.size() - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (Objects.equals(students.get(mid).id, id)) {
                return mid;
            }
            int compareStr = students.get(mid).id.compareToIgnoreCase(id);
            if(compareStr < 0){
                left = mid + 1;
            } else if (compareStr > 0){
                right = mid - 1;
            }
        }
        return  -1;
    }
}
