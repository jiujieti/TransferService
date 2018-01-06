package com.mengqi.transfer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * This main entry of the spring appliction.
 *
 * @author Mengqi Yang
 */
@SpringBootApplication
@EntityScan( basePackages = {"com.mengqi.transfer.models"} )
public class TransferApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransferApplication.class, args);
	}
}
