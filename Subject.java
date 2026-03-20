public class Subject {
    private String subjectName;
    private int totalClasses;

    public Subject(String subjectName, int totalClasses) {
        this.subjectName = subjectName;
        this.totalClasses = totalClasses;
    }

    public String getSubjectName() {
        return subjectName;
    }
    public int getTotalClasses() {
        return totalClasses;
    }
}
