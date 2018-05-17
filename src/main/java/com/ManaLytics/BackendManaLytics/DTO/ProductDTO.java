package com.ManaLytics.BackendManaLytics.DTO;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ProductDTO implements Serializable{
	@Id
	@GeneratedValue
	Long id;
	private String pname;
	private int Pqvalue;
	private String pqtype;
	private float pcost;
	private String purl;
	private String pdescrp;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPqtype() {
		return pqtype;
	}

	public void setPqtype(String pqtype) {
		this.pqtype = pqtype;
	}

	public float getPcost() {
		return pcost;
	}

	public void setPcost(float pcost) {
		this.pcost = pcost;
	}

	public String getPurl() {
		return purl;
	}

	public void setPurl(String purl) {
		this.purl = purl;
	}

	public String getPdescrp() {
		return pdescrp;
	}

	public void setPdescrp(String pdescrp) {
		this.pdescrp = pdescrp;
	}

	public ProductDTO() {

	}

	public ProductDTO(Long id, String pname, int pquantity, String pqtype, float pcost, String purl, String pdescrp) {
		super();
		this.id = id;
		this.pname = pname;
		Pqvalue = pquantity;
		this.pqtype = pqtype;
		this.pcost = pcost;
		this.purl = purl;
		this.pdescrp = pdescrp;
	}

	public int getPqvalue() {
		return Pqvalue;
	}

	public void setPqvalue(int pqvalue) {
		Pqvalue = pqvalue;
	}
	
}
