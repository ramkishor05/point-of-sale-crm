package com.brijframework.crm.filters;

import static com.brijframework.crm.contants.Constants.APP_ID_KEY;
import static com.brijframework.crm.contants.Constants.BUSINESS_ID_KEY;
import static com.brijframework.crm.contants.Constants.CUST_APP_ID;
import static com.brijframework.crm.contants.Constants.OWNER_ID_KEY;

import java.io.IOException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.brijframework.crm.entities.EOCustBusinessApp;
import com.brijframework.crm.repository.CustBusinessAppRepository;
import com.brijframework.crm.utils.CommanUtil;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

@Component
@Order(0)
public class TransactionFilter implements Filter {
	
	@Autowired
	private CustBusinessAppRepository custBusinessAppRepository;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String ownerId = req.getHeader(OWNER_ID_KEY);
        String appId = req.getHeader(APP_ID_KEY);
        String businessId = req.getHeader(BUSINESS_ID_KEY);
        MutableHttpServletRequest requestWrapper = new MutableHttpServletRequest(req);
        if(Objects.nonNull(ownerId)&& CommanUtil.isNumeric(ownerId) && Objects.nonNull(businessId) && CommanUtil.isNumeric(businessId) && Objects.nonNull(appId) && CommanUtil.isNumeric(appId)) {
        	custBusinessAppRepository.findByCustIdAndAppIdAndBusinessId(Long.valueOf(ownerId), Long.valueOf(appId),Long.valueOf(businessId)).ifPresent((custBusinessApp)->{
        		requestWrapper.putHeader(CUST_APP_ID, ""+custBusinessApp.getId());
        		req.setAttribute(CUST_APP_ID, ""+custBusinessApp.getId());
        	});
        } else  if(Objects.nonNull(ownerId) && CommanUtil.isNumeric(ownerId) && Objects.nonNull(businessId)&& CommanUtil.isNumeric(businessId)) {
         	custBusinessAppRepository.findByCustIdAndAppIdAndBusinessId(Long.valueOf(ownerId), Long.valueOf(1l),Long.valueOf(businessId)).ifPresent((custBusinessApp)->{
         		requestWrapper.putHeader(CUST_APP_ID, ""+custBusinessApp.getId());
         		req.setAttribute(CUST_APP_ID, ""+custBusinessApp.getId());
         	});
         } else  if(Objects.nonNull(ownerId)&& CommanUtil.isNumeric(ownerId)) {
         	custBusinessAppRepository.findByCustIdAndAppId(Long.valueOf(ownerId), Long.valueOf(1l)).ifPresent((custBusinessAppList)->{
         		for(EOCustBusinessApp custBusinessApp : custBusinessAppList) {
	         		requestWrapper.putHeader(CUST_APP_ID, ""+custBusinessApp.getId());
	         		req.setAttribute(CUST_APP_ID, ""+custBusinessApp.getId());
         		}
         	});
         }
        
        chain.doFilter(requestWrapper, response);
    }
}