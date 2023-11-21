package com.brijframework.crm.repository;

import static com.brijframework.crm.contants.Constants.EOSUPPLIER;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brijframework.crm.entities.EOSupplier;

@Repository
@Transactional
public interface SupplierRepository extends JpaRepository<EOSupplier, Long>{

	@Query(nativeQuery = true , value = " SELECT * FROM "+EOSUPPLIER+" WHERE CUST_BUSINESS_APP_ID=?1")
	List<EOSupplier> findByCustAppId(Long custAppId);

}
