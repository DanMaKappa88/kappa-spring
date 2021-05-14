package hu.flowacademy.kappaspring;

import hu.flowacademy.kappaspring.firststeps.Component2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// A CommandLineRunner általában nem szükséges
public class KappaspringApplication implements CommandLineRunner {

	@Autowired
	// ha van ilyen objektum "felre rakva"
	// akkor add ide nekem
	private Component2 component2;

	public static void main(String[] args) {
		SpringApplication.run(KappaspringApplication.class, args);
	}

	@Override
	// Lefut az app indulásakor, csak szemléltetés céljából hoztam létre
	public void run(String... args) throws Exception {
		System.out.println(component2.getName());
		System.out.println("");
		System.out.println(component2.getOtherOneName());
	}
}
