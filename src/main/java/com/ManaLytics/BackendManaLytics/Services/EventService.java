package com.ManaLytics.BackendManaLytics.Services;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ManaLytics.BackendManaLytics.DAO.EventDAO;
import com.ManaLytics.BackendManaLytics.DTO.EventHistoryDTO;

@Service
public class EventService {
	private static final Logger logger = LoggerFactory.getLogger(EventService.class);
	@Autowired
	private EventDAO eventdao;
	
	public Page<EventHistoryDTO> getallHistory(Pageable page) {
		return this.eventdao.getallHistory(page);
	}
	
	public EventHistoryDTO saveEvent(EventHistoryDTO dto) {
		logger.info("saving event= " + dto);
		return this.eventdao.saveEvent(dto);
	}
	
	public Page<EventHistoryDTO> getHistoryFromAndTo(Date edate, Date edate1, Pageable page) {
	return	this.eventdao.getHistoryFromAndTo(edate, edate1, page);
	}

}
