package com.ty.MaterialManagementApplication.service;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.MaterialManagementApplication.dao.MaterialDao;
import com.ty.MaterialManagementApplication.dao.VendorDao;
import com.ty.MaterialManagementApplication.dto.Material;
import com.ty.MaterialManagementApplication.dto.Vendor;
import com.ty.MaterialManagementApplication.exceptions.IdNotFoundException;
import com.ty.MaterialManagementApplication.util.ResponseStructure;


@Service
public class VendorService {
	@Autowired
	private VendorDao dao;
	@Autowired
	private MaterialDao materialdao;
	public ResponseEntity<ResponseStructure<Vendor>> saveVendor(Vendor vendor,String id) {
		ResponseStructure<Vendor> response = new ResponseStructure<Vendor>();
		Material material=materialdao.getMaterialById(id);
		ArrayList<Material> materials = new ArrayList<>();
		materials.add(material);
		vendor.setMaterials(materials);
		response.setMessage("successfully saved");
		response.setStatus(HttpStatus.CREATED.value());
		response.setData(dao.saveVendor(vendor));

		return new ResponseEntity<ResponseStructure<Vendor>>(response, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Vendor>> updateVendor(String id, Vendor vendor,String mid) {

		Vendor daoVendor = dao.UpdateVendor(id, vendor);
		Material material=materialdao.getMaterialById(mid);
		ArrayList<Material> materials = new ArrayList<>();
		materials.add(material);
		if (daoVendor!=null) {
			vendor.setMaterials(materials);
		
			ResponseStructure<Vendor> response = new ResponseStructure<Vendor>();
			response.setMessage("successfully updated");
			response.setStatus(HttpStatus.OK.value());
			response.setData(daoVendor);

			return new ResponseEntity<ResponseStructure<Vendor>>(response, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Given Id Not Found");
		}

	}

	public ResponseEntity<ResponseStructure<Vendor>> deleteVendor(String id) {
		Vendor daoVendor = dao.deleteVendor(id);
		if (daoVendor != null) {
			ResponseStructure<Vendor> response = new ResponseStructure<Vendor>();
			response.setMessage("successfully deleted");
			response.setStatus(HttpStatus.OK.value());
			response.setData(daoVendor);

			return new ResponseEntity<ResponseStructure<Vendor>>(response, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Given Id Not Found");

		}
	}

	public ResponseEntity<ResponseStructure<Vendor>> getVendorById(String id) {
		Vendor daoVendor = dao.getVendorById(id);
		if (daoVendor != null) {
			ResponseStructure<Vendor> response = new ResponseStructure<Vendor>();
			response.setMessage("Found");
			response.setStatus(HttpStatus.FOUND.value());
			response.setData(daoVendor);

			return new ResponseEntity<ResponseStructure<Vendor>>(response, HttpStatus.FOUND);
		} else {
			throw new NoSuchElementException("Given Id Not Found");

		}
	}
	
	
	

}
