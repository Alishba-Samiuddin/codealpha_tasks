package SMST;

import java.util.ArrayList;
    public class StudentManager {

        //Store multiple students.
        private ArrayList<Student> students;

        //Constructor
        public StudentManager() {
            students = new ArrayList<>();
        }

        //Add students
        public void addStudent(Student student) {
            students.add(student);
            System.out.println("Student added successfully");
        }

        //Remove student (By Rollno).
        public void removeStudent(int rollno) {
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getrollno() == rollno) {
                    students.remove(i);
                    System.out.println("Student removed successfully");
                    return;
                }
            }
            System.out.println("Student not found");

        }
        //Update SMST.Student
        public void updateStudent(int rollno,double[] newMarks) {
            for(Student student : students) {
                if (student.getrollno() == rollno) {
                    student.setmarks(newMarks);
                    student.calculatedResults();
                    System.out.println("Student updated successfully");
                    return;
                }
            }
            System.out.println("Student not found");
        }

        public void displayreport() {
            if(students.isEmpty()) {
                System.out.println("No Student Record Found!");
            }
            System.out.println("\n==========STUDENT REPORT==========");
            for (Student s : students) {
                System.out.println("\nStudent Name :" + s.getname());
                System.out.println("Roll Number : " + s.getrollno());

                System.out.println("Marks");

                double[] marks = s.getmarks();

                for (double mark : marks) {
                    System.out.println(" Marks :" + mark);
                }
                System.out.println();
                System.out.printf("Average Marks : %.2f%n", +s.getaverage());
                System.out.println("Highest : " + s.gethighest());
                System.out.println("Lowest : " + s.getlowest());
                System.out.println("Grade : " + s.getgrade());
            }

        }
    }

