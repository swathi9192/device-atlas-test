package com.deviceAtlas.TechnicalTest;

import com.deviceAtlas.TechnicalTest.entity.User;
import com.deviceAtlas.TechnicalTest.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories(basePackages = {"com.deviceAtlas.TechnicalTest.repository"})
public class TechnicalTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechnicalTestApplication.class, args);

	}
	// Load neo4j with initial data when spring context loads
	@Bean
	CommandLineRunner demo(UserRepository userRepository) {
		return args -> {
			userRepository.deleteAll();
			User alice = new User("Alice","Dublin");
			User bob = new User("Bob","Dublin");
			User charlie = new User("Charlie","London");
			User davina = new User("Davina","Belfast");
			User john = new User("John","Galway");
			userRepository.save(alice);
			userRepository.save(bob);
			userRepository.save(charlie);
			userRepository.save(davina);
			userRepository.save(john);
			alice = userRepository.findByName(alice.getName());
			alice.friendOf(charlie);
			userRepository.save(alice);
			bob = userRepository.findByName(bob.getName());
			bob.friendOf(charlie);
			bob.friendOf(davina);
			bob.friendOf(john);
			userRepository.save(bob);
			charlie = userRepository.findByName(charlie.getName());

			charlie.friendOf(john);
			userRepository.save(charlie);
			davina = userRepository.findByName(davina.getName());

			davina.friendOf(john);
			userRepository.save(davina);
		};
	}
}
