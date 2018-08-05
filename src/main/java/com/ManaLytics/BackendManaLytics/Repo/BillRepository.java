package com.ManaLytics.BackendManaLytics.Repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ManaLytics.BackendManaLytics.DTO.BillDTO;
import com.ManaLytics.BackendManaLytics.DTO.EventHistoryDTO;
@Repository
public interface BillRepository extends JpaRepository<BillDTO, Long> {
	
	@Query(value = "SELECT * FROM Bill b WHERE b.billdate >= :from AND b.billdate <= :to ORDER BY b.billId DESC", nativeQuery=true)
	public  Page<BillDTO> getBillsFromAndTo(@Param("from") Date bdate, @Param("to") Date bdate1, Pageable pagerequest);

}
