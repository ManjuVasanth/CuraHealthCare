package com.curahealthcare.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties properties;
	
	public ReadConfig() {
		// ./-> project home directory
		File file =new File("./Configuration/config.properties");
		try {
			FileInputStream inputStream = new FileInputStream(file);
			properties = new Properties();
			properties.load(inputStream);
		} catch (Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
	}
	public String getApplicationUrl() {
		String url = properties.getProperty("baseUrl");
		return url;
	}
	public String getUsername() {
		String username = properties.getProperty("username");
		return username;
		
	}
	public String password() {
		String password = properties.getProperty("password");
		return password;
		
	}
	
	public String getFacilityName() {
		String facilityName = properties.getProperty("facilityname");
		return facilityName;
		
	}
	
	public String getVisitDate() {
		String visitDate = properties.getProperty("visitdate");
		return visitDate;
	}

}
