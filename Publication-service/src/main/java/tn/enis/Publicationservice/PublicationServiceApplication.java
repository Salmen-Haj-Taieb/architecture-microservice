package tn.enis.Publicationservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tn.enis.Publicationservice.dao.PublicationRepository;
import tn.enis.Publicationservice.entities.Publication;

import java.util.Date;

@SpringBootApplication
@AllArgsConstructor
@EnableDiscoveryClient
public class PublicationServiceApplication {
    PublicationRepository publicationRepository;
	public static void main(String[] args) {
		SpringApplication.run(PublicationServiceApplication.class, args);
	}

}
