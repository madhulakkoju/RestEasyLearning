package com.db;

import java.io.IOException;
import java.util.List;

import org.bson.Document;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import com.model.Teacher;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class TeacherDatabase 
{
	static String databaseName = "school";
	static String collectionName = "teachers";
	
	public static Document addTeacher(Teacher teacher) throws JsonGenerationException, JsonMappingException, IOException
	{
		MongoClient client = MongoClients.create();
		MongoDatabase db = client.getDatabase(databaseName);
		MongoCollection<Document> teachers = db.getCollection(collectionName);
		Document checkDoc = teachers.find(Filters.eq("Employee ID",teacher.getEmployeeId())).first();
		if(checkDoc != null)
			return checkDoc;
		ObjectMapper mapper = new ObjectMapper();
	    mapper.enable(SerializationConfig.Feature.INDENT_OUTPUT );
		Document addTeacher = Document.parse(mapper.writeValueAsString(teacher));
		addTeacher.remove("_id");
		teachers.insertOne(addTeacher);
		
		return addTeacher;
	}
	
	public static void addTeachers(List<Teacher> teachersList) throws JsonGenerationException, JsonMappingException, IOException
	{
		for(Teacher teacher : teachersList)
		{
			addTeacher(teacher);
		}
	}
	
}
