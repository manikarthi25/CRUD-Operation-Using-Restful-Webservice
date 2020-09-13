package com.manikarthi25.restfullservice.demo.helper;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class Utils {

	public String generateEmpId() {
		return UUID.randomUUID().toString();
	}

}
