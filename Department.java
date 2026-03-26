import java.util.*;
public class Department {
    private String name; //department name
    private ArrayList<Student> students; //list of students 

    public Department(String name) {
        this.name = name;
        this.students = new ArrayList<>(); 
    }

    public String getName() {
        return name;
    }
    public ArrayList<Student> getStudents() {
        return students;
    }
    public void addStudent(Student s) {
        students.add(s); //adding students to specified department 
    }
}