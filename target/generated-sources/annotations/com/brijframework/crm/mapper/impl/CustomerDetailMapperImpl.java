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
    date = "2023-10-30T01:15:40+0530",
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

        return uICustomerDetail;
    }

    @Override
    public EOCustomer mapToDAO(UICustomerDetail eoRoleDTO) {
        if ( eoRoleDTO == null ) {
            return null;
        }

        EOCustomer eOCustomer = new EOCustomer();

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
