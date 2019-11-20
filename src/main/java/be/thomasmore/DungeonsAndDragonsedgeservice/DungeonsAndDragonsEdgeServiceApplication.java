package be.thomasmore.DungeonsAndDragonsedgeservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@SpringBootApplication
public class DungeonsAndDragonsEdgeServiceApplication {


	public static void main(String[] args) {
		SpringApplication.run(DungeonsAndDragonsEdgeServiceApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	@Bean
	public ObjectMapper getObjectMapper() { return new ObjectMapper();
	}

}
