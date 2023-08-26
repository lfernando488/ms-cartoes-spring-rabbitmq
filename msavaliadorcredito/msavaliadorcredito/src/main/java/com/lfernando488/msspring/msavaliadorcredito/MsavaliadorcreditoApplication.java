package com.lfernando488.msspring.msavaliadorcredito;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@EnableEurekaClient
@EnableFeignClients
@EnableRabbit
public class MsavaliadorcreditoApplication {

	public static void main(String[] args) {

		SpringApplication.run(MsavaliadorcreditoApplication.class, args);
	}

}
