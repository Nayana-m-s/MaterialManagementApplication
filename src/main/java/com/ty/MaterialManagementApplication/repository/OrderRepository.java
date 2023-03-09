package com.ty.MaterialManagementApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.MaterialManagementApplication.dto.MaterialOrder;





public interface OrderRepository extends JpaRepository<MaterialOrder, String> {

}
