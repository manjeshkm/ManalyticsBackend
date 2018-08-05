package com.ManaLytics.BackendManaLytics.Repo;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
//import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.ManaLytics.BackendManaLytics.DTO.EventHistoryDTO;
@Repository
public interface EventHistoryRepository extends JpaRepository<EventHistoryDTO,Long> {
	
	@Query(value = "SELECT * FROM EventsHistory_Table eh WHERE eh.edate >= :from AND eh.edate <= :to ORDER BY eh.eid DESC",nativeQuery=true)
	public  Page<EventHistoryDTO> findByEdateGreaterThanEdateAndLessThanEdate(@Param("from") Date edate, @Param("to") Date edate1, Pageable pagerequest);
}
