public class Attendance {
    private Student student;
    private Subject subject;
    private int attendedClasses;

    public Attendance(Student student, Subject subject, int attendedClasses) {
        this.student = student;
        this.subject = subject;
        this.attendedClasses = attendedClasses;
    }
    
    public double calculatePercentage() {
        return (attendedClasses * 100) / subject.getTotalClasses();
    }
    public boolean isEligible() {
        return calculatePercentage() >= 75;
    }
    public int classesNeeded() {
        if (isEligible()) {
            return 0;
        }
        
        int total = subject.getTotalClasses();
        int required = (int)Math.ceil(0.75 * total);

        return Math.max(0, required - attendedClasses);
    }
    public Subject getSubject() {
        return subject;
    }

    public void display() {
        double percentage = calculatePercentage();
        System.out.println("\nStudent: " + student.getName());
        System.out.println("Subject: " + subject.getSubjectName());
        System.out.println("Attendance: " + percentage + "%");

        if (isEligible()) {
            System.out.println("Eligible for exams.");
        }
        else {
            System.out.println("Not Eligible for exams.");
            System.out.println("Needs " + classesNeeded() + " more classes to be eligible for exams.");
        }
    }
}