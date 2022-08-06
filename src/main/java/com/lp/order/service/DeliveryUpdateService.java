package com.lp.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lp.order.model.OrderEvent;
import com.lp.order.repository.OrderRepository;

@Service
public class DeliveryUpdateService {
	
	@Autowired
	OrderRepository orderRepository;
	
	public void updateDeliveryStatus(OrderEvent event) {
		
		System.out.println("Delivert id:"+event.getOrder().getDeliveryId());
		//orderRepository.save(event.getOrder());
	}

}