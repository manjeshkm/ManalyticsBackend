package com.ManaLytics.BackendManaLytics.DTO;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="BillingItem_Table")
public class BillingItem {

	public BillingItem(int id, BillProductDTO billProd, float prodcount, float itemPrice) {
		super();
		this.id = id;
		this.billProd = billProd;
		this.prodcount = prodcount;
		this.itemPrice = itemPrice;
	}

	public BillingItem() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Autowired
	@OneToOne(optional=true,cascade = { CascadeType.ALL })
	@JoinColumn(name="Billitem_Product_ID")
	private BillProductDTO billProd;
	private float prodcount;
	private float itemPrice;

	public BillProductDTO getBillProd() {
		return billProd;
	}

	public void setBillProd(BillProductDTO billProd) {
		this.billProd = billProd;
	}

	public float getProdcount() {
		return prodcount;
	}

	public void setProdcount(float prodcount) {
		this.prodcount = prodcount;
	}

	public float getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}

	@Override
	public String toString() {
		return "BillingProduct [id=" + id + ", billProd=" + billProd + ", prodcount=" + prodcount + ", itemPrice="
				+ itemPrice + "]";
	}
	
}
