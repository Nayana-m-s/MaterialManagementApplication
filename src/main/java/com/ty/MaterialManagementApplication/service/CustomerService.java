package com.ty.MaterialManagementApplication.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.MaterialManagementApplication.dao.CustomerDao;
import com.ty.MaterialManagementApplication.dto.Customer;

import com.ty.MaterialManagementApplication.exceptions.IdNotFoundException;
import com.ty.MaterialManagementApplication.util.ResponseStructure;

@Service
public class CustomerService {
	@Autowired
	private CustomerDao dao;
	
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(Customer customer) {
		ResponseStructure<Customer> response = new ResponseStructure<Customer>();
		response.setMessage("successfully saved");
		response.setStatus(HttpStatus.CREATED.value());
		response.setData(dao.saveCustomer(customer));

		return new ResponseEntity<ResponseStructure<Customer>>(response, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(String id, Customer customer) {

		Customer daoCustomer = dao.UpdateCustomer(id, customer);
		if (daoCustomer != null) {
			ResponseStructure<Customer> response = new ResponseStructure<Customer>();
			response.setMessage("successfully updated");
			response.setStatus(HttpStatus.OK.value());
			response.setData(daoCustomer);

			return new ResponseEntity<ResponseStructure<Customer>>(response, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Given Id Not Found");
		}

	}

	public ResponseEntity<ResponseStructure<Customer>> deleteCustomer(String id) {
		Customer daoCustomer = dao.deleteCustomer(id);
		if (daoCustomer != null) {
			ResponseStructure<Customer> response = new ResponseStructure<Customer>();
			response.setMessage("successfully deleted");
			response.setStatus(HttpStatus.OK.value());
			response.setData(daoCustomer);

			return new ResponseEntity<ResponseStructure<Customer>>(response, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Given Id Not Found");

		}
	}

	public ResponseEntity<ResponseStructure<Customer>> getCustomerById(String id) {
		Customer daoCustomer = dao.getCustomerById(id);
		if (daoCustomer != null) {
			ResponseStructure<Customer> response = new ResponseStructure<Customer>();
			response.setMessage("Found");
			response.setStatus(HttpStatus.FOUND.value());
			response.setData(daoCustomer);

			return new ResponseEntity<ResponseStructure<Customer>>(response, HttpStatus.FOUND);
		} else {
			throw new NoSuchElementException("Given Id Not Found");

		}
	}

}
