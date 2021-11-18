package lesson6;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayRunner {

    private static int index = 0;
    private static int[] arr;
    private static boolean isFlag = true;
    private static int min = Integer.MAX_VALUE;
    private static int max = Integer.MIN_VALUE;
    private static double avg;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в программу поиска значений в массиве.");

        createArray(scanner);
        choiceOfProgram(scanner);

    }


    public static void choiceOfProgram(Scanner scanner) {

        while (isFlag) {
            System.out.println("Выберите действие:\n" +
                    "1 - Найти МАКСимальное значение в массиве.\n" +
                    "2 - Найти среднее арифмитическое значение всего массива\n" +
                    "3 - Найти МИНИмальное значение в массиве\n" +
                    "0 - Выйти из программы.");
            int choice = checkValue(scanner);
            if (choice == 0) {
                break;
            } else if (choice == 1) {
                maxValue();

            } else if (choice == 2) {
                avgValue();

            } else if (choice == 3) {
                minValue();

            } else {
                System.out.println("Введено некорректное значение.");
                System.out.println("------------------------------");
            }
            resumeProgram(scanner);
        }
    }

    private static void minValue() {
        try {
            System.out.println("Начинаю поиск минимального значения в массиве...");
            Thread.sleep(500);
            for (int i = 0; i < arr.length; i++) {
                if (min > arr[i]) {
                    min = arr[i];
                    index = i;
                }
            }
            System.out.println("Поиск окончен.");
            System.out.println("Минимальное значение в массиве равно " + min + " по индексу " + index);
            System.out.println(Arrays.toString(arr));
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            System.out.println("Что-то пошло не так -> " + ex.getMessage());
        }

    }

    private static void avgValue() {
        try {
            System.out.println("Начинаю поиск среднеарифметического значения...");
            Thread.sleep(500);
            for (int i = 0; i < arr.length; i++) {
                avg += arr[i];
            }
            avg /= arr.length;
            System.out.println("Поиск окончен.");
            System.out.println("Среднеарифметическое значение всего массива равно " + avg);
            System.out.println(Arrays.toString(arr));
            Thread.sleep(500);
        }
        catch (InterruptedException ex) {
            System.out.println("Что-то пошло не так -> " + ex);
        }
    }

    private static void maxValue() {
        try {
            System.out.println("Начинаю поиск максимального значения в массиве...");
            Thread.sleep(500);
            max = arr[0];
            for (int i = 0; i < arr.length; i++) {
                if (max < arr[i]) {
                    max = arr[i];
                    index = i;
                }
            }
            System.out.println("Поиск окончен.");
            System.out.println("Максимальное значение в массиве равно " + max + " по индексу " + index);
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
                    System.out.println("Массив заполнен");
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

    public static void resumeProgram(Scanner scanner) {
        while (true) {
            System.out.println("Выберите действие:\n" +
                    "1 - Вернуться в меню\n" +
                    "0 - Выйти из программы");
            int choice = checkValue(scanner);
            if (choice == 0) {
                isFlag = false;
                break;
            } else if (choice == 1) {
                break;
            } else {
                System.out.println("Некорректное значение");
            }
        }
    }

}
