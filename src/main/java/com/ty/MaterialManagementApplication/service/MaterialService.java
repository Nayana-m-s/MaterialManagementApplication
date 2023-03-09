package com.ty.MaterialManagementApplication.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.MaterialManagementApplication.dao.MaterialDao;
import com.ty.MaterialManagementApplication.dto.Material;
import com.ty.MaterialManagementApplication.exceptions.IdNotFoundException;
import com.ty.MaterialManagementApplication.util.ResponseStructure;


@Service
public class MaterialService {
	@Autowired
	private MaterialDao dao;

	public ResponseEntity<ResponseStructure<Material>> saveMaterial(Material material) {
		ResponseStructure<Material> response = new ResponseStructure<Material>();
		response.setMessage("successfully saved");
		response.setStatus(HttpStatus.CREATED.value());
		response.setData(dao.saveMaterial(material));

		return new ResponseEntity<ResponseStructure<Material>>(response, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Material>> updateMaterial(String id, Material material) {

		Material daoMaterial = dao.UpdateMaterial(id, material);
		if (daoMaterial != null) {
			ResponseStructure<Material> response = new ResponseStructure<Material>();
			response.setMessage("successfully updated");
			response.setStatus(HttpStatus.OK.value());
			response.setData(daoMaterial);

			return new ResponseEntity<ResponseStructure<Material>>(response, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Given Id Not Found");
		}

	}

	public ResponseEntity<ResponseStructure<Material>> deleteMaterial(String id) {
	Material daoMaterial = dao.deleteMaterial(id);
		if (daoMaterial != null) {
			ResponseStructure<Material> response = new ResponseStructure<Material>();
			response.setMessage("successfully deleted");
			response.setStatus(HttpStatus.OK.value());
			response.setData(daoMaterial);

			return new ResponseEntity<ResponseStructure<Material>>(response, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Given Id Not Found");

		}
	}

	public ResponseEntity<ResponseStructure<Material>> getMaterialById(String id) {
		Material daoMaterial = dao.getMaterialById(id);
		if (daoMaterial != null) {
			ResponseStructure<Material> response = new ResponseStructure<Material>();
			response.setMessage("Found");
			response.setStatus(HttpStatus.FOUND.value());
			response.setData(daoMaterial);

			return new ResponseEntity<ResponseStructure<Material>>(response, HttpStatus.FOUND);
		} else {
			throw new NoSuchElementException("Given Id Not Found");

		}
	}

}
