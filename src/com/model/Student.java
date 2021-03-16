 package com.model;

import java.beans.JavaBean;
import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

@JavaBean
public class Student implements Serializable,Comparable<Student>
{
	private static final long serialVersionUID = 210920947253079541L;

	@JsonProperty("Student Name")
	private String name;
	
	@JsonProperty("Student ID")
	private String id;
	
	@JsonProperty("Student Mobile")
	private String mobile;
	
	@JsonIgnore
	@JsonProperty("_id")
	Object setid;
	
	public Student()
	{
		
	}
	
	public Student(String name, String id, String mobile) {
		this.name = name;
		this.id = id;
		this.mobile = mobile;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String toString()
	{
		return "{\"Student Name\" : \""+ name+"\","+"\"Student ID\" : \""+id+"\","+"\"Student Mobile\" : \""+mobile+"\"}";
	}

	@Override
	public int compareTo(Student student2) {
		// TODO Auto-generated method stub
		if(this.getId().equals(student2.getId()) &&
			this.getMobile().equals(student2.getMobile())&&
			this.getName().equals(student2.getName()))
		return 0;
		return -1;
	}
	@Override
	public boolean equals(Object s) {
		Student student2 = (Student) s;
		if(this.getId().equals(student2.getId()) &&
				this.getMobile().equals(student2.getMobile())&&
				this.getName().equals(student2.getName()))
		return true;
		return false;
	}
	
}
