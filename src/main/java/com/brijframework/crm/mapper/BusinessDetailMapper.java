package com.brijframework.crm.mapper;

import static com.brijframework.crm.contants.Constants.COM_BRIJFRAMEWORK_PRODUCTION_MAPPER_IMPL;
import static com.brijframework.crm.contants.Constants.SPRING;

import org.mapstruct.Mapper;

import com.brijframework.crm.dto.UIBusinessDetail;
import com.brijframework.crm.entities.EOBusiness;

@Mapper(componentModel = SPRING, implementationPackage = COM_BRIJFRAMEWORK_PRODUCTION_MAPPER_IMPL)
public interface BusinessDetailMapper extends GenericMapper<EOBusiness, UIBusinessDetail> {

}
