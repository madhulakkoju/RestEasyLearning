package com.converters;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import com.db.TeacherDatabase;
import com.model.Teacher;

public class TeacherCsvToJson 
{
	/*
	public void csvToJson(String csvFilePath) throws FileNotFoundException, IOException
	{
		Pattern pattern = Pattern.compile(",");

		BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));
		
		List<Teacher> teachers = (List<Teacher>) reader.lines().skip(0).map(
			line -> {
				String fields[] = pattern.split(line);
				SimpleDateFormat dt = new SimpleDateFormat("dd-mm-yyyy");
				Teacher teacher = null;
					try {
						teacher =  new Teacher(
								fields[0],
								fields[1],
								fields[2],
								fields[3],
								dt.parse(fields[4]),
								dt.parse(fields[5]),
								Integer.parseInt(fields[6]),
								Double.parseDouble(fields[7]),
								Float.parseFloat(fields[8]),
								Float.parseFloat(fields[9])
							);
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				return teacher;
			}).collect(Collectors.toList());
		ObjectMapper mapper = new ObjectMapper();
	    mapper.enable(Feature.INDENT_OUTPUT );
	    mapper.writeValue(System.out, teachers);
	    
	    reader.close();
	    
	}
	*/
	
	public void csvToJson(String csvFilePath) throws FileNotFoundException, IOException, NumberFormatException, ParseException
	{
		Pattern pattern = Pattern.compile(",");

		BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));
		
		List<Teacher> teachers = new ArrayList<Teacher>(); 
		
		Stream<String> lines = reader.lines().skip(1);
		Iterator<String> iterator = lines.iterator();
		SimpleDateFormat dt = new SimpleDateFormat("dd-mm-yyyy");
		while(iterator.hasNext())
		{
			String[] fields = pattern.split(iterator.next());
			teachers.add(
					new Teacher(
						fields[0],
						fields[1],
						fields[2],
						fields[3],
						dt.parse(fields[4]),
						dt.parse(fields[5]),
						Integer.parseInt(fields[6]),
						Double.parseDouble(fields[7]),
						Float.parseFloat(fields[8]),
						Float.parseFloat(fields[9])
					)
				);
		}
		
		TeacherDatabase.addTeachers(teachers);
	    reader.close();
	    
	}
	
	public static void main(String args[]) throws FileNotFoundException, IOException, NumberFormatException, ParseException
	{
		String csvFilePath = "C:\\Users\\madhu\\Desktop\\testfile.csv";
		TeacherCsvToJson converter = new TeacherCsvToJson();
		converter.csvToJson(csvFilePath);
	}
	
}
