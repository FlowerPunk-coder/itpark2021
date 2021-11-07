package lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuadraticEquation {


    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String text;
            boolean isFlag = true;
            while (isFlag) {
                System.out.println("Выберите нужное:\n" +
                        "1 - Решить квадратное уравнение\n" +
                        "2 - Факториал числа");
                text = reader.readLine();
                if (text.equals("2")) {
                    System.out.println("Введите положительное число от 0 до 20 для расчета факторила");
                    text = reader.readLine();
                    int n = Integer.parseInt(text);
                    if (n >= 0 & n < 21) {
                        factorial(n);
                        isFlag = false;
                    } else {
                        System.out.println("Некорректное значение");
                    }
                } else if (text.equals("1")) {
                    System.out.println("Для решения квадратного уравнения, пожалуйста, введите необходимые значения.");
                    while (isFlag) {
                        System.out.println("Введите первый коэффициент");
                        text = reader.readLine();
                        if (!text.equals("0")) {
                            double a = Double.parseDouble(text);
                            System.out.println("Введите второй коэффициент");
                            text = reader.readLine();
                            double b = Double.parseDouble(text);
                            System.out.println("Введите третий коэффициент");
                            text = reader.readLine();
                            double c = Double.parseDouble(text);
                            quadraticEquation(a, b, c);
                            isFlag = false;
                        } else {
                            System.out.println("Первый коэффициент не может быть 0");
                        }
                    }
                } else {
                    System.out.println("Некорректное значение");
                }
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Что-то пошло не так -> " + e.getMessage());
        }

    }

    public static void quadraticEquation(double a, double b, double c) throws InterruptedException {
        double x1;
        double x2;
        double d;

        System.out.println("Вычисляю дискриминант...");
        d = Math.pow(b, 2) - (4 * a * c);
        Thread.sleep(300);
        System.out.println("Дискриминант равен: " + d);
        Thread.sleep(300);
        System.out.println("Решаю уравнение...");
        Thread.sleep(300);
        if (d > 0) {
            x1 = (-b + Math.sqrt(d)) / (2 * a);
            x2 = (-b - Math.sqrt(d)) / (2 * a);
            System.out.printf("Уравнение имеет два корня: х1 = %.2f; x2 = %.2f;", x1, x2);
        } else if (d == 0) {
            x1 = -b / (2 * a);
            System.out.printf("Уравнение имеет один корень: х1 = %.2f;", x1);
        } else {
            System.out.println("Нет действительных решений уравнения");
        }

    }

    public static void factorial(int n) {

        long result = 1L;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        System.out.printf("Факториал числа %d! равен %d", n, result);
    }


}
