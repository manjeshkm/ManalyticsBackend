package com.ManaLytics.BackendManaLytics.DAO;

import java.text.SimpleDateFormat;
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

import com.ManaLytics.BackendManaLytics.DTO.EventHistoryDTO;
import com.ManaLytics.BackendManaLytics.Repo.EventHistoryRepository;


@Component
@Transactional
public class EventDAO {
	private static final Logger logger = LoggerFactory.getLogger(EventDAO.class);
	@Autowired
	private EventHistoryRepository eventrepo;

	public Page<EventHistoryDTO> getallHistory(Pageable page) {
		logger.info("Entered DAO getallHistory method");
		return eventrepo.findAll(page);
	}

	public EventHistoryDTO saveEvent(EventHistoryDTO dto) {
		
		EventHistoryDTO savedevent = eventrepo.save(dto);
		logger.info("savedEvent=" + savedevent);
		return savedevent;
	}

	public Page<EventHistoryDTO> getHistoryFromAndTo(Date edate, Date edate1, Pageable page) {
		Page<EventHistoryDTO> eventfromto = eventrepo.findByEdateGreaterThanEdateAndLessThanEdate(edate, edate1, page);
		logger.info("eventfromandto=" + eventfromto);
		return eventfromto;
	}
}
