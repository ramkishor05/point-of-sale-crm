package com.brijframework.crm.entities;

import static com.brijframework.crm.contants.Constants.EOGLOBAL_COUNTRY;
import static com.brijframework.crm.contants.Constants.IDEN_NO;
import static com.brijframework.crm.contants.Constants.NAME;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = EOGLOBAL_COUNTRY, uniqueConstraints = { @UniqueConstraint(columnNames = { NAME})})
public class EOGlobalCountry extends EOEntityObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = IDEN_NO)
	private String idenNo;
	
	@Column(name = NAME)
	private String name;
	
	@JoinColumn(name = "CURRENCY_ID")
	@OneToOne
	private EOGlobalCurrencyItem currency;

	public String getIdenNo() {
		return idenNo;
	}

	public void setIdenNo(String idenNo) {
		this.idenNo = idenNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EOGlobalCurrencyItem getCurrency() {
		return currency;
	}

	public void setCurrency(EOGlobalCurrencyItem currency) {
		this.currency = currency;
	}
}
