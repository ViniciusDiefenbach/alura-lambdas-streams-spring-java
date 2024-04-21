package br.com.viniciusdiefenbach.alura.screenmatch;

import br.com.viniciusdiefenbach.alura.screenmatch.services.ApiConsume;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var apiConsume = new ApiConsume();
		var json = apiConsume.getData("https://www.omdbapi.com/?t=gilmore+girls&Season=1&apikey=450a57a0");
		System.out.println(json);
		json = apiConsume.getData("https://coffee.alexflipnote.dev/random.json");
		System.out.println(json);
	}
}
