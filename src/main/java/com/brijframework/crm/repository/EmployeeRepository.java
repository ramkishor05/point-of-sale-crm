package com.brijframework.crm.repository;

import static com.brijframework.crm.contants.Constants.EOEMPLOYEE;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brijframework.crm.entities.EOEmployee;

@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<EOEmployee, Long>{

	@Query(nativeQuery = true , value = " SELECT * FROM "+EOEMPLOYEE+" WHERE VENDOR_ID=?1")
	Optional<List<EOEmployee>> findByVendorId(Long vendorId);

}
