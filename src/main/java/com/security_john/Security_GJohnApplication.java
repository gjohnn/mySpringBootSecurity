package com.security_john;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Security_GJohnApplication {

	private static final Logger logger = LoggerFactory.getLogger(Security_GJohnApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(Security_GJohnApplication.class, args);
		logger.info(" --------------- Application started successfully  --------------- ");
	}
}
