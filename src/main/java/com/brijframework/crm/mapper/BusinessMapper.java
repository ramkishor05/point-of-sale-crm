package com.brijframework.crm.mapper;

import static com.brijframework.crm.contants.Constants.COM_BRIJFRAMEWORK_PRODUCTION_MAPPER_IMPL;
import static com.brijframework.crm.contants.Constants.SPRING;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.brijframework.crm.dto.UIBusiness;
import com.brijframework.crm.entities.EOBusiness;

@Mapper(componentModel = SPRING, implementationPackage = COM_BRIJFRAMEWORK_PRODUCTION_MAPPER_IMPL)
public interface BusinessMapper extends GenericMapper<EOBusiness, UIBusiness> {

	@Mapping(target = "countryId", source = "country.id")
	@Mapping(target = "ownerId", source = "vendor.id")
	UIBusiness mapToDTO(EOBusiness eoBusiness);
}
