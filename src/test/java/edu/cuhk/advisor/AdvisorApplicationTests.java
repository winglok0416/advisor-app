package edu.cuhk.advisor;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
		"ninja.api-key=test",
		"spoonacular.api-key=test",
		"spring.security.user.name=advisor",
		"spring.security.user.password=1234"
})
class AdvisorApplicationTests {

	@Test
	void contextLoads() {
	}

}
