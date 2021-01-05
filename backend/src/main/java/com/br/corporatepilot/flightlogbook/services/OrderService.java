package com.br.corporatepilot.flightlogbook.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.corporatepilot.flightlogbook.dto.OrderDTO;
import com.br.corporatepilot.flightlogbook.dto.ProductDTO;
import com.br.corporatepilot.flightlogbook.entities.Order;
import com.br.corporatepilot.flightlogbook.entities.OrderStatus;
import com.br.corporatepilot.flightlogbook.entities.Product;
import com.br.corporatepilot.flightlogbook.repository.OrderRepository;
import com.br.corporatepilot.flightlogbook.repository.ProductRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll(){
		List<Order> list = repository.findOrdersWithProducts();
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public OrderDTO insert(OrderDTO dto){
		Order order = new Order(null, dto.getAddress(), dto.getLatitude(), dto.getLongitude(), Instant.now(), OrderStatus.PENDING);
				
		for (ProductDTO p : dto.getProducts()) {
			Product product = productRepository.getOne(p.getId());
			order.getProducts().add(product);
		}
		
		order = repository.save(order);
		return new OrderDTO(order);
	}
}
	