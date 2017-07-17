package br.ufc.treinamento;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoTreinamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoTreinamentoApplication.class, args);
		System.out.println("Ola Mundo");
	}
}
