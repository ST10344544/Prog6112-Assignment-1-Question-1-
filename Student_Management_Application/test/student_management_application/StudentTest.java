
package student_management_application;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StudentTest {
    
         @Before
         public void setUp() 
         {
                  Student.clearStudentList(); 
         }

         @Test
         public void testSaveStudent() 
         {
                  Student.addStudentForTesting(1, "Lee Roy", 20, "leeroy@example.com", "Math");
                  assertEquals(1, Student.getAllStudents().size());
         }


         @Test
         public void testSearchStudent() 
         {
                  Student student = new Student(1, "Lee Roy", 20, "leeroy@example.com", "Math");
                  Student.addStudentForTesting(student);
                  Student foundStudent = Student.SearchStudent();
                  assertEquals("Jane Smith", foundStudent.getName());
         }

         @Test
                  public void testSearchStudent_StudentNotFound() 
                  {
                  Student foundStudent = Student.SearchStudent();
                  assertNull(foundStudent);
         }

         @Test
         public void testDeleteStudent() 
         {
                  Student student = new Student(1, "Lee Roy", 20, "leeroy@example.com", "Math");
                  Student.addStudentForTesting(student);
                  Student.DeleteStudent();
                  assertNull(Student.SearchStudent());
         }

         @Test
         public void testDeleteStudent_StudentNotFound()
         {
                  Student.DeleteStudent();
                  assertNull(Student.SearchStudent());
         }

         @Test
         public void testStudentAge_StudentAgeValid()
         {
                  Student.addStudentForTesting(1, "Lee Roy", 20, "leeroy@example.com", "Math");
                  assertEquals(1, Student.getAllStudents().size());
         }

         @Test
         public void testStudentAge_StudentAgeInvalid() 
         {
                  Student.addStudentForTesting(1, "Lee Roy", 20, "leeroy@example.com", "Math");
                  assertEquals(1, Student.getAllStudents().size());
         }

         @Test
         public void testStudentAge_StudentAgeInvalidCharacter() {
                  Student.addStudentForTesting(1, "Lee Roy", 20, "leeroy@example.com", "Math");
                  assertEquals(1, Student.getAllStudents().size());
         }

   
}



