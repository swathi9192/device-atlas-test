package com.deviceAtlas.TechnicalTest;

import com.deviceAtlas.TechnicalTest.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
@AutoConfigureMockMvc
class TechnicalTestApplicationTests {

	@Autowired
	private UserController userController;

	@Test
	void contextLoads() throws Exception {
		assertThat(userController).isNotNull();
	}

}
