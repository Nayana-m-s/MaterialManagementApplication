package com.ty.MaterialManagementApplication.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.MaterialManagementApplication.dto.Vendor;
import com.ty.MaterialManagementApplication.repository.VendorRepository;



@Repository
public class VendorDao {
	@Autowired
	private VendorRepository repository;
	
	public Vendor saveVendor(Vendor vendor) {
		return repository.save(vendor);
		
	}
	
	public Vendor UpdateVendor(String id,Vendor vendor) {
		if (repository.findById(id).isPresent()) {
			vendor.setId(id);
			return repository.save(vendor);
		} else {
			return null;
		}
		
	}
	
	public Vendor deleteVendor(String id) {
		if (repository.findById(id).isPresent()) {
			Vendor vendor = repository.findById(id).get();
			repository.delete(vendor);
			return vendor;
		} else {
			return null;
		}
	}
	
	public Vendor getVendorById(String id) {
		if (repository.findById(id).isPresent()) {
			return repository.findById(id).get();
		} else {
			return null;
		}
	}
	
	
}
