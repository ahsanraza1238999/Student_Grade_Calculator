package Student_Grade_Calculator;

import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1 Add Student");
            System.out.println("2 View Students");
            System.out.println("3 Update Student");
            System.out.println("4 Remove Student");
            System.out.println("5 Exit");
            System.out.print("Choice: ");

            String ch = sc.nextLine();

            if (ch.equals("1")) {
                addStudent();
            } else if (ch.equals("2")) {
                showAll();
            } else if (ch.equals("3")) {
                updateStudent();
            } else if (ch.equals("4")) {
                removeStudent();
            } else if (ch.equals("5")) {
                break;
            }
        }
    }

    static void addStudent() {
        try {
            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Roll No: ");
            String roll = sc.nextLine();

            System.out.print("Class Section: ");
            String cls = sc.nextLine();

            int ict = getMarks("ICT");
            int pf = getMarks("Programming");
            int phy = getMarks("Physics");
            int eng = getMarks("English");
            int isl = getMarks("Islamiat");
            int soc = getMarks("Sociology");

            int total = ict + pf + phy + eng + isl + soc;
            double gpa = calcGpa(total);
            String grade = calcGrade(gpa);

            FileWriter fw = new FileWriter("students.txt", true);
            fw.write(name + "," + roll + "," + cls + "," +
                    ict + "," + pf + "," + phy + "," + eng + "," + isl + "," + soc + "," +
                    total + "," + gpa + "," + grade + "\n");
            fw.close();

            System.out.println("Saved");
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    static int getMarks(String sub) {
        while (true) {
            try {
                System.out.print(sub + " Marks: ");
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
            }
        }
    }

    static void showAll() {
        showFile("students.txt");
    }

    static void updateStudent() {
        List<String> list = readLines("students.txt");
        if (list.size() == 0) {
            System.out.println("No Data");
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + " " + list.get(i));
        }

        System.out.print("Select No: ");
        int idx = Integer.parseInt(sc.nextLine()) - 1;
        if (idx < 0 || idx >= list.size())
            return;

        list.remove(idx);
        writeAll("students.txt", list);
        System.out.println("Enter New Data");
        addStudent();
    }

    static void removeStudent() {
        List<String> list = readLines("students.txt");
        if (list.size() == 0) {
            System.out.println("No Data");
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + " " + list.get(i));
        }

        System.out.print("Select No: ");
        int idx = Integer.parseInt(sc.nextLine()) - 1;
        if (idx < 0 || idx >= list.size())
            return;

        list.remove(idx);
        writeAll("students.txt", list);
        System.out.println("Removed");
    }

    static double calcGpa(int total) {
        return Math.round((total / 600.0) * 4 * 100.0) / 100.0;
    }

    static String calcGrade(double g) {
        if (g >= 3.7)
            return "A";
        else if (g >= 3.0)
            return "B";
        else if (g >= 2.0)
            return "C";
        else
            return "F";
    }

    static void showFile(String file) {
        try {
            File f = new File(file);
            if (!f.exists()) {
                System.out.println("No Data");
                return;
            }

            Scanner fs = new Scanner(f);
            while (fs.hasNextLine()) {
                System.out.println(fs.nextLine());
            }
            fs.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    static List<String> readLines(String file) {
        List<String> list = new ArrayList<>();
        try {
            File f = new File(file);
            if (!f.exists())
                return list;

            Scanner fs = new Scanner(f);
            while (fs.hasNextLine()) {
                list.add(fs.nextLine());
            }
            fs.close();
        } catch (Exception e) {
        }
        return list;
    }

    static void writeAll(String file, List<String> list) {
        try {
            FileWriter fw = new FileWriter(file);
            for (String s : list) {
                fw.write(s + "\n");
            }
            fw.close();
        } catch (Exception e) {
        }
    }
}
