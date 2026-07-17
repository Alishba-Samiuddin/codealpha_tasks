package SMST;

import java.util.Scanner;

public class StudentMannagmentSystem{

public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    StudentManager manager = new StudentManager();
    int choice;
    do {
        System.out.println("\n===========STUDENT MANAGMENT SYSTEM===========");
        System.out.println("1. Add Student");
        System.out.println("2. Remove Student");
        System.out.println("3. Update Student Marks");
        System.out.println("4. Display Report");
        System.out.println("5. Exit");
        System.out.println("Enter Your Choice: ");
        choice = input.nextInt();
        input.nextLine();
        switch (choice) {
            case 1:
                // SMST.Student Name
                System.out.print("Enter Student Name: ");
                String name = input.nextLine();
                // Roll Number
                System.out.print("Enter Roll Number: ");
                int rollno = input.nextInt();
                //Subjects
                System.out.print("Enter Number of Subjects: ");
                int numberOfSubjects = input.nextInt();
                double[] marks = new double[numberOfSubjects];
                // Input Marks
                for (int i = 0; i < marks.length; i++) {
                    System.out.print("Enter Marks of Subject " + (i + 1) + ": ");
                    marks[i] = input.nextDouble();

                    while (marks[i] < 0 || marks[i] > 100) {
                        System.out.print("Invalid! Enter marks between 0 and 100: ");
                        marks[i] = input.nextDouble();
                    }
                }
                input.nextLine();
                // Create SMST.Student Object
                Student student = new Student(name, marks, rollno);
                student.calculatedResults();
                manager.addStudent(student);
                break;

            case 2:
                System.out.print("Enter Roll Number to Remove: ");
                int removeRollno = input.nextInt();
                input.nextLine();
                manager.removeStudent(removeRollno);
                break;
            case 3:
                System.out.print("Enter Roll Number to Update: ");
                int updateRollno = input.nextInt();
                System.out.print("Enter Number of Subjects: ");
                int subjects = input.nextInt();
                double[] newMarks = new double[subjects];
                for (int i = 0; i < newMarks.length; i++) {
                    System.out.print("Enter Marks of Subject " + (i + 1) + ": ");
                    newMarks[i] = input.nextDouble();
                    while (newMarks[i] < 0 || newMarks[i] > 100) {
                        System.out.print("Invalid! Enter marks between 0 and 100: ");
                        newMarks[i] = input.nextDouble();
                    }
                }
                input.nextLine();
                manager.updateStudent(updateRollno, newMarks);
                break;
            case 4:
                manager.displayreport();
                break;
            case 5:
                System.out.println("Thank you for using SMST.Student Mannagment System.");
                break;
            default:
                System.out.println("Invalid Menu Choice!");
        }
        }
        while (choice != 5) ;
        input.close();
    }
}

