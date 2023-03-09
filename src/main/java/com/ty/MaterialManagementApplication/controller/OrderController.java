package com.ty.MaterialManagementApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.MaterialManagementApplication.dto.MaterialOrder;
import com.ty.MaterialManagementApplication.service.OrderService;
import com.ty.MaterialManagementApplication.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class OrderController {
	@Autowired
	private OrderService service;
	
	@ApiOperation(value = "Save Order", notes="API is used to save the order with the given customer id and transporter id")
	@ApiResponses(value = {
			@ApiResponse(code = 201,message="Successfully saved"),
			@ApiResponse(code=404,message="Id not found for the given order ID")
	})
	@PostMapping("/order/{cid}/{tid}")
	public ResponseEntity<ResponseStructure<MaterialOrder>> saveOrder(@RequestBody MaterialOrder order,@PathVariable String cid,@PathVariable String tid){
		return service.saveOrder(order, cid, tid);
	}
	
	@ApiOperation(value = "update order", notes="API is used to update the order")
	@ApiResponses(value = { @ApiResponse(code = 201,message="Successfully updated"),
			@ApiResponse(code=404,message="Id not found for the given order ID") })
	@PutMapping("/order/{id}/{cid}/{tid}")
	public ResponseEntity<ResponseStructure<MaterialOrder>> updateOrder(@PathVariable String id,@RequestBody MaterialOrder order,@PathVariable String cid,@PathVariable String tid){
		 return service.updateOrder(id, order, cid, tid);
	}
	
	@ApiOperation(value = "Delete order", notes="API is used to delete the order with given order ID")
	@ApiResponses(value = {
			@ApiResponse(code = 201,message="Successfully deleted"),
			@ApiResponse(code=404,message="Id not found for the given order ID")
	})
	@DeleteMapping("/order/{id}")
	public ResponseEntity<ResponseStructure<MaterialOrder>> deleteOrder(@PathVariable String id){
		return service.deleteOrder(id);
	}
	
	@ApiOperation(value = "Fetch orders", notes="API is used to fetch the order with given order ID")
	@ApiResponses(value = {
			@ApiResponse(code = 201,message="Successfully fetched"),
			@ApiResponse(code=404,message="Id not found for the given order ID")
	})
	@GetMapping("/order/{id}")
	public ResponseEntity<ResponseStructure<MaterialOrder>> getOrderById(@PathVariable String id){
		return service.getOrderById(id);
	}
	

	
}
