package br.com.viniciusdiefenbach.alura.screenmatch.main;

import br.com.viniciusdiefenbach.alura.screenmatch.services.ApiConsume;

import java.util.Scanner;

public class Main {
    private final Scanner input = new Scanner(System.in);
    private final ApiConsume apiConsume = new ApiConsume();
    private final String URL_ADDRESS = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=450a57a0";


    public void showMenu() {
        System.out.println("Digite o nome da série ");
        var serieName = input.nextLine();
        var json = apiConsume.getData(URL_ADDRESS + serieName.replace(" ", "+") + API_KEY);
        
    }
}
