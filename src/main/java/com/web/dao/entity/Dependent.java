package com.web.dao.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dependent_tbl")
public class Dependent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private Date dob;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fsid", nullable = false, unique = false)
	private Enrollees enrollees;

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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Enrollees getEnrollees() {
		return enrollees;
	}

	public void setEnrollees(Enrollees enrollees) {
		this.enrollees = enrollees;
	}

}
