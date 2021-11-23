package lesson6;

import java.util.Arrays;
import java.util.Scanner;


public class ArrayRunner {

    private static int[] arr;

    public static void main(String[] args) {
        choiceOfProgram();
    }


    public static void choiceOfProgram() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в программу поиска значений в массиве.");
        while (true) {
            System.out.println("------------------");
            System.out.println("""
                    Выберите действие:
                    1 - Найти МАКСимальное значение в массиве
                    2 - Найти среднее арифметическое значение всего массива
                    3 - Найти МИНИмальное значение в массиве
                    4 - Создать новый массив значений
                    0 - Выйти из программы""");
            int choice = checkValue(scanner);
            if (choice == 0) {
                break;
            } else if (choice == 1) {
                maxValue();

            } else if (choice == 2) {
                avgValue();

            } else if (choice == 3) {
                minValue();

            } else if (choice == 4) {
               createArray(scanner);

            } else {
                System.out.println("Введено некорректное значение.");
            }
        }
        scanner.close();
    }

    private static void minValue() {
        if (arr == null) {
            System.out.println("Массив не создан! Сначала создайте массив!");
            return;
        }
        try {
            System.out.println("Начинаю поиск минимального значения в массиве...");
            Thread.sleep(500);
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < arr.length; i++) {
                if (min > arr[i]) {
                    min = arr[i];
                }
            }
            System.out.println("Поиск окончен.");
            System.out.println("Минимальное значение в массиве равно " + min);
            System.out.println(Arrays.toString(arr));
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            System.out.println("Что-то пошло не так -> " + ex.getMessage());
        }
    }

    private static void avgValue() {
        if (arr == null) {
            System.out.println("Массив не создан! Сначала создайте массив!");
            return;
        }
        double avg = 0.0;
        try {
            System.out.println("Начинаю поиск среднего арифметического значения...");
            Thread.sleep(500);
            for (int i = 0; i < arr.length; i++) {
                avg += arr[i];
            }
            avg /= arr.length;
            System.out.println("Поиск окончен.");
            System.out.println("Среднее арифметическое значение всего массива равно " + avg);
            System.out.println(Arrays.toString(arr));
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            System.out.println("Что-то пошло не так -> " + ex);
        }
    }

    private static void maxValue() {
        if (arr == null) {
            System.out.println("Массив не создан! Сначала создайте массив!");
            return;
        }
        try {
            System.out.println("Начинаю поиск максимального значения в массиве...");
            Thread.sleep(500);
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < arr.length; i++) {
                if (max < arr[i]) {
                    max = arr[i];
                }
            }
            System.out.println("Поиск окончен.");
            System.out.println("Максимальное значение в массиве равно " + max);
            System.out.println(Arrays.toString(arr));
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            System.out.println("Что-то пошло не так -> " + ex.getMessage());
        }
    }

    public static void createArray(Scanner scanner) {
        while (true) {
            System.out.println("Введите желаемый размер массива от 1 до 100");
            int size = checkValue(scanner);
            if (size > 0 & size <= 100) {
                arr = new int[size];
                System.out.println("Заполняю массив значениями...");
                for (int i = 0; i < size; i++) {
                    arr[i] = (int) ((Math.random() - .5) * 100);
                }
                try {
                    Thread.sleep(500);
                    System.out.println("Массив заполнен.");
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    System.out.println("Что-то пошло не так -> " + ex.getMessage());
                }
                break;
            } else {
                System.out.println("Некорректное значение");
            }
        }
    }

    public static int checkValue(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("Для ввода доступны только целые числа");
        }
        return scanner.nextInt();
    }

}
