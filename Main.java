import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Subject> subjects = new ArrayList<>();

        subjects.add(new Subject("COA", 72, 1));
        subjects.add(new Subject("OS", 72, 1));
        subjects.add(new Subject("Seminar", 48, 1));
        subjects.add(new Subject("DM", 72, 1));
        subjects.add(new Subject("Java", 72, 1));
        subjects.add(new Subject("TWS", 48, 1));
        subjects.add(new Subject("ESS", 72, 1));

        ArrayList<Department> departments = new ArrayList<>();

        departments.add(new Department("CP", 1));
        departments.add(new Department("IT", 2));
        departments.add(new Department("CSD", 3));
        departments.add(new Department("AI", 4));

        HashMap<Student, ArrayList<Attendance>> records = new HashMap<>();

        int choice;
        do { 
            System.out.println("\n----Home Page----");
            //System.out.println("1. Add Department");
            System.out.println("1. Add Student");
            //System.out.println("3. Add Subject");
            System.out.println("2. Mark Attendance");
            System.out.println("3. View Report");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1:  
                    System.out.println("Name: ");
                    String name = sc.nextLine();
                    
                    //show department
                    for (int i=0; i < departments.size(); i++) {
                        System.out.println(i + ". " + departments.get(i).getName());
                    }
                    System.out.println("Select Department: ");
                    System.out.println("\nEnter Department Index: ");
                    int deptIndex = sc.nextInt();
                    Department selectedDept = departments.get(deptIndex); 
                    //using department class object to get access to the list of department

                    Student s = new Student(name, selectedDept); //adding students in specified department 
                    students.add(s); //added students to 'students' list 
                    selectedDept.addStudent(s); //used dept object to add the students in specified dept 

                    records.put(s, new ArrayList<>()); 

                    System.out.println("Student added.");
                    break;
                case 2: 
                    if (students.isEmpty()) {
                        System.out.println("Add Students and subjects first. \nThank you.");
                        break;
                    }
                    for (Student stu : students ) {
                        ArrayList<Attendance> studentRecords = records.get(stu); 
                        
                        for(Subject sub : subjects ) {
                            if (sub.getDeptIndex() == stu.getDepartment().getDeptIndex()) {
                                System.out.println("\nEnter attendance for " + stu.getName() + " in " + sub.getSubjectName());
                                System.out.println("Classes Attended: ");
                                int attended = sc.nextInt();
                                studentRecords.add(new Attendance(stu, sub, attended));
                            }
                        }
                    }
                    System.out.println("Attendance Marked.");
                    break;
                case 3: 
                    System.out.println("\n-----Student Deets-----");
                    for (Department dept : departments ) {
                        System.out.println("\n-------------------------");
                        System.out.println("Department: " + dept.getName());

                        for (Student stu : students ) {
                            if (stu.getDepartment() == dept) {
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
                }        
                break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("invalid choice. \nPlease try again.");
            }
        } 
        while (choice != 4);
        sc.close();
    }
}