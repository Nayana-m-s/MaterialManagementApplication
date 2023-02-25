package com.ty.MaterialManagementApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.MaterialManagementApplication.dto.Order;





public interface OrderRepository extends JpaRepository<Order, Integer> {

}
