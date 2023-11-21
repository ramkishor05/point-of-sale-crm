package com.brijframework.crm.mapper.impl;

import com.brijframework.crm.dto.UICustomerDetail;
import com.brijframework.crm.entities.EOCustomer;
import com.brijframework.crm.mapper.CustomerDetailMapper;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-20T22:25:37+0530",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.19 (Oracle Corporation)"
)
@Component
public class CustomerDetailMapperImpl implements CustomerDetailMapper {

    @Override
    public UICustomerDetail mapToDTO(EOCustomer eoRole) {
        if ( eoRole == null ) {
            return null;
        }

        UICustomerDetail uICustomerDetail = new UICustomerDetail();

        if ( eoRole.getId() != null ) {
            uICustomerDetail.setId( eoRole.getId() );
        }
        uICustomerDetail.setName( eoRole.getName() );
        uICustomerDetail.setAccountId( eoRole.getAccountId() );
        uICustomerDetail.setPhoneNumber( eoRole.getPhoneNumber() );
        uICustomerDetail.setMobileNumber( eoRole.getMobileNumber() );
        uICustomerDetail.setEmailAddress( eoRole.getEmailAddress() );
        uICustomerDetail.setPermamentAddress( eoRole.getPermamentAddress() );
        uICustomerDetail.setPresentAddress( eoRole.getPresentAddress() );

        return uICustomerDetail;
    }

    @Override
    public EOCustomer mapToDAO(UICustomerDetail eoRoleDTO) {
        if ( eoRoleDTO == null ) {
            return null;
        }

        EOCustomer eOCustomer = new EOCustomer();

        eOCustomer.setId( eoRoleDTO.getId() );
        eOCustomer.setAccountId( eoRoleDTO.getAccountId() );
        eOCustomer.setName( eoRoleDTO.getName() );
        eOCustomer.setPhoneNumber( eoRoleDTO.getPhoneNumber() );
        eOCustomer.setMobileNumber( eoRoleDTO.getMobileNumber() );
        eOCustomer.setEmailAddress( eoRoleDTO.getEmailAddress() );
        eOCustomer.setPermamentAddress( eoRoleDTO.getPermamentAddress() );
        eOCustomer.setPresentAddress( eoRoleDTO.getPresentAddress() );

        return eOCustomer;
    }

    @Override
    public List<EOCustomer> mapToDAO(List<UICustomerDetail> findAll) {
        if ( findAll == null ) {
            return null;
        }

        List<EOCustomer> list = new ArrayList<EOCustomer>( findAll.size() );
        for ( UICustomerDetail uICustomerDetail : findAll ) {
            list.add( mapToDAO( uICustomerDetail ) );
        }

        return list;
    }

    @Override
    public List<UICustomerDetail> mapToDTO(List<EOCustomer> eoRoleDTO) {
        if ( eoRoleDTO == null ) {
            return null;
        }

        List<UICustomerDetail> list = new ArrayList<UICustomerDetail>( eoRoleDTO.size() );
        for ( EOCustomer eOCustomer : eoRoleDTO ) {
            list.add( mapToDTO( eOCustomer ) );
        }

        return list;
    }
}
