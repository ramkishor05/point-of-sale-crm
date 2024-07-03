package com.brijframework.crm.entities;

import static com.brijframework.crm.contants.Constants.*;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class EOCrmObject extends EOEntityObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = ACCOUNT_ID, nullable = true)
	private Long accountId;
	
	@Column(name = PORTAL_ACCESS, nullable = true)
	private Boolean portalAccess;
	
	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Boolean getPortalAccess() {
		return portalAccess;
	}

	public void setPortalAccess(Boolean portalAccess) {
		this.portalAccess = portalAccess;
	}
	
}
