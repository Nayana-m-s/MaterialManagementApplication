package com.ty.MaterialManagementApplication.dto;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ty.MaterialManagementApplication.util.StringPreFixedIdSequenceGenerator;

import lombok.Data;

@Entity
@Data
public class MaterialOrder {
	
	
	@Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "id")
	@GenericGenerator(name =  "id",strategy = "com.ty.MaterialManagementApplication.util.StringPreFixedIdSequenceGenerator",parameters = {
			@Parameter(name=StringPreFixedIdSequenceGenerator.INCREMENT_PARAM,value="1"),
			@Parameter(name=StringPreFixedIdSequenceGenerator.VALUE_PREFIXE_PARAMETER,value = "order_"),
			@Parameter(name=StringPreFixedIdSequenceGenerator.NUMBER_FORMAT_PARAMETER,value = "%05d")
	})
   private String id;
	@NotBlank(message = "name should not be blank")
	@NotNull(message = "name should not be empty")
	private String name;
	@NotBlank(message = "name should not be blank")
	@NotNull(message = "name should not be empty")
	@Pattern(regexp = "[1-9]{5}")
	private String quantity;
	@NotBlank(message = "name should not be blank")
	@NotNull(message = "name should not be empty")
    @Pattern(regexp = "[1-9]{5}")
	private String price;
	@NotBlank(message = "name should not be blank")
	@NotNull(message = "name should not be empty")
    @Pattern(regexp = "[1-9]{5}")
	private String total_price;
	@NotBlank(message = "delivery status should not be blank")
	@NotNull(message = "delivery status should not be empty")

	private String delivery_status;
	@DateTimeFormat(pattern = "yyyy-MM-dd")

	private Date dateofpurchase;

	@ManyToOne

	private Customer customer;

	@OneToOne

	private Transporter transporter;
}
