package lesson5;

import java.util.Scanner;

public class DigitsFibonacci {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Введите номер значения в последовательности Фибоначчи которое хотите узнать: ");
            while (!scanner.hasNextInt()) {
                scanner.next();
                System.out.println("На ввод доступны только цифры");
            }
            int n = scanner.nextInt();
            searchFibonacci(n);
            break;
        }
    }

    public static void searchFibonacci(int n) {
        int first = 0;
        int second = 1;
        int result = 0;

        if (n == 0) {
            System.out.println("Нулевое значение последовательности Фибоначчи равен 0");
        } else if (n == 1) {
            System.out.println("Первое значение последовательности Фибоначчи равен 1");
        } else if (n == 2) {
            System.out.println("Второе значение последовательности Фибоначчи равен 1");
        } else {
            for (int i = 2; i < n; i++) {
                result = first + second;
                first = second;
                second = result;
            }
            System.out.printf("%d значение последовательности Фибоначчи равен %d", n, result);
        }
    }
}
