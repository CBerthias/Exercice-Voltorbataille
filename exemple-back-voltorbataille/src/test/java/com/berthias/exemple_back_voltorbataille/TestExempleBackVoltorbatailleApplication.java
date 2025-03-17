package com.berthias.exemple_back_voltorbataille;

import org.springframework.boot.SpringApplication;

public class TestExempleBackVoltorbatailleApplication {

	public static void main(String[] args) {
		SpringApplication.from(ExempleBackVoltorbatailleApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
