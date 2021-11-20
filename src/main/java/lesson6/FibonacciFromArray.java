package lesson6;


import java.util.Scanner;

public class FibonacciFromArray {

    public static void main(String[] args) {
        launchProgram();
    }

    public static void launchProgram() {
        Scanner scanner = new Scanner(System.in);
        int[] arr = null;
        while (true) {
            System.out.println("----------------");
            System.out.println("""
                    Выберите нужное:
                    1 - Найти число в последовательности Фибоначи
                    0 - Выйти из программы""");
            int n = checkValue(scanner);
            if (n == 0) {
                break;
            } else if (n == 1) {
                //Ограничение связано с размером типа int
                System.out.println("Введите значение в диапазоне от 0 до 47 включительно");
                n = checkValue(scanner);
                if (n > 2 & n <= 47) {
                    arr = digitsFibonacciInArray(n, arr);
                } else if (n == 0) {
                    System.out.println("0-е значение последовательности Фибоначчи равно 0");
                } else if (n == 1 || n == 2) {
                    if (arr == null) {
                        arr = new int[]{0,1};
                    }
                    System.out.printf("%d-е значение последовательности Фибоначчи равно %d\n", n, arr[n - 1]);
                } else {
                    System.out.println("Некорректное значение");
                }
            } else {
                System.out.println("Некорректное значение");
            }
        }
        scanner.close();
    }

    public static int[] digitsFibonacciInArray(int n, int[] arr) {

        if (arr == null || n > arr.length) {
            arr = new int[n];
            arr[1] = 1;
            int first = 0;
            int second = 1;
            int result = 0;
            for (int i = 2; i < n; i++) {
                result = first + second;
                arr[i] = result;
                first = second;
                second = result;
            }
            System.out.printf("%d-е значение последовательности Фибоначчи равно %d\n", n, result);
        } else {
            System.out.printf("%d-е значение последовательности Фибоначчи равно %d\n", n, arr[n - 1]);
        }
        return arr;
    }

    public static int checkValue(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("На ввод доступны только цифры");
        }
        return scanner.nextInt();
    }

}

