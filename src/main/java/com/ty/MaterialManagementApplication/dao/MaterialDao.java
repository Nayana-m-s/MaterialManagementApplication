package com.ty.MaterialManagementApplication.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.MaterialManagementApplication.dto.Material;
import com.ty.MaterialManagementApplication.repository.MaterialRepository;




@Repository
public class MaterialDao {
	@Autowired
	private MaterialRepository repository;
	
	public Material saveVendor(Material material) {
		return repository.save(material);
		
	}
	
	public Material UpdateVendor(int id,Material material) {
		if (repository.findById(id).isPresent()) {
			material.setId(id);
			return repository.save(material);
		} else {
			return null;
		}
		
	}
	
	public Material deleteVendor(int id) {
		if (repository.findById(id).isPresent()) {
			Material material = repository.findById(id).get();
			repository.delete(material);
			return material;
		} else {
			return null;
		}
	}
	
	public Material getVendorById(int id) {
		if (repository.findById(id).isPresent()) {
			return repository.findById(id).get();
		} else {
			return null;
		}
	}

	
	
}
