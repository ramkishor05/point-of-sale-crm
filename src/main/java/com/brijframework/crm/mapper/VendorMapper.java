package com.brijframework.crm.mapper;

import static com.brijframework.crm.contants.Constants.COM_BRIJFRAMEWORK_PRODUCTION_MAPPER_IMPL;
import static com.brijframework.crm.contants.Constants.SPRING;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.brijframework.crm.dto.UIVendor;
import com.brijframework.crm.entities.EOVendor;

@Mapper(componentModel = SPRING, implementationPackage = COM_BRIJFRAMEWORK_PRODUCTION_MAPPER_IMPL)
public interface VendorMapper extends GenericMapper<EOVendor, UIVendor> {

	@Override
	@Mapping(source = "parentVendor.id", target = "parentVendorId")
	public UIVendor mapToDTO(EOVendor eoVendor);

	@Override
	public default List<UIVendor> mapToDTO(List<EOVendor> eoVendorList) {
		if (eoVendorList == null || eoVendorList.isEmpty()) {
			return null;
		}

		List<UIVendor> list = new ArrayList<UIVendor>();
		for (EOVendor eOVendor : eoVendorList) {
			list.add(mapToDTO(eOVendor));
		}

		return list;
	}
	
	@Override
	@Mapping(target = "parentVendor.id", source = "parentVendorId")
	EOVendor mapToDAO(UIVendor eoObject);

	@Override
	public default List<EOVendor> mapToDAO(List<UIVendor> uiVendorList) {
		if (uiVendorList == null || uiVendorList.isEmpty()) {
			return null;
		}

		List<EOVendor> list = new ArrayList<EOVendor>();
		for (UIVendor uIVendor : uiVendorList) {
			list.add(mapToDAO(uIVendor));
		}

		return list;
	}
}
