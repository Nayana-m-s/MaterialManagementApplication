package com.ty.MaterialManagementApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.MaterialManagementApplication.dto.Material;





public interface MaterialRepository extends JpaRepository<Material, Integer> {

}
