package com.brijframework.crm.mapper.impl;

import com.brijframework.crm.dto.UIBusiness;
import com.brijframework.crm.entities.EOBusiness;
import com.brijframework.crm.mapper.BusinessMapper;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-31T22:11:45+0530",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.19 (Oracle Corporation)"
)
@Component
public class BusinessMapperImpl implements BusinessMapper {

    @Override
    public UIBusiness mapToDTO(EOBusiness eoRole) {
        if ( eoRole == null ) {
            return null;
        }

        UIBusiness uIBusiness = new UIBusiness();

        if ( eoRole.getId() != null ) {
            uIBusiness.setId( eoRole.getId() );
        }
        uIBusiness.setName( eoRole.getName() );
        uIBusiness.setPhoneNumber( eoRole.getPhoneNumber() );
        uIBusiness.setMobileNumber( eoRole.getMobileNumber() );
        uIBusiness.setEmailAddress( eoRole.getEmailAddress() );
        uIBusiness.setPermamentAddress( eoRole.getPermamentAddress() );
        uIBusiness.setPresentAddress( eoRole.getPresentAddress() );

        return uIBusiness;
    }

    @Override
    public EOBusiness mapToDAO(UIBusiness eoRoleDTO) {
        if ( eoRoleDTO == null ) {
            return null;
        }

        EOBusiness eOBusiness = new EOBusiness();

        eOBusiness.setId( eoRoleDTO.getId() );
        eOBusiness.setName( eoRoleDTO.getName() );
        eOBusiness.setPhoneNumber( eoRoleDTO.getPhoneNumber() );
        eOBusiness.setMobileNumber( eoRoleDTO.getMobileNumber() );
        eOBusiness.setEmailAddress( eoRoleDTO.getEmailAddress() );
        eOBusiness.setPermamentAddress( eoRoleDTO.getPermamentAddress() );
        eOBusiness.setPresentAddress( eoRoleDTO.getPresentAddress() );

        return eOBusiness;
    }

    @Override
    public List<EOBusiness> mapToDAO(List<UIBusiness> findAll) {
        if ( findAll == null ) {
            return null;
        }

        List<EOBusiness> list = new ArrayList<EOBusiness>( findAll.size() );
        for ( UIBusiness uIBusiness : findAll ) {
            list.add( mapToDAO( uIBusiness ) );
        }

        return list;
    }

    @Override
    public List<UIBusiness> mapToDTO(List<EOBusiness> eoRoleDTO) {
        if ( eoRoleDTO == null ) {
            return null;
        }

        List<UIBusiness> list = new ArrayList<UIBusiness>( eoRoleDTO.size() );
        for ( EOBusiness eOBusiness : eoRoleDTO ) {
            list.add( mapToDTO( eOBusiness ) );
        }

        return list;
    }
}
