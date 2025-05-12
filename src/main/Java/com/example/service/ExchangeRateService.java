package main.Java.com.example.service;

import main.Java.com.example.model.ExchangeRates;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import io.github.cdimascio.dotenv.Dotenv;
public class ExchangeRateService {
//    private static final String API_BASE_URL = "https://v6.exchangerate-api.com/v6/";
    private static final Dotenv dotenv = Dotenv.load();
    private static final String API_KEY = dotenv.get("API_KEY");
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";
    private final Gson gson = new Gson();

    public double getRate(String baseCurrency, String targetCurrency) throws IOException {
        ExchangeRates rates = getExchangeRates(baseCurrency);
        if (rates != null) {
            return rates.getRate(targetCurrency);
        }
        return 0.0;
    }
    public ExchangeRates getExchangeRates(String baseCurrency) throws IOException {
        URL url = new URL(API_URL + baseCurrency); // Use esta URL para a chamada da API
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        try {
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                return gson.fromJson(response.toString(), ExchangeRates.class);
            } else {
                System.err.println("Erro ao acessar a API. Código de resposta: " + responseCode);
                return null;
            }
        } finally {
            connection.disconnect();
        }
    }
}