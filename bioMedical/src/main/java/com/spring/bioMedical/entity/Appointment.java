package com.spring.bioMedical.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;


@Entity
@Table(name = "app")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name", nullable = false, unique = true)
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "time")
	private String time;
	
	
	@Column(name = "description")
	private String description;

	
	@Column(name = "regtime")
	@Transient
	private String regtime;

	@Column(name = "doctor_desc")
    private String doctorDesc;

    @Column(name = "specialist")
    private String specialist;

    // Getters and setters for new columns
    public String getDoctorDesc() {
        return doctorDesc;
    }

    public void setDoctorDesc(String doctorDesc) {
        this.doctorDesc = doctorDesc;
    }

    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }
	

	public String getRegtime() {
		return regtime;
	}


	public void setRegtime(String regtime) {
		this.regtime = regtime;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "Appointment [id=" + id + ", name=" + name + ", email=" + email + ", date=" + date + ", time=" + time
				+ ", description=" + description + ", specialist=" + specialist + ", doctorDesc=" + doctorDesc + "]";
	}
	
	

}