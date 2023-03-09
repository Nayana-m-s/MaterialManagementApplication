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

import com.ty.MaterialManagementApplication.dao.MaterialDao;
import com.ty.MaterialManagementApplication.dto.Material;

import com.ty.MaterialManagementApplication.service.MaterialService;
import com.ty.MaterialManagementApplication.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MaterialController {
	@Autowired
	private MaterialService service;
	@Autowired
	private MaterialDao dao;
	
	@ApiOperation(value = "Save Material", notes="API is used to save the material")
	@ApiResponses(value = {
			@ApiResponse(code = 201,message="Successfully saved")
	})
	@PostMapping("/material")
	public ResponseEntity<ResponseStructure<Material>> saveMaterial( @RequestBody Material material){
		return service.saveMaterial(material);
	}
	
	@ApiOperation(value = "update material", notes="API is used to update the material")
	@ApiResponses(value = { @ApiResponse(code = 201,message="Successfully updated"),
			@ApiResponse(code=404,message="Id not found for the given material ID") })
	@PutMapping("/material/{id}")
     
    public ResponseEntity<ResponseStructure<Material>>	updateMaterial(@PathVariable String id,@RequestBody Material material){
		return service.updateMaterial(id, material);
	}
	
	@ApiOperation(value = "Delete Material", notes="API is used to delete the material with given material ID")
	@ApiResponses(value = {
			@ApiResponse(code = 201,message="Successfully deleted"),
			@ApiResponse(code=404,message="Id not found for the given customer ID")
	})
	@DeleteMapping("/material/{id}")
	
	public ResponseEntity<ResponseStructure<Material>> deleteMaterial(@PathVariable String  id){
		return service.deleteMaterial(id);
	}
	
	
	@ApiOperation(value = "Fetch material", notes="API is used to fetch the Material with given material ID")
	@ApiResponses(value = {
			@ApiResponse(code = 201,message="Successfully fetched"),
			@ApiResponse(code=404,message="Id not found for the given material ID")
	})
	@GetMapping("/material/{id}")
	public ResponseEntity<ResponseStructure<Material>> getMaterialById(@PathVariable String id){
		  return service.getMaterialById(id);
	}
	
	@ApiOperation(value = "Get all Materials", notes="API is used to fetch all the materials present in database")
	@ApiResponses(value = {
			@ApiResponse(code = 201,message="Successfully fetched"),
			@ApiResponse(code=404,message="Id not found for the given material ID")
	})
	@GetMapping("/AllMaterials")
	public List<Material> getAllHospital() {
		return dao.getAllMaterials();
	}
	
	
}
