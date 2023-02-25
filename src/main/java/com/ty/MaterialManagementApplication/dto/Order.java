package com.ty.MaterialManagementApplication.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Order {
	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;

	private String name;

	private int quantity;

	private double price;

	private double total_price;

	private String delivery_status;

	private String dateofpurchase;

	@ManyToOne

	private Customer customer;

	@OneToOne

	private Transporter transporter;
}
