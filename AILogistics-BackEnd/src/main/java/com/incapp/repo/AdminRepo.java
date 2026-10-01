package com.incapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.incapp.entity.Admin;
import com.incapp.entity.Customer;
import com.incapp.entity.Driver;

@Repository
public interface AdminRepo extends JpaRepository<Admin, String>{

}
