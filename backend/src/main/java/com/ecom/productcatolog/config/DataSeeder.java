package com.ecom.productcatolog.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ecom.productcatolog.model.Category;
import com.ecom.productcatolog.model.Product;
import com.ecom.productcatolog.repository.CategoryRepository;
import com.ecom.productcatolog.repository.ProductRepository;

@Component
public class DataSeeder implements CommandLineRunner {
	
	

	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	
	public DataSeeder(ProductRepository productRepository, CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
	this.categoryRepository = categoryRepository;
}
	
	
	@Override
	public void run(String ... args) throws Exception {
		
		productRepository . deleteAll() ;
		categoryRepository . deleteAll() ;
		// Create Categories
		Category electronics = new Category () ;
		electronics. setName ("Electronic") ;
		
		Category clothing  = new Category () ;
		clothing. setName ("Clothing") ;
		
		Category home = new Category () ;
		home. setName ("Home and Kitchen") ;
		
		Category vehicles = new Category () ;
		home. setName ("Vehicles") ;
		
		categoryRepository.saveAll(Arrays.asList(electronics, home, clothing, vehicles));
		
		// Create Products
		Product phone = new Product () ;
		phone . setName ( "SmartPhone" ) ;
		phone . setDescription( "Latest model smartphone with amazing features") ;
		phone. setImageUrl("https://placehold.co/600x400") ;
		phone. setPrice (699.99) ;
		phone . setCategory (electronics) ;
		
		
		Product laptop = new Product () ;
		laptop.setName ( "Laptop" ) ;
		laptop.setDescription( "High performance laptop") ;
		laptop.setImageUrl("https://placehold.co/600x400") ;
		laptop.setPrice (800.99) ;
		laptop.setCategory (electronics) ;
		
		Product jacket = new Product () ;
		jacket . setName ( "Jacket" ) ;
		jacket. setDescription( "Warm and cozy jacket for winter") ;
		jacket. setImageUrl("https://placehold.co/600x400") ;
		jacket. setPrice (100.99) ;
		jacket. setCategory (clothing) ;
		
		Product blender = new Product () ;
		blender . setName ( "Blender" ) ;
		blender . setDescription( "Latest model smartphone with amazing features") ;
		blender. setImageUrl("https://placehold.co/600x400") ;
		blender. setPrice (95.99) ;
		blender. setCategory (home) ;
		
		Product shoes = new Product () ;
		shoes . setName ( "Shoes" ) ;
		shoes . setDescription( "Step into style and comfort with our premium shoes, crafted for durability and elegance") ;
		shoes. setImageUrl("https://placehold.co/600x400") ;
		shoes. setPrice (100.99) ;
		shoes. setCategory (clothing) ;
		
		Product bikes = new Product () ;
		bikes . setName ( "Bikes" ) ;
		bikes . setDescription( "A powerful and stylish motorbike with a dynamic design built for speed and adventure.") ;
		bikes. setImageUrl("https://placehold.co/600x400") ;
		bikes. setPrice (999.99) ;
		bikes. setCategory (vehicles) ;
		
		Product cars = new Product () ;
		cars . setName ( "Cars" ) ;
		cars . setDescription( "A sleek and modern luxury car with an aerodynamic design, glossy paint, and futuristic LED headlights, built for speed and elegance.") ;
		cars. setImageUrl("https://placehold.co/600x400") ;
		cars. setPrice (12000.99) ;
		cars. setCategory (vehicles);
		
		productRepository.saveAll(Arrays.asList(phone, laptop, jacket, blender, shoes, bikes, cars));
	
	}
}