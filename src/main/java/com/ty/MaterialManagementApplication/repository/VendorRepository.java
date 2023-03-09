package com.ty.MaterialManagementApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.MaterialManagementApplication.dto.Vendor;



public interface VendorRepository extends JpaRepository<Vendor, String> {

}
