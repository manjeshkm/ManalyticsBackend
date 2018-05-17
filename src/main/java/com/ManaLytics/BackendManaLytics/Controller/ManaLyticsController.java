package com.ManaLytics.BackendManaLytics.Controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ManaLytics.BackendManaLytics.DTO.EventHistoryDTO;
import com.ManaLytics.BackendManaLytics.DTO.ProductDTO;
import org.springframework.http.MediaType;

import com.ManaLytics.BackendManaLytics.Repo.EventHistoryrepository;
import com.ManaLytics.BackendManaLytics.Repo.ProductsRepository;


@RestController
public class ManaLyticsController {

	@Autowired
	private ProductsRepository productrepo;
	@Autowired
	private EventHistoryrepository eventrepo;

	@GetMapping(value="/products",  produces=MediaType.APPLICATION_JSON_VALUE)
	Collection<ProductDTO> getallproducts() {
		
		return productrepo.findAll().stream().collect(Collectors.toList());
//		java.util.List<ProductDTO> list = new ArrayList<>();
//		Iterable<ProductDTO> customers = productrepo.findAll();
// 
//		customers.forEach(list::add);
//		return list;
		//return productrepo.findAll();
	}
	
	@GetMapping(value="/history",  produces=MediaType.APPLICATION_JSON_VALUE)
	Collection<EventHistoryDTO> getallHistory() {
		return eventrepo.findAll().stream().collect(Collectors.toList());
	}

	@RequestMapping(value = "/products/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	ProductDTO getProductbyId(@PathVariable Long id) {
		return productrepo.findById(id).get();
	}

	@PostMapping("/products")
	ProductDTO creatproduct(@Valid @RequestBody ProductDTO dto) {
		return productrepo.save(dto);
	}
	
	@PostMapping("/history")
	EventHistoryDTO saveEvent(@Valid @RequestBody EventHistoryDTO dto) {
		System.out.println("date" + dto.getEdate());
		return eventrepo.save(dto);
	}
	
//	@GetMapping(value = "/products/{id}/put")
//	ProductDTO editProductById(@PathVariable Long id, @Valid @RequestBody ProductDTO editedProduct) {
//		return productrepo.save(editedProduct);
//	}
	
	@GetMapping(value = "/products/{id}/delete")
	void deleteById(@PathVariable Long id) {												
	 productrepo.deleteById(id);
	}
	
	@GetMapping(value = "/history/event", produces = MediaType.APPLICATION_JSON_VALUE)
	List<EventHistoryDTO> getHistoryFromAndTo(@RequestParam("from") Date edate, @RequestParam("to") Date edate1){
		System.out.println("-------->>>>>>>>------>>>>>>----from=" + edate);
		return eventrepo.findByEdateGreaterThanEdateAndLessThanEdate(edate, edate1);
	}
}
