package it.objectmethod.generaXml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class GeneraXmlApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeneraXmlApplication.class, args);
	}

}
