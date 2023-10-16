package com.brijframework.crm.mapper.impl;

import com.brijframework.crm.dto.UICustomer;
import com.brijframework.crm.entities.EOCustomer;
import com.brijframework.crm.mapper.CustomerMapper;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-14T09:22:11+0530",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.19 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public UICustomer mapToDTO(EOCustomer eoRole) {
        if ( eoRole == null ) {
            return null;
        }

        UICustomer uICustomer = new UICustomer();

        if ( eoRole.getId() != null ) {
            uICustomer.setId( eoRole.getId() );
        }
        uICustomer.setName( eoRole.getName() );
        uICustomer.setPhoneNumber( eoRole.getPhoneNumber() );
        uICustomer.setMobileNumber( eoRole.getMobileNumber() );
        uICustomer.setEmailAddress( eoRole.getEmailAddress() );
        uICustomer.setPermamentAddress( eoRole.getPermamentAddress() );
        uICustomer.setPresentAddress( eoRole.getPresentAddress() );

        return uICustomer;
    }

    @Override
    public EOCustomer mapToDAO(UICustomer eoRoleDTO) {
        if ( eoRoleDTO == null ) {
            return null;
        }

        EOCustomer eOCustomer = new EOCustomer();

        eOCustomer.setId( eoRoleDTO.getId() );
        eOCustomer.setName( eoRoleDTO.getName() );
        eOCustomer.setPhoneNumber( eoRoleDTO.getPhoneNumber() );
        eOCustomer.setMobileNumber( eoRoleDTO.getMobileNumber() );
        eOCustomer.setEmailAddress( eoRoleDTO.getEmailAddress() );
        eOCustomer.setPermamentAddress( eoRoleDTO.getPermamentAddress() );
        eOCustomer.setPresentAddress( eoRoleDTO.getPresentAddress() );

        return eOCustomer;
    }

    @Override
    public List<EOCustomer> mapToDAO(List<UICustomer> findAll) {
        if ( findAll == null ) {
            return null;
        }

        List<EOCustomer> list = new ArrayList<EOCustomer>( findAll.size() );
        for ( UICustomer uICustomer : findAll ) {
            list.add( mapToDAO( uICustomer ) );
        }

        return list;
    }

    @Override
    public List<UICustomer> mapToDTO(List<EOCustomer> eoRoleDTO) {
        if ( eoRoleDTO == null ) {
            return null;
        }

        List<UICustomer> list = new ArrayList<UICustomer>( eoRoleDTO.size() );
        for ( EOCustomer eOCustomer : eoRoleDTO ) {
            list.add( mapToDTO( eOCustomer ) );
        }

        return list;
    }
}
