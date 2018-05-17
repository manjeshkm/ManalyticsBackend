package com.ManaLytics.BackendManaLytics.DTO;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class EventHistoryDTO implements Serializable {
	public EventHistoryDTO() {
		
	}

public EventHistoryDTO(Long eid, Date edate, Date etime, String pname, String event, String pdescrp) {
		super();
		this.eid = eid;
		this.edate = edate;
		this.etime = etime;
		this.pname = pname;
		this.event = event;
		this.pdescrp = pdescrp;
	}

@Id @GeneratedValue
private Long eid;

@Temporal(TemporalType.DATE)
private Date edate;
@Temporal(TemporalType.TIMESTAMP)
private Date etime = edate;
private String pname;
private String event;
private String pdescrp;

public Long getEid() {
	return eid;
}
public void setEid(Long eid) {
	this.eid = eid;
}
public Date getEdate() {
	return edate;
}
public void setEdate(Date edate) {
	this.edate = edate;
}
public Date getEtime() {
	return etime;
}
public void setEtime(Date etime) {
	this.etime = etime;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public String getEvent() {
	return event;
}
public void setEvent(String event) {
	this.event = event;
}
public String getPdescrp() {
	return pdescrp;
}
public void setPdescrp(String pdescrp) {
	this.pdescrp = pdescrp;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((edate == null) ? 0 : edate.hashCode());
	result = prime * result + ((eid == null) ? 0 : eid.hashCode());
	result = prime * result + ((etime == null) ? 0 : etime.hashCode());
	result = prime * result + ((event == null) ? 0 : event.hashCode());
	result = prime * result + ((pdescrp == null) ? 0 : pdescrp.hashCode());
	result = prime * result + ((pname == null) ? 0 : pname.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	EventHistoryDTO other = (EventHistoryDTO) obj;
	if (edate == null) {
		if (other.edate != null)
			return false;
	} else if (!edate.equals(other.edate))
		return false;
	if (eid == null) {
		if (other.eid != null)
			return false;
	} else if (!eid.equals(other.eid))
		return false;
	if (etime == null) {
		if (other.etime != null)
			return false;
	} else if (!etime.equals(other.etime))
		return false;
	if (event == null) {
		if (other.event != null)
			return false;
	} else if (!event.equals(other.event))
		return false;
	if (pdescrp == null) {
		if (other.pdescrp != null)
			return false;
	} else if (!pdescrp.equals(other.pdescrp))
		return false;
	if (pname == null) {
		if (other.pname != null)
			return false;
	} else if (!pname.equals(other.pname))
		return false;
	return true;
}

}
