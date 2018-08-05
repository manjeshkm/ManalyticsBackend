package com.ManaLytics.BackendManaLytics.DTO;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Bill")
public class BillDTO {

	public BillDTO() {
	}

	public BillDTO(Long billId, List<BillingItem> bill, float total, String customerName, long customerContactNumber,
			Date billdate, Date billtime) {
		super();
		this.billId = billId;
		this.bill = bill;
		this.total = total;
		this.customerName = customerName;
		this.customerContactNumber = customerContactNumber;
		this.billdate = billdate;
		this.billtime = billtime;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long billId;
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name="Bill_id")
	private List<BillingItem> bill;
	private float total;
	private String customerName;
	private long customerContactNumber;
	@Temporal(TemporalType.DATE)
	private Date billdate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date billtime = new Date();

	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public List<BillingItem> getBill() {
		return bill;
	}

	public void setBill(List<BillingItem> bill) {
		this.bill = bill;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getCustomerContactNumber() {
		return customerContactNumber;
	}

	public void setCustomerContactNumber(long customerContactNumber) {
		this.customerContactNumber = customerContactNumber;
	}

	public Date getBilldate() {
		return billdate;
	}

	public void setBilldate(Date billdate) {
		this.billdate = billdate;
	}

	public Date getBilltime() {
		return billtime;
	}

	public void setBilltime(Date billtime) {
		this.billtime = billtime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bill == null) ? 0 : bill.hashCode());
		result = prime * result + ((billId == null) ? 0 : billId.hashCode());
		result = prime * result + ((billdate == null) ? 0 : billdate.hashCode());
		result = prime * result + ((billtime == null) ? 0 : billtime.hashCode());
		result = prime * result + (int) (customerContactNumber ^ (customerContactNumber >>> 32));
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + Float.floatToIntBits(total);
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
		BillDTO other = (BillDTO) obj;
		if (bill == null) {
			if (other.bill != null)
				return false;
		} else if (!bill.equals(other.bill))
			return false;
		if (billId == null) {
			if (other.billId != null)
				return false;
		} else if (!billId.equals(other.billId))
			return false;
		if (billdate == null) {
			if (other.billdate != null)
				return false;
		} else if (!billdate.equals(other.billdate))
			return false;
		if (billtime == null) {
			if (other.billtime != null)
				return false;
		} else if (!billtime.equals(other.billtime))
			return false;
		if (customerContactNumber != other.customerContactNumber)
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (Float.floatToIntBits(total) != Float.floatToIntBits(other.total))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BillDTO [billId=" + billId + ", bill=" + bill + ", total=" + total + ", customerName=" + customerName
				+ ", customerContactNumber=" + customerContactNumber + ", billdate=" + billdate + ", billtime="
				+ billtime + "]";
	}

}
