package main.Java.com.example.model;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

public class ExchangeRates {

    private String result;
    @SerializedName("base_code")
    private String baseCode;
    @SerializedName("conversion_rates")
    private Map<String, Double> rates;

    // Getters para todos os campos (adicione os que faltam)

    public Map<String, Double> getRates() {
        return rates;
    }

    public double getRate(String currency) {
        if (rates != null && rates.containsKey(currency)) {
            return rates.get(currency);
        }
        return 0.0; // Retorna 0 se a moeda não for encontrada
    }

    // Getters para os outros campos (exemplo):
    public String getResult() {
        return result;
    }

    public String getBaseCode() {
        return baseCode;
    }

    // Adicione getters para os outros campos conforme necessário
}