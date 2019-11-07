package com.itriad.parkinglot;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.itriad.parkinglot.domain.RegistroVeiculo;
import com.itriad.parkinglot.domain.Veiculo;
import com.itriad.parkinglot.repositories.RegistroVeiculoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ParkingLotApplication {
	@Autowired
	RegistroVeiculoRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ParkingLotApplication.class, args);
	}

	@Bean
	public CommandLineRunner inicializarDados() {
		return (args) -> {
			Random generator = new Random();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			for (int i = 10; i < 31; i++) {
				int carrosDia = generator.nextInt(6);
				for (int j = 0; j < carrosDia; j++) {
					Date data = sdf.parse(String.format("%d/10/2019", i));
					RegistroVeiculo registro = new RegistroVeiculo(null, new Veiculo(null, "ABC1234", "Siena", "Preto"),
					data, data, Double.valueOf(generator.nextInt(30)));
					repository.save(registro);
				}
			}
		};
	}

}
