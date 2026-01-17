// JAVA MINI PROJECT – Student Management System
package mypackage2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

// Student class
class Student {
    private int id;
    private String name;
    private String course;

    // Constructor
    public Student(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    // Getter for ID
    public int getId() {
        return id;
    }

    // Override toString for easy display
    @Override
    public String toString() {
        return "ID=" + id + ", Name=" + name + ", Course=" + course;
    }
}

// Management class
class Management {
    private ArrayList<Student> students;

    // Constructor
    public Management() {
        students = new ArrayList<Student>();
    }

    // Add student
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully.");
    }

    // View all students
    public void viewStudent() {
        if (students.isEmpty()) {
            System.out.println("No students added yet.");
        } else {
            System.out.println("List of students:");
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    // Search student by ID
    public void searchStudent(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                System.out.println("Student Found: " + s);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Delete student by ID
    public void deleteStudent(int id) {
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            Student s = it.next();
            if (s.getId() == id) {
                it.remove();
                System.out.println("Student removed successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }
}

// Main class
public class Revision2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Management mg = new Management();
        int choice;

        do {
            System.out.println("\n--- Student Management Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Delete Student by ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    Student st = new Student(id, name, course);
                    mg.addStudent(st);
                    break;

                case 2:
                    mg.viewStudent();
                    break;

                case 3:
                    System.out.print("Enter ID to search: ");
                    int idSearch = sc.nextInt();
                    mg.searchStudent(idSearch);
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int idDelete = sc.nextInt();
                    mg.deleteStudent(idDelete);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Enter a valid choice (1-5).");
                    break;
            }

        } while (choice != 5);

        sc.close();
    }
}
