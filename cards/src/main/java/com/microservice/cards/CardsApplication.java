package com.microservice.cards;

import com.microservice.cards.dto.CardsContactInfoDto;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableConfigurationProperties(value = {CardsContactInfoDto.class})
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Cards Microservice Rest API Documentation",
				description = "Bank Card Microservice Rest API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Hrishikesh Shedge",
						email = "hrishikeshshedge@gmail.com"
				)
		)
)
public class CardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsApplication.class, args);
	}

}
