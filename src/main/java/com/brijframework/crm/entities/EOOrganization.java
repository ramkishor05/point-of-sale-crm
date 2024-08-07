package com.brijframework.crm.entities;

import static com.brijframework.crm.contants.Constants.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = EOORGANIZATION, uniqueConstraints = { @UniqueConstraint(columnNames = { NAME, VENDOR_ID }) })
public class EOOrganization extends EOEntityObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String CUURENT_SELECTED = "CUURENT_SELECTED";

	private static final String COUNTRY_ID = "COUNTRY_ID";

	@Column(name = NAME)
	private String name;

	@Column(name = PHONE_NUMBER)
	private String phoneNumber;

	@Column(name = MOBILE_NUMBER)
	private String mobileNumber;

	@Column(name = EMAIL_ADDRESS)
	private String emailAddress;

	@Column(name = PERMAMENT_ADDRESS)
	@Lob
	private String permamentAddress;

	@Column(name = PRESENT_ADDRESS)
	@Lob
	private String presentAddress;
	
	@Column(name = CUURENT_SELECTED)
	private Boolean selected;

	@JoinColumn(name = VENDOR_ID)
	@ManyToOne
	private EOVendor vendor;
	
	@JoinColumn(name = COUNTRY_ID)
	@ManyToOne
	private EOGlobalCountry country;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPermamentAddress() {
		return permamentAddress;
	}

	public void setPermamentAddress(String permamentAddress) {
		this.permamentAddress = permamentAddress;
	}

	public String getPresentAddress() {
		return presentAddress;
	}

	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}

	public EOVendor getVendor() {
		return vendor;
	}

	public void setVendor(EOVendor vendor) {
		this.vendor = vendor;
	}

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	public EOGlobalCountry getCountry() {
		return country;
	}

	public void setCountry(EOGlobalCountry country) {
		this.country = country;
	}
	
	
}
