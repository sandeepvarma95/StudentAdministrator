package com.student.admin;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = "jaxx123";
		String encodedPassword = encoder.encode(rawPassword);
		
		System.out.println(encodedPassword);
	}
}
