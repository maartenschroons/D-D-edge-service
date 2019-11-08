package be.thomasmore.DungeonsAndDragonsedgeservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@SpringBootApplication
public class DungeonsAndDragonsEdgeServiceApplication {

	private static Logger log = LoggerFactory.getLogger(DungeonsAndDragonsEdgeServiceApplication.class);

	@Bean
	public RestTemplate getRestTemplate() { return new RestTemplate();}

	@Bean
	public ObjectMapper getObjectMapper() {return  new ObjectMapper();}

	public static void main(String[] args) {
		SpringApplication.run(DungeonsAndDragonsEdgeServiceApplication.class, args);
	}

	@RequestMapping(value = "/")
	public String home() {
		log.info("Access /");
		return "Hi!";
	}
}
