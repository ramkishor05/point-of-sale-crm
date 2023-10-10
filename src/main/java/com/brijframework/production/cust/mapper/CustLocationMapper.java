package com.brijframework.production.cust.mapper;
import static com.brijframework.production.contants.Constants.COM_BRIJFRAMEWORK_CUST_PRODUCTION_MAPPER_IMPL;
import static com.brijframework.production.contants.Constants.CUST_PROD_APP_ID_ENTITY;
import static com.brijframework.production.contants.Constants.CUST_PROD_APP_ID_UI;
import static com.brijframework.production.contants.Constants.CUST_STORAGE_ID_ENTITY;
import static com.brijframework.production.contants.Constants.CUST_STORAGE_ID_UI;
import static com.brijframework.production.contants.Constants.SPRING;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.brijframework.production.cust.dto.UICustLocation;
import com.brijframework.production.cust.entities.EOCustLocation;
import com.brijframework.production.mapper.GenericMapper;

@Mapper(componentModel = SPRING, implementationPackage = COM_BRIJFRAMEWORK_CUST_PRODUCTION_MAPPER_IMPL)
public interface CustLocationMapper  extends GenericMapper<EOCustLocation, UICustLocation>{

	@Mapping(target=CUST_PROD_APP_ID_ENTITY, source=CUST_PROD_APP_ID_UI)
	@Mapping(target=CUST_STORAGE_ID_ENTITY, source=CUST_STORAGE_ID_UI)
	@Override
	EOCustLocation mapToDAO(UICustLocation uiCustLocation);
	
	@Mapping(source=CUST_PROD_APP_ID_ENTITY, target=CUST_PROD_APP_ID_UI)
	@Mapping(source=CUST_STORAGE_ID_ENTITY, target=CUST_STORAGE_ID_UI)
	@Override
	UICustLocation mapToDTO(EOCustLocation eoCustLocation);
}
