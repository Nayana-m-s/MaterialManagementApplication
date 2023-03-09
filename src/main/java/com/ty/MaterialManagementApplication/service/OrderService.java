package com.ty.MaterialManagementApplication.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.MaterialManagementApplication.dao.CustomerDao;
import com.ty.MaterialManagementApplication.dao.MaterialOrderDao;
import com.ty.MaterialManagementApplication.dao.TransporterDao;
import com.ty.MaterialManagementApplication.dto.Customer;
import com.ty.MaterialManagementApplication.dto.MaterialOrder;
import com.ty.MaterialManagementApplication.dto.Transporter;
import com.ty.MaterialManagementApplication.exceptions.IdNotFoundException;
import com.ty.MaterialManagementApplication.util.ResponseStructure;

@Service
public class OrderService {
	@Autowired
	private MaterialOrderDao dao;
	@Autowired
	private CustomerDao cdao;
	@Autowired
	private TransporterDao tdao;
	
	
	public ResponseEntity<ResponseStructure<MaterialOrder>> saveOrder(MaterialOrder order,String cid,String tid) {
		Customer getcustomer=cdao.getCustomerById(cid);
		Transporter gettransporter=tdao.getTransporterById(tid);
		   order.setCustomer(getcustomer);
		   order.setTransporter(gettransporter);
		ResponseStructure<MaterialOrder> response = new ResponseStructure<MaterialOrder>();
		response.setMessage("successfully saved");
		response.setStatus(HttpStatus.CREATED.value());
		response.setData(dao.saveMaterialOrder(order));

		return new ResponseEntity<ResponseStructure<MaterialOrder>>(response, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<MaterialOrder>> updateOrder(String id, MaterialOrder order,String cid,String tid) {

		MaterialOrder daoOrder = dao.UpdateMaterialOrder(id, order);
		//Customer getcustomer=cdao.getCustomerById(cid);
		//Transporter gettransporter=tdao.getTransporterById(tid);
		
				 if (daoOrder != null) {
						ResponseStructure<MaterialOrder> response = new ResponseStructure<MaterialOrder>();
					     order.setCustomer(order.getCustomer());
					     order.setTransporter(order.getTransporter());
						response.setMessage("successfully updated");
						response.setStatus(HttpStatus.OK.value());
						response.setData(daoOrder);

						return new ResponseEntity<ResponseStructure<MaterialOrder>>(response, HttpStatus.OK);
					} else {
						throw new IdNotFoundException("Given Id Not Found");
					}
			 }
		 

	

	public ResponseEntity<ResponseStructure<MaterialOrder>> deleteOrder(String id) {
		MaterialOrder daoOrder = dao.deleteMaterialOrder(id);
		if (daoOrder != null) {
			ResponseStructure<MaterialOrder> response = new ResponseStructure<MaterialOrder>();
			response.setMessage("successfully deleted");
			response.setStatus(HttpStatus.OK.value());
			response.setData(daoOrder);

			return new ResponseEntity<ResponseStructure<MaterialOrder>>(response, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Given Id Not Found");

		}
	}

	public ResponseEntity<ResponseStructure<MaterialOrder>> getOrderById(String id) {
		MaterialOrder daoOrder = dao.getMaterialOrderById(id);
		if (daoOrder != null) {
			ResponseStructure<MaterialOrder> response = new ResponseStructure<MaterialOrder>();
			response.setMessage("Found");
			response.setStatus(HttpStatus.FOUND.value());
			response.setData(daoOrder);

			return new ResponseEntity<ResponseStructure<MaterialOrder>>(response, HttpStatus.FOUND);
		} else {
			throw new NoSuchElementException("Given Id Not Found");

		}
	}
	
	
	

}
