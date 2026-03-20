import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Subject> subjects = new ArrayList<>();
        ArrayList<Department> departments = new ArrayList<>();
        HashMap<Student, ArrayList<Attendance>> records = new HashMap<>();

        int choice;
        do { 
            System.out.println("\n----Home Page----");
            System.out.println("1. Add Department");
            System.out.println("2. Add Student");
            System.out.println("3. Add Subject");
            System.out.println("4. Mark Attendance");
            System.out.println("5. View Report");
            System.out.println("6. Exit");
            System.out.println("Enter your choice: ");
            
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1: 
                    System.out.println("Enter Department name: ");
                    String deptName = sc.nextLine();
                    
                    departments.add(new Department(deptName));
                    System.out.println("Department added.");
                    break;
                case 2:  
                    if (departments.isEmpty()) {
                        System.out.println("Add department first.");
                        break;
                    }
                    System.out.println("Name: ");
                    String name = sc.nextLine();
                    
                    //show department
                    for (int i=0; i < departments.size(); i++) {
                        System.out.println(i + ". " + departments.get(i).getName());
                    }
                    System.out.println("Select Department: ");
                    int deptIndex = sc.nextInt();
                    Department selectedDept = departments.get(deptIndex);

                    Student s = new Student(name, selectedDept);
                    students.add(s);
                    selectedDept.addStudent(s);

                    records.put(s, new ArrayList<>());

                    System.out.println("Student added.");
                    break;
                case 3: 
                    System.out.println("Enter Subject name: ");
                    String subName = sc.nextLine();
                    System.out.println("Total classes: ");
                    int total = sc.nextInt();
                    subjects.add(new Subject(subName, total));
                    
                    System.out.println("Subject added.");
                    break;
                case 4: 
                    if (students.isEmpty() || subjects.isEmpty()) {
                        System.out.println("Add Students and subjects first. \nThank you.");
                        break;
                    }
                    for (Student stu : students ) {
                        ArrayList<Attendance> studentRecords = records.get(stu); 
                        
                        for(Subject sub : subjects ) {
                            System.out.println("\nEnter attendance for " + stu.getName() + " in " + sub.getSubjectName());
                            System.out.println("Classes Attended: ");
                            int attended = sc.nextInt();
                            studentRecords.add(new Attendance(stu, sub, attended));
                        }
                    }
                    System.out.println("Attendance Marked.");
                    break;
                case 5: 
                    System.out.println("\n-----Student Deets-----");
                    for (Department dept : departments ) {
                        System.out.println("\n-------------------------");
                        System.out.println("Department: " + dept.getName());

                        for (Student stu : students ) {
                            System.out.println("\n-------------------------");
                            System.out.println("Student: " + stu.getName());
                            System.out.println("Enrolment Number: " + stu.getEnrolmentNumber());

                            ArrayList<Attendance> studentRecords = records.get(stu);

                            for (Attendance a : studentRecords ) {
                                double percentage = a.calculatePercentage();
                                System.out.println("\nSubject: " + a.getSubject().getSubjectName());
                                System.out.println("Attendance: " + percentage + "%");

                                if (a.isEligible()) {
                                    System.out.println("Eligible for exams.");
                                }
                                else {
                                    System.out.println("Not Eligible for exams.");
                                    System.out.println("Needs " + a.classesNeeded() + " classes to meet the eligibility criteria.");
                                }
                            }
                        }
                    }
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("invalid choice. \nPlease try again.");
            }
        } 
        while (choice != 5);
        sc.close();
    }
}