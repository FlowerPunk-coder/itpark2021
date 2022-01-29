package lesson22;

import com.jayway.jsonpath.JsonPath;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Scanner;

public class URLRunner {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    Добро пожаловать в программу 'Погода в городе'
                     Сделайте выбор:
                     1 - Узнать погоду в городе \u00b0C
                     2 - Узнать погоду в городе \u00b0F
                     3 - Узнать погоду в городе К""");
            int choice = checkValue(scanner);
            if (choice > 0 & choice < 4) {
                System.out.print("Введите название города, погоду в котором хотите узнать:");
                if (choice == 1) {
                    printTemperatureInCity(scanner.next(), "metric");
                    break;
                } else if (choice == 2) {
                    printTemperatureInCity(scanner.next(), "imperial");
                    break;
                } else {
                    printTemperatureInCity(scanner.next(), "");
                    break;
                }
            } else {
                System.out.println("Некорректный ввод.");
            }
        }
        scanner.close();
    }


    public static void printTemperatureInCity(String cityName, String range) {
        try {
            URI uri = new URI("https://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=0efe8cfe3bd6dc2812dbd0200e1db284&units=" + range);
            URL url = uri.toURL();
            URLConnection urlConnection = url.openConnection();
            String jsonString = new Scanner(urlConnection.getInputStream()).nextLine();
            List<Double> temp = JsonPath.read(jsonString, "$..main[*]");
            List<String> windSpd = JsonPath.read(jsonString, "$..wind.speed");
            List<Integer> windDir = JsonPath.read(jsonString, "$..wind.deg");
            int tempo = (int) Math.round(temp.get(0));
            int tempoFeel = (int) Math.round(temp.get(1));
            String sing = getSing(range);
            String singSpeed = getSingSpeed(range);
            System.out.printf("Температура воздуха в городе %s: %+d%s, ощущается как %+d%s.\n", cityName, tempo, sing,  tempoFeel, sing);
            System.out.printf("Ветер %s %s %s.\n", getWindDirection(windDir.get(0)), windSpd.get(0), singSpeed);

        }catch (IOException ex) {
            System.out.println("Такой город не обнаружен.");
        } catch (URISyntaxException ex) {
            System.out.println("Что-то пошло не так -> " + ex.getMessage());
        }
    }

    public static String getWindDirection(int direction) {
        if (direction >= 351 || direction <= 10) {
            return "северный";
        } else if (direction <= 80) {
            return "cеверо-восточный";
        } else if (direction <= 100) {
            return "восточный";
        } else if (direction <= 170) {
            return "юго-восточный";
        } else if (direction <= 190) {
            return "южный";
        } else if (direction <= 260) {
            return "юго-западный";
        } else if (direction <= 280) {
            return "западный";
        } else {
            return "северо-западный";
        }

    }

    private static String getSing(String range) {
        if (range.equals("metric")) {
            return "\u00b0C";
        } else if (range.equals("imperial")) {
            return "\u00b0F";
        }
        return "K";
    }

    private static String getSingSpeed(String range) {
        return range.equals("imperial") ? "мили/ч" : "м/с";
    }

    public static int checkValue (Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Для ввода доступны только цифры");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
