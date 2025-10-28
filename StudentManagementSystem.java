import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagement {

    // Student class (represents one student)
    static class Student {
        private int id;
        private String name;
        private int age;
        private String course;

        public Student(int id, String name, int age, String course) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.course = course;
        }

        public int getId() {
            return id;
        }

        @Override
        public String toString() {
            return "Student ID: " + id +
                    "\nName: " + name +
                    "\nAge: " + age +
                    "\nCourse: " + course + "\n";
        }
    }

    // Student Manager class
    static class StudentManager {
        private List<Student> students = new ArrayList<>();

        public void addStudent(Student s) {
            students.add(s);
            System.out.println("Student added successfully!\n");
        }

        public void viewAllStudents() {
            if (students.isEmpty()) {
                System.out.println("No students found.\n");
            } else {
                System.out.println("\n=== Student List ===");
                for (Student s : students) {
                    System.out.println(s);
                }
            }
        }

        public void searchStudentById(int id) {
            for (Student s : students) {
                if (s.getId() == id) {
                    System.out.println("\nStudent found:\n" + s);
                    return;
                }
            }
            System.out.println("No student found with ID " + id + "\n");
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        int choice;

        do {
            System.out.println("=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    manager.addStudent(new Student(id, name, age, course));
                    break;

                case 2:
                    manager.viewAllStudents();
                    break;

                case 3:
                    System.out.print("Enter Student ID to search: ");
                    int searchId = sc.nextInt();
                    manager.searchStudentById(searchId);
                    break;

                case 4:
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.\n");
            }
        } while (choice != 4);

        sc.close();
    }
}
