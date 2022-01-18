package com.sukumarc.rabbitmq.model;

import java.io.Serializable;

public class Employee implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer employeeId;
	private String name;
	
	public Employee(Integer employeeId, String name) {
		this.employeeId = employeeId;
		this.name = name;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
