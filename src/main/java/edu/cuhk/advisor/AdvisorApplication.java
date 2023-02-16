package edu.cuhk.advisor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.r2dbc.R2dbcDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.r2dbc.R2dbcRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcTransactionManagerAutoConfiguration;

@SpringBootApplication(exclude = {
		R2dbcAutoConfiguration.class,
		R2dbcDataAutoConfiguration.class,
		R2dbcRepositoriesAutoConfiguration.class,
		R2dbcTransactionManagerAutoConfiguration.class
})
public class AdvisorApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvisorApplication.class, args);
	}

}
