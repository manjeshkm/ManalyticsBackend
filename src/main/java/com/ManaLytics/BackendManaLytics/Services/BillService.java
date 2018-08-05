package com.ManaLytics.BackendManaLytics.Services;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ManaLytics.BackendManaLytics.DAO.BillDAO;
import com.ManaLytics.BackendManaLytics.DTO.BillDTO;
import com.ManaLytics.BackendManaLytics.DTO.BillingItem;
import com.ManaLytics.BackendManaLytics.Repo.EventHistoryRepository;

@Service
public class BillService {
	private static final Logger logger = LoggerFactory.getLogger(BillService.class);
	@Autowired
	private BillDAO billdao;

	@Autowired
	private ProductService prodservice;

	public BillDTO saveBill(BillDTO bill) {
		BillDTO savedbill = this.billdao.saveBill(bill);
		List<BillingItem> billitem = bill.getBill();
		billitem.forEach(item -> {
			this.prodservice.updateProductQuantity(item.getBillProd().getId(), item.getProdcount());
			logger.info("update product id=" + item.getBillProd().getId() + "and quantity="
					+ item.getBillProd().getPqvalue());
		});
		return savedbill;
	}

	public Page<BillDTO> getAllBills(Pageable page) {
		Page<BillDTO> bills = this.billdao.getAllBills(page);
		logger.info("fetched bills in service = " + bills);
		return bills;
	}

	public Page<BillDTO> getBillsFromAndTo(Date date, Date date2, Pageable page) {
		Page<BillDTO> bills = this.billdao.getBillsFromAndTo(date, date2, page);
		logger.info("fetched from-to bills in service = " + bills);
		return bills;
	}
}
