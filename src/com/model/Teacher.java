package com.model;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class Teacher implements Serializable,Comparable<Teacher>
{
	private static final long serialVersionUID = -2606710242392790399L;
	@JsonProperty("First Name")
	String firstName;
	@JsonProperty("Last Name")
	String lastName;
	@JsonProperty("Employee ID")
	String employeeId;
	@JsonProperty("Department Name")
	String departmentName;
	@JsonProperty("Date of Birth")
	Date dateOfBirth;
	@JsonProperty("Date of Joining")
	Date joinDate;
	@JsonProperty("Hours per Day")
	int hours;
	@JsonProperty("Pay per Month")
	double payPerMonth;
	@JsonProperty("Added Benifits Cost")
	float addedBenefits;
	@JsonProperty("Deduction Amount")
	float deductions;
	
	public Teacher() {
		
	}

	public Teacher(String firstName, String lastName, String employeeId, String departmentName, Date dateOfBirth,
			Date joinDate, int hours, double payPerMonth, float addedBenefits, float deductions) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeId = employeeId;
		this.departmentName = departmentName;
		this.dateOfBirth = dateOfBirth;
		this.joinDate = joinDate;
		this.hours = hours;
		this.payPerMonth = payPerMonth;
		this.addedBenefits = addedBenefits;
		this.deductions = deductions;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public double getPayPerMonth() {
		return payPerMonth;
	}

	public void setPayPerMonth(double payPerMonth) {
		this.payPerMonth = payPerMonth;
	}

	public float getAddedBenefits() {
		return addedBenefits;
	}

	public void setAddedBenefits(float addedBenefits) {
		this.addedBenefits = addedBenefits;
	}

	public float getDeductions() {
		return deductions;
	}

	public void setDeductions(float deductions) {
		this.deductions = deductions;
	}

	@Override
	public int compareTo(Teacher o) {
		// TODO Auto-generated method stub
		return 0;
	}
	public boolean equals(Teacher t)
	{
		// add conditions
		return true;
	}
	
	
}
