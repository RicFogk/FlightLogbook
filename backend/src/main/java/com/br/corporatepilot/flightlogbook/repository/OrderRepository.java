package com.br.corporatepilot.flightlogbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.corporatepilot.flightlogbook.entities.Order;
import com.br.corporatepilot.flightlogbook.entities.Product;

public interface OrderRepository extends JpaRepository <Order, Long> {
	//tipo parametrizado tipo da chave primaria do produt id to tipo long
	

}
