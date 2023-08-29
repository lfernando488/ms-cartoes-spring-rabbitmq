package com.lfernando488.msspring.mscartoes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableEurekaclient
@EnableRabbit
@Slf4j
public class MscartoesApplication {

	public static void main(String[] args) {

		log.info("Informação: {}", "Microserviço de cartoes iniciado!");
		log.error("Informação: {}", "Microserviço com erro!");
		log.warn("Informação: {}", "Microserviço de cartoes com alerta!");
		SpringApplication.run(MscartoesApplication.class, args);
	}

}
