package com.example.restapi;

//import com.example.restapi.model.Product;
//import com.example.restapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
public class RestapiApplication extends SpringBootServletInitializer implements CommandLineRunner {

	//private ProductRepository productRepository;
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(RestapiApplication.class);
    }
//	@Autowired
//	public void productRepository(ProductRepository productRepository) {
//		//this.productRepository = productRepository;
//	}

	public static void main(String[] args) {
		SpringApplication.run(RestapiApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

//		Product testProduct = new Product();
//		testProduct.setName("Simple Product");
//		testProduct.setDescription("This is a tester product");
//		testProduct.setType("CUSTOM");
//		testProduct.setCategory("SPECIAL");
//
//		productRepository.save(testProduct);

	}
}
