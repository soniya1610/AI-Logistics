package com.incapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.incapp.entity.Admin;
import com.incapp.repo.AdminRepo;

@Component
public class DataInitializer implements CommandLineRunner {

    @Value("${admin.email}")
    private String email;

    @Value("${admin.password}")
    private String password;
    
    @Value("${admin.name}")
    private String name;
    
    @Autowired
    private AdminRepo adminRepo;
    

    @Override
    public void run(String... args) throws Exception {
    	if(adminRepo.findById(email).orElse(null)==null) {
    		Admin a=new Admin();
	    	a.setName(name);
	    	BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder();
	    	a.setPassword(bcrypt.encode(password));
	    	a.setEmail(email);
	    	adminRepo.save(a);
    	}
    }
}