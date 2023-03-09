package com.ty.MaterialManagementApplication.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.MaterialManagementApplication.dto.Customer;
import com.ty.MaterialManagementApplication.repository.CustomerRepository;

@Repository
public class CustomerDao {
	@Autowired
	private CustomerRepository repository;

	public Customer saveCustomer(Customer customer) {
	return repository.save(customer);

	}

	public Customer UpdateCustomer(String id,Customer customer) {
	if (repository.findById(id).isPresent()) {
		customer.setId(id);
	return repository.save(customer);
	} else {
	return null;
	}

	}

	public Customer deleteCustomer(String id) {
	if (repository.findById(id).isPresent()) {
		Customer customer = repository.findById(id).get();
	repository.delete(customer);
	return customer;
	} else {
	return null;
	}
	}

	public Customer getCustomerById(String id) {
	if (repository.findById(id).isPresent()) {
	return repository.findById(id).get();
	} else {
	return null;
	}
	}

}
