package com.brijframework.crm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brijframework.crm.entities.EOSupplier;

@Repository
@Transactional
public interface SupplierRepository extends JpaRepository<EOSupplier, Long>{

	List<EOSupplier> findByVendorId(Long vendorId);

}
