package com.db;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.json.JSONException;
import org.json.JSONObject;

import com.model.Student;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class StudentDatabase 
{
	static String databaseName = "school";
	static String collectionName = "students";
	
	/*
	public static JSONObject getStudentById(String studentId) 
	{
		MongoClient client = MongoClients.create();
		MongoDatabase db = client.getDatabase(databaseName);
		MongoCollection<Document> students = db.getCollection(collectionName);
		FindIterable<Document> iterator = students.find(Filters.eq("Student ID",studentId));
		//return new ObjectMapper().readValue(iterator.first().toJson(),Student.class);
		return new JSONObject(iterator.first().toJson());
	}
	
	public static List<JSONObject> getJSONStudents() 
	{
		MongoClient client = MongoClients.create();
		MongoDatabase db = client.getDatabase(databaseName);
		MongoCollection<Document> students = db.getCollection(collectionName);
		FindIterable<Document> iterator = students.find();
		MongoCursor<Document> cursor = iterator.cursor();
		List<JSONObject> allStudents = new ArrayList<JSONObject>();
		
		while(cursor.hasNext())
		{
			allStudents.add(new JSONObject(cursor.next().toJson()));
		}
		
		return allStudents;
	}
	
	public static String addStudent(Student studentObject) 
	{
		
		//Document studentDocument = getStudentById(studentObject.getId());
		//if(studentDocument != null)
			//return studentDocument;
		
		MongoClient client = MongoClients.create();
		MongoDatabase db = client.getDatabase(databaseName);
		MongoCollection<Document> students = db.getCollection(collectionName);
		String student = studentObject.toJsonString();
		Document studentDocument = Document.parse(student);
		students.insertOne(studentDocument);
		return  student;
	}
	*/
	
	public static List<Document> getStudents() 
	{
		MongoClient client = MongoClients.create();
		MongoDatabase db = client.getDatabase(databaseName);
		MongoCollection<Document> students = db.getCollection(collectionName);
		FindIterable<Document> iterator = students.find();
		MongoCursor<Document> cursor = iterator.cursor();
		List<Document> allStudents = new ArrayList<Document>();
		
		while(cursor.hasNext())
		{
			allStudents.add(cursor.next());
		}
		
		return allStudents;
	}
	
	public static Document getStudentById(String studentId) 
	{
		MongoClient client = MongoClients.create();
		MongoDatabase db = client.getDatabase(databaseName);
		MongoCollection<Document> students = db.getCollection(collectionName);
		FindIterable<Document> iterator = students.find(Filters.eq("Student ID",studentId));
		//return new ObjectMapper().readValue(iterator.first().toJson(),Student.class);
		return iterator.first();
	}
	/*
	public static JSONObject getJSONStudentById(String studentId) throws JSONException
	{
		MongoClient client = MongoClients.create();
		MongoDatabase db = client.getDatabase(databaseName);
		MongoCollection<Document> students = db.getCollection(collectionName);
		FindIterable<Document> iterator = students.find(Filters.eq("Student ID",studentId));
		//return new ObjectMapper().readValue(iterator.first().toJson(),Student.class);
		return new JSONObject(iterator.first().toJson());
		
	}
	*/
	public static Document addStudent(Student studentObject) 
	{
		
		MongoClient client = MongoClients.create();
		MongoDatabase db = client.getDatabase(databaseName);
		MongoCollection<Document> students = db.getCollection(collectionName);
		Document checkDoc = students.find(Filters.eq("Student ID",studentObject.getId())).first();
		
		if(checkDoc!=null)
		{	
			checkDoc.put("ERROR", "This Object found in database with the SAME ID as in the supplied Object");
			return checkDoc;
		}
		Document studentDoc = Document.parse(studentObject.toJsonString());
		students.insertOne(studentDoc);
		return studentDoc;
	}
	
	public static Document deleteStudentById(String id)
	{
		MongoClient client = MongoClients.create();
		MongoDatabase db = client.getDatabase(databaseName);
		MongoCollection<Document> students = db.getCollection(collectionName);
		return students.findOneAndDelete(Filters.eq("Student ID",id));
	}
	
	public static Document updateStudent(String id , Student studentObject)
	{
		MongoClient client = MongoClients.create();
		MongoDatabase db = client.getDatabase(databaseName);
		MongoCollection<Document> students = db.getCollection(collectionName);
		students.findOneAndDelete(Filters.eq("Student ID",id));
		// Modify code to add only the details that are specified in the studentObject whihc are changed or not present 
		// in Student Document present in database
		Document studentDoc = Document.parse(studentObject.toJsonString());
		students.insertOne(studentDoc);
		return studentDoc;
	}
	
}
