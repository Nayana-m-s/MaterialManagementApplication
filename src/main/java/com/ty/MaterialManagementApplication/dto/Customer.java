package com.ty.MaterialManagementApplication.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import org.springframework.format.annotation.NumberFormat;

import com.ty.MaterialManagementApplication.util.StringPreFixedIdSequenceGenerator;

import lombok.Data;

@Entity
@Data
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id")
	@GenericGenerator(name = "id", strategy = "com.ty.MaterialManagementApplication.util.StringPreFixedIdSequenceGenerator", parameters = {
			@Parameter(name = StringPreFixedIdSequenceGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = StringPreFixedIdSequenceGenerator.VALUE_PREFIXE_PARAMETER, value = "customer_"),
			@Parameter(name = StringPreFixedIdSequenceGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String id;
	@NotBlank(message = "Name should not be blank")
	@NotNull(message = "Name should not be empty")
	private String name;
	@NotBlank(message = "Address should not be blank")
	@NotNull(message = "Address should not be empty")
	private String address;
	@Pattern(regexp = "[A-Za-z]+[0-9]+[@/./-]")
	private String password;
	@NotBlank(message = "email should not be blank")
	@NotNull(message = "email should not be empty")
	@Pattern(regexp = "[a-zA-Z0-9]+[@][a-zA-Z]+[/.][a-z]{2,3}")
	private String email;
	@NotBlank(message = "phone number should not be blank")
	@Pattern(regexp = "[6-9][0-9]{9}", message = "enter valid number")
	private String phone;

}
