package lesson15;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyWordUtil {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String str = scanner.nextLine();
        frequencyWord(str);
    }

    public static void frequencyWord(String str) {
        String[] words = str.split("[ ,.!/?;:]+");
        Map<String, Integer> map  = Arrays.stream(words)
                .collect(Collectors.toMap(Function.identity(), value -> 1, Integer::sum));
        map.entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .forEach(System.out::println);
    }
}
