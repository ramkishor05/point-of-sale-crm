package com.brijframework.crm.mapper;

import static com.brijframework.crm.contants.Constants.COM_BRIJFRAMEWORK_PRODUCTION_MAPPER_IMPL;
import static com.brijframework.crm.contants.Constants.SPRING;

import org.mapstruct.Mapper;

import com.brijframework.crm.dto.UICustomerDetail;
import com.brijframework.crm.entities.EOCustomer;

@Mapper(componentModel = SPRING, implementationPackage = COM_BRIJFRAMEWORK_PRODUCTION_MAPPER_IMPL)
public interface CustomerDetailMapper extends GenericMapper<EOCustomer, UICustomerDetail> {

}
