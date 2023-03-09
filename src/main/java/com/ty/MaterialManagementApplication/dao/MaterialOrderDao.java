package com.ty.MaterialManagementApplication.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.MaterialManagementApplication.dto.MaterialOrder;
import com.ty.MaterialManagementApplication.repository.OrderRepository;

@Repository
public class MaterialOrderDao {
	@Autowired
	private OrderRepository repository;

	public MaterialOrder saveMaterialOrder(MaterialOrder materialOrder) {
		return repository.save(materialOrder);

	}

	public MaterialOrder UpdateMaterialOrder(String id,MaterialOrder materialOrder) {
	if (repository.findById(id).isPresent()) {
		materialOrder.setId(id);
	return repository.save(materialOrder);
	} else {
	return null;
	}

	}

	public MaterialOrder deleteMaterialOrder(String id) {
	if (repository.findById(id).isPresent()) {
		MaterialOrder materialOrder = repository.findById(id).get();
	repository.delete(materialOrder);
	return materialOrder;
	} else {
	return null;
	}
	}

	public MaterialOrder getMaterialOrderById(String id) {
	if (repository.findById(id).isPresent()) {
	return repository.findById(id).get();
	} else {
	return null;
	}
	}
	
}
