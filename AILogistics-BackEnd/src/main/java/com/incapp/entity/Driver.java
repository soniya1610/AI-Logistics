package com.incapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Driver {
	@Id
	private String email;
	private String name;
	private String phone;
	private String vehicle_type;
	private String vehicle_rc_no;
	@Column(nullable = false, columnDefinition = "longblob")
	private byte[] vehicle_rc;
	private String driving_license_no;
	@Column(nullable = false, columnDefinition = "longblob")
	private byte[] driving_license;
	private String password;
	private String status="Pending";
}
