package br.com.servletappexample.model;

import java.util.Date;

public class Company {

	private Integer idCompany;
	private String name;
	private Date dateEntry = new Date();
	
	public Integer getidCompany() {
		return idCompany;
	}
	public void setidCompany(Integer idCompany) {
		this.idCompany = idCompany;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDateEntry(Date dateEntry) {
		this.dateEntry = dateEntry;
	}
	
	public Date getDateEntry() {
		return dateEntry;
	}
}