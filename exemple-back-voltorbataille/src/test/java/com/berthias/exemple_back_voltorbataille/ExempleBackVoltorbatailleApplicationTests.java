package com.berthias.exemple_back_voltorbataille;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class ExempleBackVoltorbatailleApplicationTests {

	@Test
	void contextLoads() {
	}

}
