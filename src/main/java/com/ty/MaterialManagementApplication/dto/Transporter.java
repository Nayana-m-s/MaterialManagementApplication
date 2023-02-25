package com.ty.MaterialManagementApplication.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Transporter {
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private int id;
	private String	Name;
	private String 	Address;
	private String 	Email;
		private String Password;
	private long Phone;
	private long Driver_licence_no;
	private long 	Vehicle_no;
	
	

}
