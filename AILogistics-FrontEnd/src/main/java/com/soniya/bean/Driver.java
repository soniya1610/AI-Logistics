package com.soniya.bean;

import lombok.Data;

@Data
public class Driver {
	private String email;
	private String name;
	private String phone;
	private String vehicle_type;
	private String vehicle_rc_no;
	private byte[] vehicle_rc;
	private String driving_license_no;
	private byte[] driving_license;
	private String password;
	private String status="Pending";
}
