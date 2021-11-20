package lesson5;


import java.util.Scanner;

public class DigitsFibonacci {

    public static void main(String[] args) {

        launchProgram();
    }


    public static void launchProgram() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            //Ограничение связано с размером типа int
            System.out.println("""
                    Введите номер значения в последовательности Фибоначчи которое хотите узнать
                    (диапазон значений от 0 до 47 включительно):""");
            while (!scanner.hasNextInt()) {
                scanner.next();
                System.out.println("На ввод доступны только цифры");
            }
            int n = scanner.nextInt();
            if (n >= 0 & n <= 47) {
                searchFibonacci(n);
                break;
            } else {
                System.out.println("Некорректное значение");
            }
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
            System.out.printf("%d-е значение последовательности Фибоначчи равно %d", n, result);
        }
    }

}
