package com.soniya.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soniya.entity.Admin;
import com.soniya.entity.Customer;
import com.soniya.entity.Driver;

@Repository
public interface AdminRepo extends JpaRepository<Admin, String>{

}
