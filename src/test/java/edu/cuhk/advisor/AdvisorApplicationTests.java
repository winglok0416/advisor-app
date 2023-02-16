package edu.cuhk.advisor;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = { "ninja.api-key=test" })
class AdvisorApplicationTests {

	@Test
	void contextLoads() {
	}

}
