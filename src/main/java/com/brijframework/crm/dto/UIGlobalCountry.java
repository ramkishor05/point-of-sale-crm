package com.brijframework.crm.dto;

public class UIGlobalCountry extends UIComman{

	private String idenNo;
	
	private GlobalCurrencyItemResponse currency;

	public String getIdenNo() {
		return idenNo;
	}

	public void setIdenNo(String idenNo) {
		this.idenNo = idenNo;
	}

	public GlobalCurrencyItemResponse getCurrency() {
		return currency;
	}

	public void setCurrency(GlobalCurrencyItemResponse currency) {
		this.currency = currency;
	}
}
