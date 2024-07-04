package com.spring.bioMedical.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "meds")
public class Med {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name="name")
	private String name;

	@Column(name="exp")
	private String exp;

	@Column(name="reg")
	private String reg;

	@Column(name="count")
	private int count;
	
	public void setId(int id){
		this.id=id;
	}

	public int getId(){
		return id;
	}

	public void setName(String name){
		this.name=name;
	}

	public String getName(){
		return name;
	}

	public void setExp(String exp){
		this.exp=exp;
	}

	public String getExp(){
		return exp;
	}

	public void setReg(String reg){
		this.reg=reg;
	}

	public String getReg(){
		return reg;
	}

	public void setCount(int count){
		this.count=count;
	}

	public int getCount(){
		return count;
	}

	@Override
	public String toString(){
		return "Med [id="+ id + ", name= " + name + ", exp= " + exp + 
		",reg= " + reg + " , count= " + count + "]";
	}


}