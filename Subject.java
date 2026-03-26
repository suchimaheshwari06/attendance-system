public class Subject {
    private String subjectName;
    private int totalClasses;
    int deptIndex;

    public Subject(String subjectName, int totalClasses, int deptIndex) {
        this.subjectName = subjectName;
        this.totalClasses = totalClasses;
        this.deptIndex = deptIndex;
    }

    public String getSubjectName() {
        return subjectName;
    }
    public int getTotalClasses() {
        return totalClasses;
    }
    public int getDeptIndex() {
        return deptIndex;
    }
}
