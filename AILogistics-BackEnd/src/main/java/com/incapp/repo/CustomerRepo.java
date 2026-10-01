package com.incapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.incapp.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, String>{

}
