package com.luiz.pismo;

import com.luiz.pismo.model.OperationType;
import com.luiz.pismo.repository.OperationTypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PismoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PismoApplication.class, args);
	}


	@Bean
	public CommandLineRunner demoPlayer(OperationTypeRepository typeRepository) {
		return (args) -> {
			typeRepository.save(new OperationType(1, "COMPRA A VISTA", true));
			typeRepository.save(new OperationType(2, "COMPRA PARCELADA", true));
			typeRepository.save(new OperationType(3, "SAQUE", true));
			typeRepository.save(new OperationType(4, "PAGAMENTO", false));
		};
	}

}
