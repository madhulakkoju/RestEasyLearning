
package com.TestCases;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import org.junit.Test;

import com.clientTest.ClientTest;
import com.model.Student;
import com.resource.StudentResource;  

public class TestCaseLogic {
	
	String baseUrl = "http://localhost:8080/RestEasyLearning/app/students/";
	@Test
	public void testCheck()
	{
		assertEquals(1,1);
	}
	
	@Test
	public void getStudentsTest()
	{
			
	}
	
	@Test
	public void getStudentTest()
	{
		System.out.println("Get Test");
		ClientTest tester = new ClientTest();
		//Adding a student before Tetsing
		Student testStudent = new Student("GET Test Student","ABCDEFGHI123","7894561230");
		Student returnedStudent = tester.addStudent(testStudent);
		//System.out.println(testStudent +"\n ------->>>>>\n"+returnedStudent);
		assertEquals(testStudent,returnedStudent);
	}
	
	@Test
	public void addStudentTest()
	{
		System.out.println("Add Test");
		ClientTest tester = new ClientTest();
		Student testStudent = new Student("Test Student","A123","7894561230");
		Student addedStudent =tester.addStudent(testStudent);
		assertEquals(testStudent,addedStudent);
	}
	
	@Test
	public void deleteStudentTest()
	{
		System.out.println("Delete Test");
		ClientTest tester = new ClientTest();
		//Adding a student before deleting
		Student testStudent = new Student("Delete Test Student","ABC123","7894561230");
		tester.addStudent(testStudent);
		
		Student deletedStudent = tester.deleteStudent(testStudent.getId());
		//System.out.println(testStudent +"\n ------->>>>>\n"+deletedStudent);
		assertEquals(testStudent,deletedStudent);
	}
	
	@Test
	public void updateStudentTest()
	{
		System.out.println("Update Test");
		ClientTest tester = new ClientTest();
		//Adding a student before deleting
		Student testStudent = new Student("Update Test Student","ABCDEF123","7894561230");
		tester.addStudent(testStudent);
		
		testStudent.setMobile("7777777777");
		Student updatedStudent = tester.updateStudent(testStudent.getId(), testStudent);
		
		if(testStudent.equals(updatedStudent))
			System.out.println("EQUALS");
		assertEquals(testStudent,updatedStudent);
		
	}
	
	public static void main(String[] args) {
		TestCaseLogic tests = new TestCaseLogic();
		tests.addStudentTest();
		tests.deleteStudentTest();
		tests.getStudentTest();
		tests.updateStudentTest();
	}
	
	
	
}
