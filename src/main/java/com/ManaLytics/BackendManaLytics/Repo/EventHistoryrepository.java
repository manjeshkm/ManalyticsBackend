package com.ManaLytics.BackendManaLytics.Repo;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;
//import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ManaLytics.BackendManaLytics.DTO.EventHistoryDTO;

public interface EventHistoryrepository extends JpaRepository<EventHistoryDTO,Long> {
	@Query(value = "SELECT * FROM eventhistorydto eh ORDER BY eh.eid DESC", nativeQuery=true)
	public List<EventHistoryDTO> findAll();
	
	@Query(value = "SELECT * FROM eventhistorydto eh WHERE eh.edate >= :from AND eh.edate <= :to ORDER BY eh.eid DESC", nativeQuery=true)
	public  List<EventHistoryDTO> findByEdateGreaterThanEdateAndLessThanEdate(@Param("from") Date edate, @Param("to") Date edate1);
}
