import java.util.*;
public class Department {
    private String name; //department name
    private ArrayList<Student> students; //list of students 
    private int deptIndex;

    public Department(String name, int deptIndex) {
        this.name = name;
        this.students = new ArrayList<>(); 
        this.deptIndex = deptIndex;
    }

    public String getName() {
        return name;
    }
    public ArrayList<Student> getStudents() {
        return students;
    }
    public int getDeptIndex() {
        return deptIndex;
    }
    public void addStudent(Student s) {
        students.add(s); //adding students to specified department 
    }
}