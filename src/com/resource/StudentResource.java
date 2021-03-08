package com.resource;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bson.Document;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import com.db.StudentDatabase;
import com.model.Student;

@Path(value="students")
public class StudentResource 
{
	@GET
	@Path(value="/")
	@Produces(MediaType.APPLICATION_JSON )
	public Response getStudents() 
	{
		//Mongo Document List is returned
		List<Document> students = StudentDatabase.getStudents();
		return Response.ok(students).build();
	}
	
	@GET
	@Path(value="/doc/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStudent(@PathParam("studentId") String studentId) 
	{
		//Student studentObject = new Student("Madhu Lakkoju","17241A05F3","8686156086");
		// Fetch student object from MONGO DB
		//String student = StudentConverter.studentToJson(studentObject);
		//JSON String is returned
		//JSONObject student = StudentDatabase.getJSONStudentById(studentId);
	
		//System.out.println(student.toString());
		Document student = StudentDatabase.getStudentById(studentId);
		student.remove("_id");
		return Response.ok(student).build();
	}
	
	@GET
	@Path(value="/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getSStudent(@PathParam("studentId") String studentId) throws JsonParseException, JsonMappingException, IOException 
	{
		//Student studentObject = new Student("Madhu Lakkoju","17241A05F3","8686156086");
		// Fetch student object from MONGO DB
		//String student = StudentConverter.studentToJson(studentObject);
		//JSON String is returned
		//JSONObject student = StudentDatabase.getJSONStudentById(studentId);
	
		//System.out.println(student.toString());
		Document student = StudentDatabase.getStudentById(studentId);
		student.remove("_id");
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationConfig.Feature.INDENT_OUTPUT);
		
		Student studentObject = mapper.readValue(student.toJson(),Student.class);
		//studentObject.setMobile("--");
		return studentObject;
	}
	
	@GET
	@Path(value="/json/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getJSONStudent(@PathParam("studentId") String studentId) throws JsonParseException, JsonMappingException, IOException 
	{
		//Student studentObject = new Student("Madhu Lakkoju","17241A05F3","8686156086");
		// Fetch student object from MONGO DB
		//String student = StudentConverter.studentToJson(studentObject);
		//JSON String is returned
		//JSONObject student = StudentDatabase.getJSONStudentById(studentId);
	
		//System.out.println(student.toString());
		Document student = StudentDatabase.getStudentById(studentId);
		student.remove("_id");
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationConfig.Feature.INDENT_OUTPUT);
		
		Student studentObject = mapper.readValue(student.toJson(),Student.class);
		//studentObject.setMobile("--");
		return studentObject;
	}
	
	@POST
	@Path(value="/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON )
	public Response addStudent(Student student)
	{
		Document doc = StudentDatabase.addStudent(student);
		if(doc!=null)
		return Response.accepted(doc).build();
		return Response.notModified("Data Not Added").build();
	}
	
	@DELETE
	@Path(value="/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteStudent(@PathParam("studentId") String studentId )
	{
		System.out.println("delete ");
		Document studentDoc = StudentDatabase.deleteStudentById(studentId);
		return Response.accepted(studentDoc).build();
	}
	
	@PUT
	@Path(value="/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateStudent(@PathParam("studentId") String studentId, Student student)
	{
		if(! student.getId().equals(student.getId()))
			return Response.notModified("The ID in URL and ID in STUDENT body donot Match !!").build();
		
		Document studentDoc = StudentDatabase.updateStudent(studentId,student);		
		return Response.accepted(studentDoc).build();
	}
	
}
