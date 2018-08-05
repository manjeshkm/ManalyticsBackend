package com.ManaLytics.BackendManaLytics.Services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ManaLytics.BackendManaLytics.DAO.ProductDAO;
import com.ManaLytics.BackendManaLytics.DTO.ProductDTO;

@Service
public class ProductService {
	private static final Logger logger = LoggerFactory.getLogger(ProductService.class);
	@Autowired
	private ProductDAO prodDAO;

	public Page<ProductDTO> getallProducts(Pageable pagerequest) {

		return this.prodDAO.getallProducts(pagerequest);
	}

	public ProductDTO getProductById(Long id) {

		return this.prodDAO.getProductById(id);
	}

	public ProductDTO creatProduct(ProductDTO dto) {

		return this.prodDAO.creatProduct(dto);
	}

	public void deleteById(Long id) {
		this.prodDAO.deleteById(id);
	}

	public void updateProductQuantity(Long id, float prodcount) {
		float quantity = this.prodDAO.getProductById(id).getPqvalue() - prodcount;
		this.prodDAO.updateProductQuantity(id, quantity);
	}
	

}
