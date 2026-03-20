public class Student {
    private int enrolment_number;
    private String name;
    private Department department;
    static int counter = 1000;

    public Student(String name, Department department) {
        this.enrolment_number = ++counter;
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