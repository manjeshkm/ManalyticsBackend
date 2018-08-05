package com.ManaLytics.BackendManaLytics.DAO;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.ManaLytics.BackendManaLytics.DTO.BillDTO;
import com.ManaLytics.BackendManaLytics.DTO.EventHistoryDTO;
import com.ManaLytics.BackendManaLytics.Repo.BillRepository;

@Component
@Transactional
public class BillDAO {
	private static final Logger logger = LoggerFactory.getLogger(BillDAO.class);
	@Autowired
	private BillRepository billrepo;

	public BillDTO saveBill(BillDTO bill) {

		BillDTO savedbill = this.billrepo.save(bill);
		logger.info("savedBill=" + savedbill);
		return savedbill;
	}

	public Page<BillDTO> getAllBills(Pageable page) {
		logger.info("Entered DAO getAll-bills method");
		return billrepo.findAll(page);
	}

	public Page<BillDTO> getBillsFromAndTo(Date bdate, Date bdate1, Pageable page) {

		return billrepo.getBillsFromAndTo(bdate, bdate1, page);
	}

}