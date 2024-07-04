package com.spring.bioMedical.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// import org.springframework.data.annotation.Transient;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

    @Column(name = "medicalnum")
	private String medicalnum;
	
	@Column(name = "specialist")
	private String specialist;

    public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getMedicalNum() {
		return medicalnum;
	}


	public void setMedicalNum(String medicalnum) {
		this.medicalnum = medicalnum;
	}


	public String getSpecialist() {
		return specialist;
	}


	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}

	@Override
	public String toString(){
		return "Doctor[ id=" + id + ", medicalnum= " + medicalnum + ", specialist=" + specialist + "]";
	}

    
}
