package Student_Grade_Calculator;

import java.util.Scanner;

public class Main 
{

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) 
    {

        String[] subjects = { "ICT", "Programming", "Physics", "English", "Islamiat", "Sociology" };
        int[] marks = new int[subjects.length];

        for (int i = 0; i < subjects.length; i++) 
            {
            while (true) 
                {
                try 
                {
                    System.out.print(subjects[i] + " Marks: ");
                    int m = Integer.parseInt(scan.nextLine());
                    if (m < 0 || m > 100) 
                        {
                        throw new Exception();
                    }
                    marks[i] = m;
                    break;
                } 
                catch (Exception e) 
                {
                    System.out.println("Invalid Marks");
                }
            }
        }

        int total = 0;
        for (int i = 0; i < marks.length; i++) 
            {
            total += marks[i];
        }

        double gpa = Math.round((total / 600.0) * 4 * 100.0) / 100.0;
        String grade;

        if (gpa >= 3.7) 
            {
            grade = "A";
        }
         else if (gpa >= 3.0) 
            {
            grade = "B";
        } 
        else if (gpa >= 2.0) 
            {
            grade = "C";
        } 
        else 
            {
            grade = "F";
        }

        System.out.println("Total Marks: " + total);
        System.out.println("GPA: " + gpa);
        System.out.println("Grade: " + grade);
        scan.close();
    }
}
