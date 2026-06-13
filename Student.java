package StudentManagementProject;

public class Student {

    private String usn;
    private String name;
    private String branch;
    private int sem;
    private String college;
    private int marks;

    public Student(String usn, String name, String branch, int sem, String college, int marks) {
        this.usn = usn;
        this.name = name;
        this.branch = branch;
        this.sem = sem;
        this.college = college;
        this.marks = marks;
    }

    public String getUsn() {
        return usn;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return String.format("%-12s %-15s %-8s %-5d %-30s %-5d",
                usn, name, branch, sem, college, marks);
    }
}