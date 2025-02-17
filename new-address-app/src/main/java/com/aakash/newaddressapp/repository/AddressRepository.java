package com.aakash.newaddressapp.repository;


import com.aakash.newaddressapp.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {

    @Query(nativeQuery = true,value = "select id,lane1,lane2,state,zip from address where employee_id=:employeeId")
    Address findBuEmployeeId(@Param("employeeId") int employeeId);


}
