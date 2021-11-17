package lesson5;

import java.util.Scanner;

public class DigitsFibonacci {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите номер значения в последовательности Фибоначчи которое хотите узнать: ");
            while (!scanner.hasNextInt()) {
                scanner.next();
                System.out.println("На ввод доступны только цифры");
            }
            int n = scanner.nextInt();
            searchFibonacci(n);
            System.out.println();
            System.out.println("----------------------------------------");
            System.out.println(n + " значение последовательности Фибоначчи равно " + fibonacciAsRecursion(n));
            break;
        }
        scanner.close();
    }

    public static void searchFibonacci(int n) {
        int first = 0;
        int second = 1;
        int result = 0;

        if (n == 0) {
            System.out.println("Нулевое значение последовательности Фибоначчи равно 0");
        } else if (n == 1) {
            System.out.println("Первое значение последовательности Фибоначчи равно 1");
        } else if (n == 2) {
            System.out.println("Второе значение последовательности Фибоначчи равно 1");
        } else {
            for (int i = 2; i < n; i++) {
                result = first + second;
                first = second;
                second = result;
            }
            System.out.printf("%d значение последовательности Фибоначчи равно %d", n, result);
        }
    }

    public static int fibonacciAsRecursion(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2 || n == 3) {
            return 1;
        } else {
            return fibonacciAsRecursion(n - 2) + fibonacciAsRecursion(n - 1);
        }
    }
}
