package lesson8.matrix;

import java.util.Arrays;
import java.util.Scanner;

public class MainMatrix {

    private static String sign;
    private int constanta;
    private int[][] matrixOne;
    private int[][] matrixTwo;
    private DriverMatrix dm;

    public MainMatrix() {

    }

    public void choiceOfProgram() {
        Scanner scanner = new Scanner(System.in);
        dm = new DriverMatrix();
        System.out.println("Добро пожаловать в программу работы с матрицами");
        while (true) {
            System.out.println("--------------");
            System.out.println("""
                    Выберите действие:
                    1 - сложить матрицы
                    2 - вычесть матрицы
                    3 - умножить матрицы
                    4 - умножить матрицу на число
                    5 - найти обратную матрицу
                    6 - возвести матрицу в степень
                    7 - транспонирование матрицы
                    0 - выйти из программы""");
            int choice = checkValue(scanner);
            if (choice == 0) {
                break;
            }
            try {
                if (choice > 0 & choice < 8) {
                    preStart(scanner, choice);
                }
                if (choice == 1) {
                    this.sign = " + ";
                    dm.summaMatrices(matrixOne, matrixTwo);
                } else if (choice == 2) {
                    this.sign = " - ";
                    dm.subtractMatrices(matrixOne, matrixTwo);
                } else if (choice == 3) {
                    this.sign = " * ";
                    dm.multiplicationMatrices(matrixOne, matrixTwo);
                } else if (choice == 4) {
                    System.out.print("Введите число на которое нужно умножить матрицу: ");
                    constanta = checkValue(scanner);
                    dm.multiplyAtConst(matrixOne, constanta);
                } else if (choice == 5) {
                    System.out.println("Данный функционал находится в разработке, " +
                            "приносим извинения за доставленные неудобства.");
                    //reverseMatrix();
                    //dm.minorMatrixThree(matrixOne,0,0);
                } else if (choice == 6) {
                    System.out.println("Данный функционал находится в разработке, " +
                            "приносим извинения за доставленные неудобства.");
                } else if (choice == 7) {
                    dm.transpon(matrixOne);
                } else {
                    System.out.println("Введено некорректное значение");
                }
            } catch (InterruptedException ex) {
                System.out.println("Что-то пошло не так -> " + ex.getMessage());
            }
        }
        scanner.close();
    }

    public void preStart(Scanner scanner, int choice) throws InterruptedException {
        if (choice <= 3) {
            System.out.println("Первая матрица");
            matrixOne = createMatrix(scanner);
            System.out.println("Вторая матрица");
            matrixTwo = createMatrix(scanner);
        } else {
            matrixOne = createMatrix(scanner);
        }
    }

    public int[][] createMatrix(Scanner scanner) throws InterruptedException {
        System.out.println("Введите размер матрицы в формате m x n");
        System.out.print("Введите количество строк (m): ");
        int m = checkValue(scanner);
        System.out.print("Введите количество столбцов (n): ");
        int n = checkValue(scanner);
        int[][] tempMatrix = new int[m][n];
        System.out.println("""
                Введите значения матрицы.
                Значения вводите в одну строку разделяя цифры запятой. Например: 1,2,-3,4 и т.д.
                Заполнение матрицы происходит строками.
                Для этой матрицы количество значений должно быть равно:""" + " " + (m * n));
        String[] values = scanner.next().split(",");
        System.out.println("Заполняю матрицу...");
        Thread.sleep(500);
        int k = 0;
        for (int i = 0; i < tempMatrix.length; i++) {
            for (int j = 0; j < tempMatrix[i].length; j++) {
                if (k < values.length) {
                    tempMatrix[i][j] = Integer.parseInt(values[k]);
                    k++;
                } else {
                    tempMatrix[i][j] = 0;
                }
            }
        }

        if (values.length < (m * n)) {
            System.out.println("Вы ввели значений меньше чем было нужно. Недостающие значения заполнены нулями.");
        }
        System.out.println("Полученное значение матрицы: ");
        printMatrix(tempMatrix);
        return tempMatrix;
    }

    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        System.out.println("------------");
    }

    public void printResult(int[][] matrixOne, int[][] matrixTwo, int[][] resultMatrix) {
        if (matrixOne == null || matrixTwo == null) {
            System.out.println("Матрицы не заполнены");
            return;
        }
        System.out.println("Результат получен:");
        for (int i = 0; i < matrixOne.length; i++) {
            if (i == Math.round(matrixOne.length / 2)) {
                System.out.println(Arrays.toString(matrixOne[i]) + this.sign + Arrays.toString(matrixTwo[i]) +
                        " = " + Arrays.toString(resultMatrix[i]));
            } else {
                System.out.println(Arrays.toString(matrixOne[i]) + "   " + Arrays.toString(matrixTwo[i]) +
                        "   " + Arrays.toString(resultMatrix[i]));
            }
        }
    }

    public int checkValue(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("Для ввода доступны только целые числа");
        }
        return scanner.nextInt();
    }

}


