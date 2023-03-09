package com.ty.MaterialManagementApplication.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.ty.MaterialManagementApplication.util.StringPreFixedIdSequenceGenerator;

import lombok.Data;

@Entity
@Data
public class Vendor {
	@Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "id")
	@GenericGenerator(name =  "id",strategy = "com.ty.MaterialManagementApplication.util.StringPreFixedIdSequenceGenerator",parameters = {
			@Parameter(name=StringPreFixedIdSequenceGenerator.INCREMENT_PARAM,value="1"),
			@Parameter(name=StringPreFixedIdSequenceGenerator.VALUE_PREFIXE_PARAMETER,value = "vendor_"),
			@Parameter(name=StringPreFixedIdSequenceGenerator.NUMBER_FORMAT_PARAMETER,value = "%05d")
	})
	private String id;
	 @NotBlank(message = "name should not be blank")
		@NotNull(message = "name should not be empty")
	private String name;
	 @NotBlank(message = "email should not be blank")
		@NotNull(message = "email should not be empty")
	 @Pattern(regexp = "[a-zA-Z0-9]+[@][a-zA-Z]+[/.][a-z]{2,3}")
	private String email;
	 @Pattern(regexp = "[A-Za-z]+[0-9]+[@/./-]")
	private String password;
	 @Pattern(regexp = "[6-9][0-9]{9}")
	private String phone;
	 @NotBlank(message = "address should not be blank")
		@NotNull(message = "address should not be empty")
	private String address;
	 
    @OneToMany
 private	List<Material> materials;
	

}
