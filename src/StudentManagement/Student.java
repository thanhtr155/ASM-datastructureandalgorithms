package StudentManagement;

import java.util.Comparator;

public class Student  {
    public String fullName;
    public String id;
    public double mark;
    public String rank;

    public Student(String id, String fullName, double mark){
        this.id = id;
        this.fullName = fullName;
        this.mark = mark;
        if(this.mark >= 0 && this.mark <5){
            this.rank = "Fail";
        } else if (this.mark >=5 && this.mark < 6.5) {
            this.rank = "Medium";
        } else if (this.mark >= 6.5 && this.mark < 7.5) {
            this.rank = "Good";
        } else if (this.mark >= 7.5 && this.mark < 9) {
            this.rank = "Very Good";
        } else if(this.mark >= 9 && this.mark <= 10){
            this.rank = "Excellent";
        } else {
            this.rank = null;
        }
    }
    //getter and setter java for fullname
    public String getFullName(){
        return fullName;
    }
    public void setFullName(String fullName){
        this.fullName = fullName;
    }
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    public double getMark(){
        return mark;
    }
    public void setMark(double mark){
        this.mark = mark;
    }

    /*
    @Override
    public int compareTo(Student compareStu) {
        if(this.mark < compareStu.getMark()){
            return  -1;
        } else if (compareStu.getMark() < this.mark) {
            return 1;
        }
        return 0;
    }
     */
    public static Comparator<Student> IdStudentComparator = new Comparator<Student>() {
        public int compare(Student o1, Student o2) {
            String idStu1 = o1.getId().toUpperCase();
            String idStu2 = o2.getId().toUpperCase();
            return  idStu1.compareTo(idStu2);
        }
    };
    public static Comparator<Student> FullNameStduComparator = new Comparator<Student>() {
        public int compare(Student o1, Student o2) {
            String fullName1 = o1.getFullName().toUpperCase();
            String fullName2 = o2.getFullName().toUpperCase();
            return fullName1.compareTo(fullName2);
        }
    };

    public static Comparator<Student> MarkStduComparator = new Comparator<Student>() {
        public int compare(Student o1, Student o2) {
            double mark1 = o1.getMark();
            double mark2 = o2.getMark();
            if(mark1 < mark2){
                return -1;
            } else if (mark2 < mark1) {
                return 1;
            }
            return 0;
        }
    };

    @Override
    public String toString() {
        return "[ID = "+ id +" , fullName = " + fullName + ", mark = " + mark + " , rank  = " + rank + " ]";
    }
}
