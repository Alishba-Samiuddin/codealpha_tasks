package SMST;

public class Student {
    //Instance vairables.
    private String name;
    private double[] marks;
    private double average;
    private double highest;
    private double lowest;
    private char grade;
    private int rollno;

    //consturctors.
    public Student(String name, double[]marks, int rollno){
        this.name = name;
        this.marks = marks;
        this.rollno = rollno;
    }

    // Calculate Average,Highest,Lowest marks.
    public void calculatedResults(){
        double total = 0;
        highest = marks[0];
        lowest = marks[0];

        for(int i = 0; i < marks.length; i++){
            total += marks[i];

            if(marks[i] > highest){
                highest = marks[i];
            }
            if(marks[i] < lowest){
                lowest = marks[i];
            }
        }
        average = total / marks.length;

//Grade Calculaion.
        if(average >= 90){
            grade = 'A';
        }
        else if (average >= 80)
        {
            grade = 'B';
        }
        else if (average >= 70)
        {
            grade = 'C';
        }
        else if (average >= 60)
        {
            grade = 'D';
        }
        else
        {
            grade = 'F';
        }
    }

// Getters.
public String getname(){
    return name;
}
public double[] getmarks(){
    return marks;
}
public char getgrade(){
        return grade;
}
public int getrollno(){
        return rollno;
}
public double getaverage(){
    return average;
}
public double gethighest(){
    return highest;
}
public double getlowest(){
    return lowest;
}
public void setmarks(double[] marks){
        this.marks = marks;
}

}






















