public class Student {
    private int enrolment_number;
    private String name;
    private Department department; //object of department class 
    static int counter = 1000; 

    public Student(String name, Department department) { 
        this.enrolment_number = ++counter; //auto generation of enrolment numbers 
        this.name = name;
        this.department = department;
    }

    public int getEnrolmentNumber() {
        return enrolment_number;
    }
    public String getName() {
        return name;
    }
    public Department getDepartment() {
        return department;
    }
}