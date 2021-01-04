package com.br.corporatepilot.flightlogbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.corporatepilot.flightlogbook.entities.Product;

public interface ProductRepository extends JpaRepository <Product, Long> {
	//tipo parametrizado tipo da chave primaria do produt id to tipo long
	
	List<Product> findAllByOrderByNameAsc();
}
