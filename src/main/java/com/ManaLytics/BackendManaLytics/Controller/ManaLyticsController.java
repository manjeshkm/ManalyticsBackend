package com.ManaLytics.BackendManaLytics.Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ManaLytics.BackendManaLytics.DTO.BillDTO;
import com.ManaLytics.BackendManaLytics.DTO.BillingItem;
import com.ManaLytics.BackendManaLytics.DTO.EventHistoryDTO;
import com.ManaLytics.BackendManaLytics.DTO.ProductDTO;
import org.springframework.http.MediaType;

import com.ManaLytics.BackendManaLytics.Services.BillService;
import com.ManaLytics.BackendManaLytics.Services.EventService;
import com.ManaLytics.BackendManaLytics.Services.ProductService;

@RestController
public class ManaLyticsController {

	private static final Logger logger = LoggerFactory.getLogger(ManaLyticsController.class);

	@Autowired
	private EventService eventservice;
	@Autowired
	private BillService billservice;
	@Autowired
	private ProductService prodservice;

	@GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)

	Page<ProductDTO> getallProducts(@RequestParam(value = "pnum", required = false) Integer pagenum,
			@RequestParam(value = "psize", required = false) Integer pagesize,
			@PageableDefault(page = 0, size = 2, direction = Direction.ASC) Pageable page) {
		page = pageconfig(pagenum, pagesize, page);
		logger.info("Entered Controller getallProducts page method");
		return this.prodservice.getallProducts(page);
	}

	@RequestMapping(value = "/products/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	ProductDTO getProductById(@PathVariable Long id) {
		logger.info("Entered getallProductById method");
		return this.prodservice.getProductById(id);
	}

	// --> Creating new and also editing
	@PostMapping("/products")
	ProductDTO creatProduct(@Valid @RequestBody ProductDTO dto) {
		logger.info("Entered creatProduct method");
		return this.prodservice.creatProduct(dto);
	}

	@GetMapping(value = "/products/{id}/delete")
	void deleteById(@PathVariable Long id) {
		this.prodservice.deleteById(id);
	}

	@GetMapping(value = "/history", produces = MediaType.APPLICATION_JSON_VALUE)
	Page<EventHistoryDTO> getallHistory(@RequestParam(value = "pnum", required = false) Integer pagenum,
			@RequestParam(value = "psize", required = false) Integer pagesize,
			@PageableDefault(page = 0, size = 2, sort = "eid", direction = Direction.DESC) Pageable page) {
		page = pageconfig(pagenum, pagesize, page);
		logger.info("Entered getallHistory method requesting page:" + page);
		return this.eventservice.getallHistory(page);
	}

	@PostMapping("/history")
	EventHistoryDTO saveEvent(@Valid @RequestBody EventHistoryDTO dto) {
		logger.info("Entered saveEvent method with Date= " + dto.getEdate());
		return this.eventservice.saveEvent(dto);
	}

	@GetMapping(value = "/history/event", produces = MediaType.APPLICATION_JSON_VALUE)
	Page<EventHistoryDTO> getHistoryFromAndTo(@RequestParam("from") String edate, @RequestParam("to") String edate1,
			@RequestParam(value = "pnum", required = false) Integer pagenum,
			@RequestParam(value = "psize", required = false) Integer pagesize,
			@PageableDefault(page = 0, size = 2, sort = "eid", direction = Direction.DESC) Pageable page) {
		page = pageconfig(pagenum, pagesize, page);
		logger.info("Entered getHistoryFromAndTo method with from=" + edate + "to=" + edate1 + " page: " + page);
		return this.eventservice.getHistoryFromAndTo(new Date(edate), new Date(edate1), page);
	}

	@PostMapping("/bill")
	BillDTO saveBill(@Valid @RequestBody BillDTO bill) {
		logger.info("Entered saveBill method");
		return this.billservice.saveBill(bill);
	}

	@GetMapping("/savedbills")
	Page<BillDTO> getAllBills(@RequestParam(value = "pnum", required = false) Integer pagenum,
			@RequestParam(value = "psize", required = false) Integer pagesize,
			@PageableDefault(page = 0, size = 2, sort = "billId", direction = Direction.DESC) Pageable page) {
		page = pageconfig(pagenum, pagesize, page);
		logger.info("Entered getallBills");
		return this.billservice.getAllBills(page);
	}

	@GetMapping(value = "/bills", produces = MediaType.APPLICATION_JSON_VALUE)
	Page<BillDTO> getBillsFromAndTo(@RequestParam("from") String edate, @RequestParam("to") String edate1,
			@RequestParam(value = "pnum", required = false) Integer pagenum,
			@RequestParam(value = "psize", required = false) Integer pagesize,
			@PageableDefault(page = 0, size = 2, sort = "billId", direction = Direction.DESC) Pageable page) {
		page = pageconfig(pagenum, pagesize, page);
		logger.info("Entered getHistoryFromAndTo method with from=" + edate + "to=" + edate1);
		return this.billservice.getBillsFromAndTo(new Date(edate), new Date(edate1), page);
	}

	protected static Pageable pageconfig(Integer pagenum, Integer pagesize, Pageable page) {
		if (pagenum != null) {
			if (pagesize != null) {
				page = PageRequest.of(pagenum, pagesize, page.getSort());
			} else {
				page = PageRequest.of(pagenum, page.getPageSize(), page.getSort());
			}
		}
		return page;
	}
}
