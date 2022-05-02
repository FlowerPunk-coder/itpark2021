package lesson8.matrix;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Scanner;


public class MainMatrix {

    @Getter
    @Setter
    private double[][] values;

    public MainMatrix() {

    }

    public double[][] createMatrix(Scanner scanner) throws InterruptedException {
        System.out.println("Введите размер матрицы в формате m x n");
        System.out.print("Введите количество строк (m): ");
        double m = MatrixRunner.checkValue(scanner);
        System.out.print("Введите количество столбцов (n): ");
        double n = MatrixRunner.checkValue(scanner);
        System.out.println("""
                Введите значения матрицы.
                Значения вводите в одну строку разделяя цифры запятой. Например: 1,2,-3,4 и т.д.
                Заполнение матрицы происходит строками.
                Для этой матрицы количество значений должно быть равно:""" + " " + (int) (m * n));
        String readInput = "";
        while (readInput.equals("")) {
            readInput = scanner.nextLine();
        }
        String[] values = readInput.split("\\D+");
        System.out.println("Заполняю матрицу...");
        double[][] tempMatrix = new double[(int) m][(int) n];
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

    public void printMatrix(double[][] matrix) {
        for (double[] doubles : matrix) {
            System.out.println(Arrays.toString(doubles));
        }
        System.out.println("------------");
    }

    public double[][] summaMatrices(double[][] matrixTwo) throws InterruptedException {
        double[][] resultMatrix = new double[values.length][values[0].length];
        if (values.length != matrixTwo.length || values[0].length != matrixTwo[0].length) {
            System.out.println("Матрицы имеют разный размер. Сложение невозможно.");
            return resultMatrix;
        }
        System.out.println("Выполняю сложение введеных матриц...");
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                resultMatrix[i][j] = values[i][j] + matrixTwo[i][j];
            }
        }
        Thread.sleep(500);
        return resultMatrix;
    }

    public double[][] subtractMatrices(double[][] matrixTwo) throws InterruptedException {
        double[][] resultMatrix = new double[values.length][values[0].length];
        if (values.length != matrixTwo.length || values[0].length != matrixTwo[0].length) {
            System.out.println("Матрицы имеют разный размер. Вычитание невозможно.");
            return resultMatrix;
        }
        System.out.println("Выполняю вычитание введеных матриц...");
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                resultMatrix[i][j] = values[i][j] - matrixTwo[i][j];
            }
        }
        Thread.sleep(500);
        return resultMatrix;
    }

    public double[][] multiplicationMatrices(double[][] matrixTwo) throws InterruptedException {
        double[][] resultMatrix = new double[values.length][matrixTwo[0].length];
        if (values[0].length != matrixTwo.length) {
            System.out.println("Для умножения, количество столбцов первой матрицы " +
                    "должны быть равны количеству строк второй матрицы");
            return resultMatrix;
        }
        System.out.println("Выполняю умножение введенных матриц...");
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < matrixTwo[0].length; j++) {
                int temp = 0;
                for (int l = 0; l < values[0].length; l++) {
                    temp += values[i][l] * matrixTwo[l][j];
                }
                resultMatrix[i][j] = temp;
            }
        }
        Thread.sleep(500);
        return resultMatrix;
    }

    public double[][] multiplyAtConst(double constanta) throws InterruptedException {
        System.out.println("Выполняю умножение матрицы на число...");
        Thread.sleep(500);
        double[][] resultMatrix = new double[values.length][values[0].length];
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[0].length; j++) {
                resultMatrix[i][j] = constanta * values[i][j];
            }
        }
        System.out.println("Результат умножения:");
        return resultMatrix;
    }

    public double[][] transpon(double[][] matrix) throws InterruptedException {
        double temp;
        System.out.println("Выполняю транспонирование матрицы...");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i < j) {
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
        Thread.sleep(500);
        return matrix;
    }

    public double[][] pow(double x) throws InterruptedException {
        double[][] resultMatrix = values;
        System.out.println("Возвожу матрицу в степень " + (int) x + "...");
        for (int i = 0; i < (int) x - 1; i++) {
            resultMatrix = multiplicationMatrices(resultMatrix);
        }
        return resultMatrix;
    }

    public void printWithDet(double[][] matrixOne, double det) {
        if (matrixOne == null) {
            System.out.println("Матрицы не заполнены");
            return;
        }
        String l = 1 + "/" + det;
        if (det == 1) {
            l = "1";
        }
        String space = "";
        for (int i = 0; i < l.length() + 3; i++) {
            space += " ";
        }

        System.out.println("Результат получен:");
        for (int i = 0; i < matrixOne.length; i++) {
            if (i == Math.round(matrixOne.length / 2)) {
                System.out.println(l + " * " + Arrays.toString(matrixOne[i]));
            } else {
                System.out.println(space + Arrays.toString(matrixOne[i]));
            }
        }
    }



}

