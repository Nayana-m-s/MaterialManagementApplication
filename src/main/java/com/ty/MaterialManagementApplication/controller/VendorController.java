package com.ty.MaterialManagementApplication.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.MaterialManagementApplication.dto.Vendor;
import com.ty.MaterialManagementApplication.service.VendorService;
import com.ty.MaterialManagementApplication.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;




@RestController
public class VendorController {
	@Autowired
	private VendorService service;
	
	
	@ApiOperation(value = "Save Vendor", notes="API is used to save the Vendor")
	@ApiResponses(value = {
			@ApiResponse(code = 201,message="Successfully saved")
	})
	@PostMapping("/vendor/{id}")
	public ResponseEntity<ResponseStructure<Vendor>> saveHospital( @RequestBody Vendor vendor, @PathVariable String id){
		return service.saveVendor(vendor,id);
	}
	
	@ApiOperation(value = "update vendor", notes="API is used to update the vendor")
	@ApiResponses(value = { @ApiResponse(code = 201,message="Successfully updated"),
			@ApiResponse(code=404,message="Id not found for the given vendor ID") })
	@PutMapping("/vendor/{id}/{mid}")
	public ResponseEntity<ResponseStructure<Vendor>> updateVendor(@PathVariable String id,@RequestBody Vendor vendor,@PathVariable String mid){
		return service.updateVendor(id,vendor,mid);
	}
	@ApiOperation(value = "Delete vendor", notes="API is used to delete the vendor with given vendor ID")
	@ApiResponses(value = {
			@ApiResponse(code = 201,message="Successfully deleted"),
			@ApiResponse(code=404,message="Id not found for the given order ID")
	})
	@DeleteMapping("/vendor/{id}")
	
	public ResponseEntity<ResponseStructure<Vendor>> deleteVendor(@PathVariable String  id){
		return service.deleteVendor(id);
	}
	
	@ApiOperation(value = "Fetch vendor", notes="API is used to fetch the vendor with given vendor ID")
	@ApiResponses(value = {
			@ApiResponse(code = 201,message="Successfully fetched"),
			@ApiResponse(code=404,message="Id not found for the given vendor ID")
	})
	@GetMapping("/vendor/{id}")
	public ResponseEntity<ResponseStructure<Vendor>> getVendorById(@PathVariable String id){
		return service.getVendorById(id);
	}
	
	

}
