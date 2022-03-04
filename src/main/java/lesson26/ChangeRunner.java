package lesson26;

import lesson26.service.ChangeValute;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
@ComponentScan("lesson26")
public class ChangeRunner {

    private final static String EXIT_WORD = "exit";


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ChangeRunner.class);
        ChangeValute changeValute = context.getBean(ChangeValute.class);
        System.out.printf("""
                Введите короткое обзначение валюты для получения курса рубля к этой валюте
                или введите %s для выхода из программы:
                """, EXIT_WORD);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String shortName = scanner.nextLine();
            if (shortName.equalsIgnoreCase(EXIT_WORD)) {
                return;
            }
            if (shortName.isBlank()) {
                System.out.println("Введенное значение не может быть пустым");
                continue;
            }
            changeValute.getValueByCode(shortName.toUpperCase()).ifPresentOrElse(
                    value -> {
                        System.out.printf("Текущий курс валюты %s равен %.4f рублей\n", shortName.toUpperCase(), value);
                        System.out.printf("Введите новое значение или введите %s для выхода\n", EXIT_WORD);
                    },
                    () -> System.out.println("Не могу найти такое значение валюты. Попробуйте еще!")
            );


        }
    }
}
