package StudentManagementProject;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
public class StudentManagement {

	public static void main(String[] args) {
		ArrayList<Student> students = new ArrayList<>();

        try {
        	BufferedReader br = new BufferedReader(
        			new FileReader("students.txt.txt"));

            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                String usn = data[0];
                String name = data[1];
                String branch = data[2];
                int sem = Integer.parseInt(data[3]);
                String college = data[4];
                int marks = Integer.parseInt(data[5]);

                students.add(new Student(usn, name, branch, sem, college, marks));
            }

            br.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("========================================");
        System.out.printf("%-12s %-15s %-8s %-5s %-30s %-5s%n",
                "USN", "NAME", "BRANCH", "SEM", "COLLEGE", "MARKS");
        System.out.println("========================================");

        students.forEach(System.out::println);

        List<Student> sorted = students.stream()
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());

        System.out.println("\nStudents Sorted By Name");
        System.out.println("========================================");
        System.out.printf("%-12s %-15s %-8s %-5s %-30s %-5s%n",
                "USN", "NAME", "BRANCH", "SEM", "COLLEGE", "MARKS");
        System.out.println("========================================");

        sorted.forEach(System.out::println);
    }
}

