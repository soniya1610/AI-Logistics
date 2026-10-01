package com.soniya.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soniya.entity.Customer;
import com.soniya.entity.Driver;

@Repository
public interface DriverRepo extends JpaRepository<Driver, String>{

	List<Driver> findAllByStatus(String status);

}
