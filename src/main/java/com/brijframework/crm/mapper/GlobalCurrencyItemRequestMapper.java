package com.brijframework.crm.mapper;

import static com.brijframework.crm.contants.Constants.COM_BRIJFRAMEWORK_PRODUCTION_MAPPER_IMPL;
import static com.brijframework.crm.contants.Constants.SPRING;

import org.mapstruct.Mapper;

import com.brijframework.crm.dto.GlobalCurrencyItemRequest;
import com.brijframework.crm.entities.EOGlobalCurrencyItem;


@Mapper(componentModel = SPRING, implementationPackage = COM_BRIJFRAMEWORK_PRODUCTION_MAPPER_IMPL)
public interface GlobalCurrencyItemRequestMapper extends GenericMapper<EOGlobalCurrencyItem, GlobalCurrencyItemRequest>{

}
