package com.debashis.practice;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	private int id;
	
	private String name;
	
	private String employer;
	
	public Employee() {
		
	}

	public Employee(int id, String name, String employer) {
		super();
		this.id = id;
		this.name = name;
		this.employer = employer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", employer=" + employer + "]";
	}
	
	
	
	
}
