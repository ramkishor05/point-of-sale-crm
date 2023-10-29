package com.brijframework.crm.mapper;

import static com.brijframework.crm.contants.Constants.COM_BRIJFRAMEWORK_PRODUCTION_MAPPER_IMPL;
import static com.brijframework.crm.contants.Constants.SPRING;

import org.mapstruct.Mapper;

import com.brijframework.crm.dto.UISupplierDetail;
import com.brijframework.crm.entities.EOSupplier;

@Mapper(componentModel = SPRING, implementationPackage = COM_BRIJFRAMEWORK_PRODUCTION_MAPPER_IMPL)
public interface SupplierDetailMapper extends GenericMapper<EOSupplier, UISupplierDetail> {

}
