package br.com.viniciusdiefenbach.alura.screenmatch;

import br.com.viniciusdiefenbach.alura.screenmatch.models.EpisodesData;
import br.com.viniciusdiefenbach.alura.screenmatch.models.SeriesData;
import br.com.viniciusdiefenbach.alura.screenmatch.services.ApiConsume;
import br.com.viniciusdiefenbach.alura.screenmatch.services.DataConversion;
import br.com.viniciusdiefenbach.alura.screenmatch.services.IDataConversion;
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
		var json = apiConsume.getData("https://www.omdbapi.com/?t=gilmore+girls&apikey=450a57a0");
		IDataConversion dataConversion = new DataConversion();
		SeriesData seriesData = dataConversion.getData(json, SeriesData.class);
		System.out.println(seriesData);

		json = apiConsume.getData("https://www.omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=450a57a0");
		EpisodesData episodesData = dataConversion.getData(json, EpisodesData.class);
		System.out.println(episodesData);
	}
}
