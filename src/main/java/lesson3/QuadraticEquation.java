package lesson3;

import java.util.Scanner;

public class QuadraticEquation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите нужное:\n" +
                    "1 - Решить квадратное уравнение\n" +
                    "2 - Факториал числа");
            while (!scanner.hasNextInt()) {
                scanner.next();
                System.out.println("Некорректное значение");
            }
            int choice = scanner.nextInt();
            if (choice == 2) {
                beginningFactorial(scanner);
                break;
            } else if (choice == 1) {
                beginningQuadraticEquation(scanner);
                break;
            } else {
                System.out.println("Некорректное значение");
            }
        }
        scanner.close();
    }


    public static void beginningFactorial(Scanner scanner) {
        while (true) {
            System.out.println("Введите положительное число от 0 до 20 для расчета факторила");
            while (!scanner.hasNextInt()) {
                scanner.next();
                System.out.println("Некорректное значение.");
            }
            int n = scanner.nextInt();
            if (n >= 0 & n < 21) {
                factorial(n);
                break;
            }
        }
    }


    public static void beginningQuadraticEquation(Scanner scanner) {
        while (true) {
            System.out.println("Для решения квадратного уравнения, пожалуйста, введите необходимые значения.");
            System.out.println("Введите первый коэффициент:");
            double a = checkingValue(scanner);
            if (a != 0) {
                System.out.println("Введите второй коэффициент:");
                double b = checkingValue(scanner);
                System.out.println("Введите третий коэффициент:");
                double c = checkingValue(scanner);
                try {
                    quadraticEquation(a, b, c);
                } catch (InterruptedException ex) {
                    System.out.println("Что-то пошло не так -> " + ex.getMessage());
                }
                break;
            } else {
                System.out.println("Первый коэффициент не может быть 0");
            }
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

    public static double checkingValue(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            scanner.next();
            System.out.println("Для ввода доступны только цифры");
        }
        return scanner.nextDouble();
    }
}
