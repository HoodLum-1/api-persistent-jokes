package za.co.sithole.fun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PersistentJokesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersistentJokesApplication.class, args);
	}

}
