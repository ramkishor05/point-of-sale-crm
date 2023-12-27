package com.brijframework.crm.entities;

import static com.brijframework.crm.contants.Constants.CUST_BUSINESS_APP_ID;
import static com.brijframework.crm.contants.Constants.EMAIL_ADDRESS;
import static com.brijframework.crm.contants.Constants.EOCUSTOMER;
import static com.brijframework.crm.contants.Constants.MOBILE_NUMBER;
import static com.brijframework.crm.contants.Constants.NAME;
import static com.brijframework.crm.contants.Constants.PERMAMENT_ADDRESS;
import static com.brijframework.crm.contants.Constants.PHONE_NUMBER;
import static com.brijframework.crm.contants.Constants.PRESENT_ADDRESS;
import static com.brijframework.crm.contants.Constants.TRUE;
import static com.brijframework.crm.contants.Constants.VENDOR_ID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = EOCUSTOMER, uniqueConstraints = { @UniqueConstraint(columnNames = { NAME, VENDOR_ID }) })
public class EOCustomer extends EOCrmObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

	@JoinColumn(name = VENDOR_ID, nullable = TRUE)
	@ManyToOne
	private EOVendor vendor;
	
	@JoinColumn(name = CUST_BUSINESS_APP_ID, nullable = false)
	@ManyToOne
	private EOCustBusinessApp custBusinessApp;

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

	public EOCustBusinessApp getCustBusinessApp() {
		return custBusinessApp;
	}

	public void setCustBusinessApp(EOCustBusinessApp custBusinessApp) {
		this.custBusinessApp = custBusinessApp;
	}
}
