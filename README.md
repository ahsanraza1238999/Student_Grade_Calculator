# Student Grade Calculator (Java CLI)

This project is a **CLI-based Student Grade Calculator** written in Java. It uses basic programming concepts and stores student records in a text file. The system allows adding, viewing, updating, and removing student data.

## Features

* Add student basic information
* Enter marks of multiple subjects
* Calculate total marks
* Calculate GPA
* Assign grade based on GPA
* Update any stored student record
* Remove student data
* Data persistence using a `.txt` file

## Rules Followed

* CLI based program
* No OOP concepts used (only `public class Main`)
* Uses basic Java concepts only:

  * Conditions
  * Loops
  * Functions
  * Recursion (allowed)
  * Try-catch
  * File handling
* Simple, human-like logic
* No code comments

## Subjects Included

* ICT
* Programming Fundamentals
* Physics
* English
* Islamiat
* Sociology

## File Used

The program automatically creates and uses:

* `students.txt`

## Data Format

Each student record is stored in the following format:

```
Name,Roll,Class,ICT,PF,Physics,English,Islamiat,Sociology,Total,GPA,Grade
```

Example:

```
Ahsan,23-CS-11,BSSE-A,85,90,78,88,92,80,513,3.42,B
```

## How to Run

1. Make sure Java is installed on your system
2. Compile the program:

```
javac Main.java
```

3. Run the program:

```
java Main
```

## Menu Options

* Add Student
* View Students
* Update Student
* Remove Student
* Exit

## Notes

* GPA is calculated out of 4.0
* Grade is assigned based on GPA
* All data is stored locally in text file

This project is suitable for academic submission and basic Java CLI practice.
