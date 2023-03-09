package com.ty.MaterialManagementApplication.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.MaterialManagementApplication.dao.TransporterDao;

import com.ty.MaterialManagementApplication.dto.Transporter;
import com.ty.MaterialManagementApplication.exceptions.IdNotFoundException;
import com.ty.MaterialManagementApplication.util.ResponseStructure;

@Service
public class TransporterService {
	@Autowired
	private TransporterDao dao;
	
	public ResponseEntity<ResponseStructure<Transporter>> saveTransporter(Transporter transporter) {
		ResponseStructure<Transporter> response = new ResponseStructure<Transporter>();
		response.setMessage("successfully saved");
		response.setStatus(HttpStatus.CREATED.value());
		response.setData(dao.saveTransporter(transporter));

		return new ResponseEntity<ResponseStructure<Transporter>>(response, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Transporter>> updateTransporter(String id, Transporter transporter) {

		Transporter daoTransporter = dao.UpdateTransporter(id, transporter);
		if (daoTransporter != null) {
			ResponseStructure<Transporter> response = new ResponseStructure<Transporter>();
			response.setMessage("successfully updated");
			response.setStatus(HttpStatus.OK.value());
			response.setData(daoTransporter);

			return new ResponseEntity<ResponseStructure<Transporter>>(response, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Given Id Not Found");
		}

	}

	public ResponseEntity<ResponseStructure<Transporter>> deleteTransporter(String id) {
		Transporter daoTransporter = dao.deleteTransporter(id);
		if (daoTransporter != null) {
			ResponseStructure<Transporter> response = new ResponseStructure<Transporter>();
			response.setMessage("successfully deleted");
			response.setStatus(HttpStatus.OK.value());
			response.setData(daoTransporter);

			return new ResponseEntity<ResponseStructure<Transporter>>(response, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Given Id Not Found");

		}
	}

	public ResponseEntity<ResponseStructure<Transporter>> getTransporterById(String id) {
		Transporter daoTransporter = dao.getTransporterById(id);
		if (daoTransporter != null) {
			ResponseStructure<Transporter> response = new ResponseStructure<Transporter>();
			response.setMessage("Found");
			response.setStatus(HttpStatus.FOUND.value());
			response.setData(daoTransporter);

			return new ResponseEntity<ResponseStructure<Transporter>>(response, HttpStatus.FOUND);
		} else {
			throw new NoSuchElementException("Given Id Not Found");

		}
	}
	
	

}
