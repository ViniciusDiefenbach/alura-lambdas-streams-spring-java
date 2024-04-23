package br.com.viniciusdiefenbach.alura.screenmatch.main;

import br.com.viniciusdiefenbach.alura.screenmatch.models.SeasonsData;
import br.com.viniciusdiefenbach.alura.screenmatch.models.SeriesData;
import br.com.viniciusdiefenbach.alura.screenmatch.services.ApiConsume;
import br.com.viniciusdiefenbach.alura.screenmatch.services.DataConversion;
import br.com.viniciusdiefenbach.alura.screenmatch.services.IDataConversion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final Scanner input = new Scanner(System.in);
    private final ApiConsume apiConsume = new ApiConsume();
    private final IDataConversion dataConversion = new DataConversion();
    private static final String URL_ADDRESS = "https://www.omdbapi.com/?t=";
    private static final String API_KEY = "&apikey=450a57a0";


    public void showMenu() {
        System.out.println("Digite o nome da série:");
        var serieName = input.nextLine();
        var serieAddress = URL_ADDRESS + serieName.replace(" ", "+");
        var json = apiConsume.getData(serieAddress + API_KEY);
        SeriesData seriesData = dataConversion.getData(json, SeriesData.class);
        System.out.println(seriesData);

        List<SeasonsData> seasonsDataList = new ArrayList<>();
        for (int i = 1; i <= seriesData.totalSeasons(); i++) {
            json = apiConsume.getData(serieAddress + "&season=" + i + API_KEY);
            SeasonsData seasonsData = dataConversion.getData(json, SeasonsData.class);
            seasonsDataList.add(seasonsData);
        }
        seasonsDataList.forEach(System.out::println);
    }
}
