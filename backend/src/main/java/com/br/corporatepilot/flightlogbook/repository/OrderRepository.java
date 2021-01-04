package com.br.corporatepilot.flightlogbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.br.corporatepilot.flightlogbook.entities.Order;


public interface OrderRepository extends JpaRepository <Order, Long> {
	//tipo parametrizado tipo da chave primaria do produt id to tipo long
	
	@Query("SELECT DISTINCT obj FROM Order obj JOIN FETCH obj.products "
			+ " WHERE obj.status= 0 ORDER BY obj.moment ASC")
	List<Order> findOrdersWithProducts();
}
