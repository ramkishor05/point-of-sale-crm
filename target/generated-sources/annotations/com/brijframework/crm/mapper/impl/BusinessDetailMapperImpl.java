package com.brijframework.crm.mapper.impl;

import com.brijframework.crm.dto.UIBusinessDetail;
import com.brijframework.crm.entities.EOBusiness;
import com.brijframework.crm.mapper.BusinessDetailMapper;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-11T13:44:11+0530",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
@Component
public class BusinessDetailMapperImpl implements BusinessDetailMapper {

    @Override
    public UIBusinessDetail mapToDTO(EOBusiness eoRole) {
        if ( eoRole == null ) {
            return null;
        }

        UIBusinessDetail uIBusinessDetail = new UIBusinessDetail();

        return uIBusinessDetail;
    }

    @Override
    public EOBusiness mapToDAO(UIBusinessDetail eoRoleDTO) {
        if ( eoRoleDTO == null ) {
            return null;
        }

        EOBusiness eOBusiness = new EOBusiness();

        return eOBusiness;
    }

    @Override
    public List<EOBusiness> mapToDAO(List<UIBusinessDetail> findAll) {
        if ( findAll == null ) {
            return null;
        }

        List<EOBusiness> list = new ArrayList<EOBusiness>( findAll.size() );
        for ( UIBusinessDetail uIBusinessDetail : findAll ) {
            list.add( mapToDAO( uIBusinessDetail ) );
        }

        return list;
    }

    @Override
    public List<UIBusinessDetail> mapToDTO(List<EOBusiness> eoRoleDTO) {
        if ( eoRoleDTO == null ) {
            return null;
        }

        List<UIBusinessDetail> list = new ArrayList<UIBusinessDetail>( eoRoleDTO.size() );
        for ( EOBusiness eOBusiness : eoRoleDTO ) {
            list.add( mapToDTO( eOBusiness ) );
        }

        return list;
    }
}
