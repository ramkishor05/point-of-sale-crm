package com.brijframework.crm.mapper.impl;

import com.brijframework.crm.dto.UIVendorDetail;
import com.brijframework.crm.entities.EOVendor;
import com.brijframework.crm.mapper.VendorDetailMapper;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-13T22:03:45+0530",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.19 (Oracle Corporation)"
)
@Component
public class VendorDetailMapperImpl implements VendorDetailMapper {

    @Override
    public UIVendorDetail mapToDTO(EOVendor eoRole) {
        if ( eoRole == null ) {
            return null;
        }

        UIVendorDetail uIVendorDetail = new UIVendorDetail();

        if ( eoRole.getId() != null ) {
            uIVendorDetail.setId( eoRole.getId() );
        }
        uIVendorDetail.setAccountId( eoRole.getAccountId() );
        uIVendorDetail.setPortalAccess( eoRole.getPortalAccess() );
        uIVendorDetail.setName( eoRole.getName() );
        uIVendorDetail.setPhoneNumber( eoRole.getPhoneNumber() );
        uIVendorDetail.setMobileNumber( eoRole.getMobileNumber() );
        uIVendorDetail.setEmailAddress( eoRole.getEmailAddress() );
        uIVendorDetail.setPermamentAddress( eoRole.getPermamentAddress() );
        uIVendorDetail.setPresentAddress( eoRole.getPresentAddress() );

        return uIVendorDetail;
    }

    @Override
    public EOVendor mapToDAO(UIVendorDetail eoRoleDTO) {
        if ( eoRoleDTO == null ) {
            return null;
        }

        EOVendor eOVendor = new EOVendor();

        eOVendor.setId( eoRoleDTO.getId() );
        eOVendor.setAccountId( eoRoleDTO.getAccountId() );
        eOVendor.setPortalAccess( eoRoleDTO.getPortalAccess() );
        eOVendor.setName( eoRoleDTO.getName() );
        eOVendor.setPhoneNumber( eoRoleDTO.getPhoneNumber() );
        eOVendor.setMobileNumber( eoRoleDTO.getMobileNumber() );
        eOVendor.setEmailAddress( eoRoleDTO.getEmailAddress() );
        eOVendor.setPermamentAddress( eoRoleDTO.getPermamentAddress() );
        eOVendor.setPresentAddress( eoRoleDTO.getPresentAddress() );

        return eOVendor;
    }

    @Override
    public List<EOVendor> mapToDAO(List<UIVendorDetail> findAll) {
        if ( findAll == null ) {
            return null;
        }

        List<EOVendor> list = new ArrayList<EOVendor>( findAll.size() );
        for ( UIVendorDetail uIVendorDetail : findAll ) {
            list.add( mapToDAO( uIVendorDetail ) );
        }

        return list;
    }

    @Override
    public List<UIVendorDetail> mapToDTO(List<EOVendor> eoRoleDTO) {
        if ( eoRoleDTO == null ) {
            return null;
        }

        List<UIVendorDetail> list = new ArrayList<UIVendorDetail>( eoRoleDTO.size() );
        for ( EOVendor eOVendor : eoRoleDTO ) {
            list.add( mapToDTO( eOVendor ) );
        }

        return list;
    }
}
