package com.microservice.account;

import com.microservice.account.dto.AccountsContactInfoDto;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
/*@ComponentScan({@ComponentScan("com.microservice.external.controller")})
@EnableJpaRepositories("com.microservice.external.repository")
@EntityScan("com.microservice.external.entities")*/
@EnableConfigurationProperties(value = {AccountsContactInfoDto.class})
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Accounts microservice Rest Api Documentation",
				description = "Bank Accounts Microservices REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Hrishikesh",
						email = "hrishikesh@gmail.com"
				)

		)
)
public class AccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

}
