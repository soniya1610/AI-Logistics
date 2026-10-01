package com.incapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.incapp.entity.Customer;
import com.incapp.entity.Driver;

@Repository
public interface DriverRepo extends JpaRepository<Driver, String>{

	List<Driver> findAllByStatus(String status);

}
