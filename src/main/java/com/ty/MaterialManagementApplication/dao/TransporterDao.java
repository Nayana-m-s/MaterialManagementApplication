package com.ty.MaterialManagementApplication.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.MaterialManagementApplication.dto.Transporter;
import com.ty.MaterialManagementApplication.repository.TransporterRepository;

@Repository
public class TransporterDao {
	@Autowired
	private TransporterRepository repository;

	public Transporter saveTransporter(Transporter transporter) {
	return repository.save(transporter);

	}

	public Transporter UpdateTransporter(String id,Transporter transporter) {
	if (repository.findById(id).isPresent()) {
		transporter.setId(id);
	return repository.save(transporter);
	} else {
	return null;
	}

	}

	public Transporter deleteTransporter(String id) {
	if (repository.findById(id).isPresent()) {
		Transporter transporter = repository.findById(id).get();
	repository.delete(transporter);
	return transporter;
	} else {
	return null;
	}
	}

	public Transporter getTransporterById(String id) {
	if (repository.findById(id).isPresent()) {
	return repository.findById(id).get();
	} else {
	return null;
	}
	}


}
