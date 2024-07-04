package com.spring.bioMedical.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "medicines")
public class Med {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name="medName")
	private String medName;

	@Column(name="expDate")
	private String expDate;

	@Column(name="regDate")
	private String regDate;

	@Column(name="count")
	private int count;
	
	public void setId(int id){
		this.id=id;
	}

	public int getId(){
		return id;
	}

	public void setMedName(String medName){
		this.medName=medName;
	}

	public String getMedName(){
		return medName;
	}

	public void setExpDate(String expDate){
		this.expDate=expDate;
	}

	public String getExpDate(){
		return expDate;
	}

	public void setRegDate(String regDate){
		this.regDate=regDate;
	}

	public String getRegDate(){
		return regDate;
	}

	public void setCount(int count){
		this.count=count;
	}

	public int getCount(){
		return count;
	}

	@Override
	public String toString(){
		return "Med [id="+ id + ", medicine_name= " + medName + ", expiration_date= " + expDate + 
		",registered_date= " + regDate + " , count= " + count + "]";
	}


}