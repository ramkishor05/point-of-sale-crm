package com.brijframework.crm.mapper;
import static com.brijframework.crm.contants.Constants.COM_BRIJFRAMEWORK_CUST_PRODUCTION_MAPPER_IMPL;
import static com.brijframework.crm.contants.Constants.SPRING;

import org.mapstruct.Mapper;

import com.brijframework.crm.dto.UICustBusinessApp;
import com.brijframework.crm.entities.EOCustBusinessApp;

@Mapper(componentModel = SPRING, implementationPackage = COM_BRIJFRAMEWORK_CUST_PRODUCTION_MAPPER_IMPL)
public interface CustBusinessAppMapper extends GenericMapper<EOCustBusinessApp, UICustBusinessApp>{

}
