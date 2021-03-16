package com.clientTest;
import com.model.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
 
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;


import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;



public class ClientTest 
{  
	String baseUrl = "http://localhost:8080/RestEasyLearning/app/students/";
	public Student getStudentFromServer(int id)
	{
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target(baseUrl+id);
		Response response = target.request().get();
		
		Student student =  response.readEntity(Student.class);
		System.out.println( "Student with Given Id - "+id+"  : "+ student);
		response.close();
		return student;
	}
	
	public void getAllStudents() throws JsonParseException, JsonMappingException, IOException
	{
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target(baseUrl);
		
		Response response = target.request().get();
		
		ArrayList<String> students = response.readEntity(ArrayList.class);
		
		System.out.println("As a list of Strings : " +students);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationConfig.Feature.INDENT_OUTPUT);
		Iterator<String> it = students.iterator();
		ArrayList<Student> allStudents = new ArrayList<Student>(students.size());
		while(it.hasNext())
		{
			allStudents.add( mapper.readValue(it.next(),Student.class));
		}
		System.out.println( "As a list of Student Objects : " +allStudents );
		
		//return students;
	}
	
	public Student deleteStudent(String id)
	{
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target(baseUrl+id);
		
		Response response = target.request().delete();
		Student str = response.readEntity(Student.class);
		//System.out.println("Deleted Student Object : "+str);
		return str;
	}
	
	public Student addStudent(Student st)
	{
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target(baseUrl);
		
		Response response = target.request().post(Entity.entity(st, "application/json"));
		//System.out.println("Student Add Status to Response Object : "+response.getStatus());
		Student str = response.readEntity(Student.class);
		return str;
	}
	
	public Student updateStudent(String id,Student st)
	{
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target(baseUrl+st.getId());
		
		Response response = target.request().put(Entity.entity(st, "application/json"));
		//System.out.println("Response Status to update a student id : "+response.getStatus());
		Student str = response.readEntity(Student.class);
		//System.out.println("Student Object Updated as  : "+str);
		return str;
	}
	
	/*
	public static void main(String args[]) throws JsonParseException, JsonMappingException, IOException
	{
		System.out.println("TESTER");
		ClientTest tester = new ClientTest();
		//Student with Id 2 returned.
		tester.getStudentFromServer(2);
		System.out.println();
		
		System.out.println("ALL STUDENTS");
		tester.getAllStudents();
		System.out.println();
		
		Student st = new Student("raj","4","9874563210");
		tester.addStudent(st);
		System.out.println();
		
		tester.getAllStudents();
		System.out.println();
		
		tester.deleteStudent("4");
		System.out.println();
		
		Student st3 = new Student("raj","4","9874563210");
		tester.addStudent(st3);
		System.out.println();
		tester.getAllStudents();
		System.out.println();
		Student st2 = new Student("Karthik Chalamalasetti","4","9874563210");
		tester.updateStudent(st2);
		System.out.println();
		tester.getAllStudents();
		System.out.println();
		tester.deleteStudent(4);
		System.out.println();
		
	}*/
}
