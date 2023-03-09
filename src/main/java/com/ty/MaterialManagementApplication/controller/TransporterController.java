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

import com.ty.MaterialManagementApplication.dto.Transporter;
import com.ty.MaterialManagementApplication.service.TransporterService;
import com.ty.MaterialManagementApplication.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class TransporterController {
	@Autowired
	private TransporterService service;
	 
	@ApiOperation(value = "Save Transporter", notes="API is used to save the Transporter")
	@ApiResponses(value = {
			@ApiResponse(code = 201,message="Successfully saved")
	})
	@PostMapping("/transporter")
	public ResponseEntity<ResponseStructure<Transporter>> saveTransporter(@RequestBody Transporter transporter){
		 return service.saveTransporter(transporter);
	}
	
	@ApiOperation(value = "update transporter", notes="API is used to update the transporter")
	@ApiResponses(value = { @ApiResponse(code = 201,message="Successfully updated"),
			@ApiResponse(code=404,message="Id not found for the given transporter ID") })
	@PutMapping("/transporter/{id}")
	public ResponseEntity<ResponseStructure<Transporter>> updateTransporter(@PathVariable String id,@RequestBody Transporter transporter){
		  return service.updateTransporter(id, transporter);
	}
	
	@ApiOperation(value = "Delete transporter", notes="API is used to delete the transporter with given transporter ID")
	@ApiResponses(value = {
			@ApiResponse(code = 201,message="Successfully deleted"),
			@ApiResponse(code=404,message="Id not found for the given transporter ID")
	})
	@DeleteMapping("/transporter/{id}")
	public ResponseEntity<ResponseStructure<Transporter>> deleteTransporter(@PathVariable String id){
		 return service.deleteTransporter(id);
	}
	
	@ApiOperation(value = "Fetch transporter", notes="API is used to fetch the transporter with given transporter ID")
	@ApiResponses(value = {
			@ApiResponse(code = 201,message="Successfully fetched"),
			@ApiResponse(code=404,message="Id not found for the given transporter ID")
	})
	@GetMapping("/transporter/{id}")
	public ResponseEntity<ResponseStructure<Transporter>> getTransporter(@PathVariable String id){
		 return service.getTransporterById(id);
	}
	
	

}
