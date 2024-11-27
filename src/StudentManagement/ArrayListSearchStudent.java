package StudentManagement;

import java.util.ArrayList;
import java.util.Objects;

public class ArrayListSearchStudent {
    public int binarySearch(ArrayList<Student> students, String id) {
        if (students.isEmpty()) {
            throw new IllegalArgumentException("Student list is empty");
        }
        int left = 0;
        int right = students.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (students.get(mid).id.equals(id)) {
                return mid;
            }
            int compareStr = students.get(mid).id.compareToIgnoreCase(id);
            if (compareStr < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // ID not found
    }
}


