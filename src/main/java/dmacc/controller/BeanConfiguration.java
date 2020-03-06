package dmacc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.Address;
import dmacc.beans.Hotel;

@Configuration
public class BeanConfiguration {
	
	@Bean
	public Hotel contact() {
		Hotel bean = new Hotel("Ramada Inn");
		return bean;
	}

	@Bean
	public Address address() {
		Address bean = new Address("117 2nd St","Ankeny","IA");
		return bean;
	}
}
