package lesson22;

import com.jayway.jsonpath.JsonPath;
import lombok.Getter;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class URLRunner {

    @Setter
    @Getter
    private static String apiKey;
    private final static int NORTH_MIN = 351;
    private final static int NORTH_MAX = 10;
    private final static int NORTH_EAST_MAX = 80;
    private final static int EAST_MAX = 100;
    private final static int SOUTH_EAST_MAX = 170;
    private final static int SOUTH_MAX = 190;
    private final static int SOUTH_WEST_MAX = 260;
    private final static int WEST_MAX = 280;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.println("""
                        Добро пожаловать в программу 'Погода в городе'
                         Сделайте выбор:
                         1 - Узнать погоду в городе \u00b0C
                         2 - Узнать погоду в городе \u00b0F
                         3 - Узнать погоду в городе  К""");
                int choice = checkValue(new Scanner(System.in));
                if (choice > 0 & choice < 4) {
                    System.out.print("Введите название города, погоду в котором хотите узнать: ");
                    if (choice == 1) {
                        printTemperatureInCity(br.readLine(), "metric");
                        break;
                    } else if (choice == 2) {
                        printTemperatureInCity(br.readLine(), "imperial");
                        break;
                    } else {
                        printTemperatureInCity(br.readLine(), "");
                        break;
                    }
                } else {
                    System.out.println("Некорректный ввод.");
                }
            }
        }
    }



    public static void printTemperatureInCity(String cityName, String range) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader
                    (Objects.requireNonNull(URLRunner.class.getResourceAsStream("/apikey.txt"))))) {
            setApiKey(br.readLine());
            String formattedName = cityName;
            if (cityName.contains(" ")) {
                formattedName = cityName.replaceAll(" ", "%20");
            }
            URI uri = new URI("https://api.openweathermap.org/data/2.5/weather?q="
                    + formattedName + "&appid=" + getApiKey() + "&units=" + range);
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
            System.out.printf("Температура воздуха в городе %s: %+d%s, ощущается как %+d%s.\n", cityName, tempo, sing, tempoFeel, sing);
            System.out.printf("Ветер %s %s %s.\n", getWindDirection(windDir.get(0)), windSpd.get(0), singSpeed);

        }catch (IOException | URISyntaxException ex) {
            System.out.println("Что-то пошло не так -> " + ex.getMessage());
        }
    }

    public static String getWindDirection(int direction) {
        if (direction >= NORTH_MIN || direction <= NORTH_MAX) {
            return "северный";
        } else if (direction <= NORTH_EAST_MAX) {
            return "cеверо-восточный";
        } else if (direction <= EAST_MAX) {
            return "восточный";
        } else if (direction <= SOUTH_EAST_MAX) {
            return "юго-восточный";
        } else if (direction <= SOUTH_MAX) {
            return "южный";
        } else if (direction <= SOUTH_WEST_MAX) {
            return "юго-западный";
        } else if (direction <= WEST_MAX) {
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
