package com.ty.MaterialManagementApplication.dto;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Material {
	@Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "id")
	@GenericGenerator(name =  "id",strategy = "com.ty.MaterialManagementApplication.util.StringPreFixedIdSequenceGenerator",parameters = {
			@Parameter(name=StringPreFixedIdSequenceGenerator.INCREMENT_PARAM,value="1"),
			@Parameter(name=StringPreFixedIdSequenceGenerator.VALUE_PREFIXE_PARAMETER,value = "material_"),
			@Parameter(name=StringPreFixedIdSequenceGenerator.NUMBER_FORMAT_PARAMETER,value = "%05d")
	})
	private String id;
	 @NotBlank(message = "Name should not be blank")
	 @NotNull(message = "Name should not be empty")
	private String name;
	 @NotBlank(message = "quantity should not be blank")
	 @NotNull(message = "quantity should not be empty")
	private String quantity;
		@DateTimeFormat(pattern = "yyyy-MM-dd")

	private Date dateof_purchase;
	
	private String price;
	 @NotBlank(message = "date of purchase should not be blank")
		@NotNull(message = "date of purchase should not be empty")
	private String description;

}
