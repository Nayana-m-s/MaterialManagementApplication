package com.ty.MaterialManagementApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.ty.MaterialManagementApplication.dto.Customer;
import com.ty.MaterialManagementApplication.service.CustomerService;
import com.ty.MaterialManagementApplication.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService service;
	
	@ApiOperation(value = "Save customer", notes="API is used to save the customer")
	@ApiResponses(value = {
			@ApiResponse(code = 201,message="Successfully saved")
	})
	@PostMapping("/customer")
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(@RequestBody Customer customer){
		   return service.saveCustomer(customer);
	}
	@ApiOperation(value = "update customer", notes="API is used to update the customer")
	@ApiResponses(value = { @ApiResponse(code = 201,message="Successfully updated"),
			@ApiResponse(code=404,message="Id not found for the given customer ID") })
	@PutMapping("/customer/{id}")
	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(@PathVariable String id, @RequestBody Customer customer){
		  return service.updateCustomer(id, customer);
	}
	
	@ApiOperation(value = "Delete Customer", notes="API is used to delete the customer with given customer ID")
	@ApiResponses(value = {
			@ApiResponse(code = 201,message="Successfully deleted"),
			@ApiResponse(code=404,message="Id not found for the given customer ID")
	})
	
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<ResponseStructure<Customer>> deleteCustomer(@PathVariable String id){
		  return service.deleteCustomer(id);
	}
	@ApiOperation(value = "Fetch Customer", notes="API is used to fetch the Customer with given Customer ID")
	@ApiResponses(value = {
			@ApiResponse(code = 201,message="Successfully fetched"),
			@ApiResponse(code=404,message="Id not found for the given customer ID")
	})
	@GetMapping("/customer/{id}")
	public ResponseEntity<ResponseStructure<Customer>> getCustomerById(@PathVariable String id){
		  return service.getCustomerById(id);
	}
	

}
