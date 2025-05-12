package main.Java.com.example;

import main.Java.com.example.service.ExchangeRateService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class CurrencyConverterApp {

    private static final ExchangeRateService exchangeRateService = new ExchangeRateService();
    private static final DecimalFormat df = new DecimalFormat("#.##");

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int choice;

        do {
            printMenu();
            System.out.print("Escolha uma opção (0 para sair): ");
            try {
                choice = Integer.parseInt(reader.readLine());
                switch (choice) {
                    case 1:
                        convertCurrency("USD", "EUR", reader);
                        break;
                    case 2:
                        convertCurrency("USD", "GBP", reader);
                        break;
                    case 3:
                        convertCurrency("EUR", "USD", reader);
                        break;
                    case 4:
                        convertCurrency("EUR", "BRL", reader);
                        break;
                    case 5:
                        convertCurrency("GBP", "JPY", reader);
                        break;
                    case 6:
                        convertCurrency("CAD", "EUR", reader);
                        break;
                    case 0:
                        System.out.println("Saindo do conversor de moedas.");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                choice = -1; // Para continuar o loop
            }
            System.out.println();
        } while (choice != 0);

        reader.close();
    }

    private static void printMenu() {
        System.out.println("----- Conversor de Moedas (POO + GSON) -----");
        System.out.println("1. USD para EUR");
        System.out.println("2. USD para GBP");
        System.out.println("3. EUR para USD");
        System.out.println("4. EUR para BRL");
        System.out.println("5. GBP para JPY");
        System.out.println("6. CAD para EUR");
        System.out.println("0. Sair");
        System.out.println("-------------------------------------------");
    }

    private static void convertCurrency(String fromCurrency, String toCurrency, BufferedReader reader) throws IOException {
        System.out.println("Convertendo de " + fromCurrency + " para " + toCurrency + ".");
        System.out.print("Digite o valor em " + fromCurrency + ": ");
        try {
            double amount = Double.parseDouble(reader.readLine());
            if (amount < 0) {
                System.out.println("Por favor, digite um valor positivo.");
                return;
            }

            double rate = exchangeRateService.getRate(fromCurrency, toCurrency);
            if (rate != 0) {
                double convertedAmount = amount * rate;
                System.out.printf("%.2f %s equivalem a %s %s (Taxa: %s)\n",
                        amount, fromCurrency, df.format(convertedAmount), toCurrency, df.format(rate));
            } else {
                System.out.println("Não foi possível obter a taxa de câmbio para esta conversão.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida para o valor. Por favor, digite um número.");
        }
    }
}