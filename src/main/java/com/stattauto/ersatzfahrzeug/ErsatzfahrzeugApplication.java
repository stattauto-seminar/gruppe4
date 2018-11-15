package com.stattauto.ersatzfahrzeug;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.stattauto.ersatzfahrzeug.entity.Fahrzeug;
import com.stattauto.ersatzfahrzeug.repository.FahrzeugRepository;

@EnableDiscoveryClient
@SpringBootApplication
@EnableJpaRepositories
public class ErsatzfahrzeugApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErsatzfahrzeugApplication.class, args);
	}

	@Bean
	CommandLineRunner init(FahrzeugRepository fahrzeugRepository) {
		return args -> {
			fahrzeugRepository.save(new Fahrzeug(null, "WES JD 860","1235-3432-23434"));
			fahrzeugRepository.save(new Fahrzeug(null,"WES JK 460","3455-3454-56776"));
			fahrzeugRepository.save(new Fahrzeug(null,"RE IV 660","9688-67867-5433"));
			fahrzeugRepository.save(new Fahrzeug(null,"E OP 888","34435-34243-2345"));
			fahrzeugRepository.save(new Fahrzeug(null,"test","34435-34243-2345"));
		};
	}

}
