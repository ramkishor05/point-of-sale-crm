package com.brijframework.crm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brijframework.crm.entities.EOCustomer;

@Repository
@Transactional
public interface CustomerRepository extends JpaRepository<EOCustomer, Long>{

	@Query(nativeQuery = true , value = " SELECT * FROM EOCUSTOMER WHERE VENDOR_ID=?1 AND RECORD_STATUS=1 ")
	Optional<List<EOCustomer>> findByVendorId(Long vendorId);

}
