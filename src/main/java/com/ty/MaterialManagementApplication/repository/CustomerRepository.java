package com.ty.MaterialManagementApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.MaterialManagementApplication.dto.Customer;



public interface CustomerRepository  extends JpaRepository<Customer, String>{

}
