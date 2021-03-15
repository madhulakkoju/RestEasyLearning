 package com.model;

import java.beans.JavaBean;
import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

@JavaBean
public class Student implements Serializable
{
	@JsonProperty("Student Name")
	private String name;
	
	@JsonProperty("Student ID")
	private String id;
	
	@JsonProperty("Student Mobile")
	private String mobile;
	
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
	
}
