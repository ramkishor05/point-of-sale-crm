package com.brijframework.crm.mapper.impl;

import com.brijframework.crm.dto.UIVendor;
import com.brijframework.crm.entities.EOVendor;
import com.brijframework.crm.mapper.VendorMapper;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-31T19:36:08+0530",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
@Component
public class VendorMapperImpl implements VendorMapper {

    @Override
    public UIVendor mapToDTO(EOVendor eoRole) {
        if ( eoRole == null ) {
            return null;
        }

        UIVendor uIVendor = new UIVendor();

        if ( eoRole.getId() != null ) {
            uIVendor.setId( eoRole.getId() );
        }
        uIVendor.setAccountId( eoRole.getAccountId() );
        uIVendor.setName( eoRole.getName() );
        uIVendor.setPhoneNumber( eoRole.getPhoneNumber() );
        uIVendor.setMobileNumber( eoRole.getMobileNumber() );
        uIVendor.setEmailAddress( eoRole.getEmailAddress() );
        uIVendor.setPermamentAddress( eoRole.getPermamentAddress() );
        uIVendor.setPresentAddress( eoRole.getPresentAddress() );

        return uIVendor;
    }

    @Override
    public EOVendor mapToDAO(UIVendor eoRoleDTO) {
        if ( eoRoleDTO == null ) {
            return null;
        }

        EOVendor eOVendor = new EOVendor();

        eOVendor.setId( eoRoleDTO.getId() );
        eOVendor.setAccountId( eoRoleDTO.getAccountId() );
        eOVendor.setName( eoRoleDTO.getName() );
        eOVendor.setPhoneNumber( eoRoleDTO.getPhoneNumber() );
        eOVendor.setMobileNumber( eoRoleDTO.getMobileNumber() );
        eOVendor.setEmailAddress( eoRoleDTO.getEmailAddress() );
        eOVendor.setPermamentAddress( eoRoleDTO.getPermamentAddress() );
        eOVendor.setPresentAddress( eoRoleDTO.getPresentAddress() );

        return eOVendor;
    }

    @Override
    public List<EOVendor> mapToDAO(List<UIVendor> findAll) {
        if ( findAll == null ) {
            return null;
        }

        List<EOVendor> list = new ArrayList<EOVendor>( findAll.size() );
        for ( UIVendor uIVendor : findAll ) {
            list.add( mapToDAO( uIVendor ) );
        }

        return list;
    }

    @Override
    public List<UIVendor> mapToDTO(List<EOVendor> eoRoleDTO) {
        if ( eoRoleDTO == null ) {
            return null;
        }

        List<UIVendor> list = new ArrayList<UIVendor>( eoRoleDTO.size() );
        for ( EOVendor eOVendor : eoRoleDTO ) {
            list.add( mapToDTO( eOVendor ) );
        }

        return list;
    }
}
