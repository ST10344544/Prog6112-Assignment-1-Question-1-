
package student_management_application;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Student {
    
         public static int id;
         public String name;
         public int age;
         public String email;
         public String course;

         static Scanner kb = new Scanner(System.in);
         static ArrayList<Student> studentList = new ArrayList<>();
    
         public Student(int id, String name, int age, String email, String course) {
                  this.id = id;
                  this.name = name;
                  this.age = age;
                  this.email = email;
                  this.course = course;
         }
         //getters
         public int getId() { return id; }
         public String getName() { return name; }
         public int getAge() { return age; }
         public String getEmail() { return email; }
         public String getCourse() { return course; }
    
         public static void SplashScreen()
         {
                  //Scanner kb = new Scanner(System.in);
                  System.out.println("STUDENT MANAGEMENT APPLICATION\n"
                                    + "******************************************\n"
                                    + "Enter (1) to launch menu or any other key to exit");
                  int answer = kb.nextInt();
                  if(answer == 1)
                  {
                           Menu();
                  }else{
                           ExitStudentApplication();
                  }
    }//SplashScreen End
    
         public static void Menu()
         {
                  System.out.println("\nPlease select one of the following menu items:\n"
                           + "(1)  Capture a new student.\n"
                           + "(2)  Search for a student.\n"
                           + "(3)  Delete a student.\n"
                           + "(4)  Print student report.\n"
                           + "(5)  Exit Application.");
                  int choice = kb.nextInt();
         
                  switch (choice)
                  {
                           case 1:   SaveStudent();
                                    break;
                           case 2:   SearchStudent();
                                    break;
                           case 3:   DeleteStudent();
                                    break;
                           case 4:   StudentReport();
                                    break;
                           case 5:   ExitStudentApplication();
                                    break;
                           default:  System.out.println("\nPLEASE ENTER A VALID MENU OPTION!!!\n");
                                    Menu();
                           break;
                  }
    }//Menu end
    
         public static void SaveStudent() {
                  System.out.println("\nCAPTURE A NEW STUDENT\n" + "***************************");

                  int id;
                  String name;
                  int age;
                  String email;
                  String course;

                  while (true) 
                  {
                  try {
                           System.out.print("Enter the student id: ");
                           id = kb.nextInt();

                           System.out.print("Enter the student name: ");
                           name = kb.next();

                           System.out.print("Enter the student age: ");
                           age = kb.nextInt();

                           if (age < 16) 
                           {
                                    System.out.println("You have entered an incorrect student age! Please re-enter the student age.");
                                    continue;
                           }

                           System.out.print("Enter the student email: ");
                           email = kb.next(); 

                           System.out.print("Enter the student course: ");
                           course = kb.next(); 

                           break; 
                           } catch (InputMismatchException e) {
                                    System.out.println("Invalid input! Please enter the correct format.");
                                    kb.nextLine(); 
                           }
    }

   
                  Student newStudent = new Student(id, name, age, email, course);
                  studentList.add(newStudent);
                  Menu();
}
//savestudent end
    
         public static Student SearchStudent()
         {
                  System.out.print("Enter the student id to search: ");
                  int searchId = kb.nextInt();
                  System.out.println("--------------------------------------");
                  Student searchStudent = null;
                  for (Student student : studentList) {
                  if (student.getId() == searchId) {
                  searchStudent = student;
                  break; 
                  }
         }
    
                  if (searchStudent != null) {
        
                           System.out.println("STUDENT ID: " + searchStudent.getId());
                           System.out.println("STUDENT NAME: " + searchStudent.getName());
                           System.out.println("STUDENT AGE: " + searchStudent.getAge());
                           System.out.println("STUDENT EMAIL: " + searchStudent.getEmail());
                           System.out.println("STUDENT COURSE: " + searchStudent.getCourse());
        
                  } else {
                           System.out.println("Student with Student Id: " + searchId + " was not found!");
                  }
                  System.out.println("-------------------------------------");
                  System.out.println("Enter (1) to launch menu or any other key to exit");
                  int answer = kb.nextInt();
                  if(answer == 1)
                  {
                           Menu();
                  }else{
                           ExitStudentApplication();
                  } return null;
         }//searchstudent() end
    
         public static void DeleteStudent()
         {
  
                  System.out.print("Enter the student id to delete: ");
                  int delete = kb.nextInt();
  
                  Student studentDelete = null;
                  for (Student student : studentList) {
                  if (student.getId() == delete) {
                           studentDelete = student;
                           break;
                  }
         }
    
                  if (studentDelete != null) {

                           System.out.println("Are you sure you want to delete "+ studentDelete.getId() +" from the system? (y/n): ");
                           String yesNo = kb.next();
                           if (yesNo.equalsIgnoreCase("y"))
                           {
                                    studentList.remove(studentDelete);
                                    System.out.println("------------------------------------------------------------");
                                    System.out.println("Student with Student Id: " + delete + " WAS deleted!");
                                    System.out.println("------------------------------------------------------------");
                           } else {
                                    System.out.println("Student profile was saved from termination, stay safe kids.");
                           }
       
                  } else {
                           System.out.println("Student with ID " + delete + " was not found.");
                  }
     
                  System.out.println("Enter (1) to launch menu or any other key to exit");
                  int answer = kb.nextInt();
                  if(answer == 1)
                  {
                           Menu();
                  }else{
                           ExitStudentApplication();
                  }
         }//deletestudent() end
    
         public static void StudentReport()
         {
  
                  if (studentList.isEmpty()) {
                           System.out.println("Please add students before requesting a report");
                  } else {
                           int studentNumber = 1;
                           for (Student student : studentList) {
                           System.out.println("STUDENT " + studentNumber);
                           System.out.println("-------------------------------------------------");
                           System.out.println("STUDENT ID: " + student.getId());
                           System.out.println("STUDENT NAME: " + student.getName());
                           System.out.println("STUDENT AGE: " + student.getAge());
                           System.out.println("STUDENT EMAIL: " + student.getEmail());
                           System.out.println("STUDENT COURSE: " + student.getCourse());
                           System.out.println("-------------------------------------------------");
                           studentNumber++;
                           }
                  }
         }//studentreport() end
   
         public static List<Student> getAllStudents() {
                  return studentList;
         }

         public static void clearStudentList() {
                  studentList.clear();
         }



         public static void addStudentForTesting(Student student) {
                  studentList.add(student);
         }

         public static void ExitStudentApplication()
         {
                  System.out.println("Thank you, come again.");
                           System.exit(0);
         }//exitStudentapplication end
    
         public static void addStudentForTesting(int id, String name, int age, String email, String course) {
                  Student newStudent = new Student(id, name, age, email, course);
                  studentList.add(newStudent);
         }

}//class end
