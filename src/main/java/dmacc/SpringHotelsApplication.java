package dmacc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import dmacc.beans.Address;
import dmacc.beans.Hotel;
import dmacc.controller.BeanConfiguration;
import dmacc.repository.HotelRepository;

@SpringBootApplication
public class SpringHotelsApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringHotelsApplication.class, args);
		
		/*
		 * ApplicationContext appContext = new
		 * AnnotationConfigApplicationContext(BeanConfiguration.class);
		 * 
		 * Hotel c = appContext.getBean("contact", Hotel.class);
		 * 
		 * System.out.println(c.toString());
		 */
	}
	
	@Autowired
	HotelRepository repo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		
		//Using an existing bean
		Hotel c = appContext.getBean("contact", Hotel.class);
		repo.save(c);
		
		//Create a bean to use - not managed by Spring
		Hotel d = new Hotel("Holiday Inn", "hot tub");
		Address a = new Address("987 Elm Court", "Altoona", "IA");
		d.setAddress(a);
		repo.save(d);
		
		List<Hotel> allMyHotels = repo.findAll();
		for(Hotel people: allMyHotels) {
			System.out.println(people.toString());
		}
		
		//closes the ApplicationContext resource leak - not imperative to add but nice to clean it up
		((AbstractApplicationContext) appContext).close();
	
	}

}
