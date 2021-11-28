package lesson8.matrix;

import java.util.Arrays;
import java.util.Scanner;

public class MainMatrix {

    private int[][] matrixOne;
    private int[][] matrixTwo;
    private int[][] resultMatrix;
    private int constanta;
    private int m;
    private int n;
    private double det;
    private String sign;

    public MainMatrix() {

    }

    public void choiceOfProgram() {
        Scanner scanner = new Scanner(System.in);
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
                if (choice > 0 & choice < 8){
                    preStart(scanner, choice);
                }
                if (choice == 1) {
                    sign = " + ";
                    summaMatrices();
                } else if (choice == 2) {
                    sign = " - ";
                    subtractMatrices();
                } else if (choice == 3) {
                    sign = " * ";
                    multiplicationMatrices();
                } else if (choice == 4) {
                    System.out.print("Введите число на которое нужно умножить матрицу: ");
                    constanta = checkValue(scanner);
                    multiplyAtConst();
                } else if (choice == 5) {

                } else if (choice == 6) {

                } else if (choice == 7) {

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
        m = checkValue(scanner);
        System.out.print("Введите количество столбцов (n): ");
        n = checkValue(scanner);
        int[][] tempMatrix = new int[m][n];
        System.out.println("""
                Введите значения матрицы.
                Значения вводите в одну строку разделяя цифры запятой. Например: 1,2,-3,4 и т.д.
                Заполнение матрицы происходит строками.
                Для этой матрицы количество значений должно быть равно: """ + " " + (m * n));
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

    public void summaMatrices() throws InterruptedException {
        if (matrixOne.length != matrixTwo.length || matrixOne[0].length != matrixTwo[0].length) {
            System.out.println("Матрицы имеют разный размер. Сложение невозможно.");
            return;
        }
        System.out.println("Выполняю сложение введеных матриц...");
        resultMatrix = new int[matrixOne.length][matrixOne[0].length];
        for (int i = 0; i < matrixOne.length; i++) {
            for (int j = 0; j < matrixOne[i].length; j++) {
                resultMatrix[i][j] = matrixOne[i][j] + matrixTwo[i][j];
            }
        }
        Thread.sleep(500);
        printResult();
    }

    private void subtractMatrices() throws InterruptedException {
        if (matrixOne.length != matrixTwo.length || matrixOne[0].length != matrixTwo[0].length) {
            System.out.println("Матрицы имеют разный размер. Вычитание невозможно.");
            return;
        }
        System.out.println("Выполняю вычитание введеных матриц...");
        resultMatrix = new int[matrixOne.length][matrixOne[0].length];
        for (int i = 0; i < matrixOne.length; i++) {
            for (int j = 0; j < matrixOne[i].length; j++) {
                resultMatrix[i][j] = matrixOne[i][j] - matrixTwo[i][j];
            }
        }
        Thread.sleep(500);
        printResult();
    }

    public void multiplicationMatrices() throws InterruptedException {
        if (matrixOne[0].length != matrixTwo.length) {
            System.out.println("Для умножения, количество столбцов первой матрицы " +
                    "должны быть равны количеству строк второй матрицы");
            return;
        }
        System.out.println("Выполняю умножение введенных матриц...");
        resultMatrix = new int[matrixOne.length][matrixTwo[0].length];
        for (int i = 0; i < matrixOne.length; i++) {
            for (int j = 0; j < matrixTwo[0].length; j++) {
                int temp = 0;
                for (int l = 0; l < matrixOne.length; l++) {
                    temp += matrixOne[i][l] * matrixTwo[l][j];
                }
                resultMatrix[i][j] = temp;
            }
        }
        Thread.sleep(500);
        printResult();
    }

    public void multiplyAtConst() throws InterruptedException {
        System.out.println("Выполняю умножение матрицы на число...");
        Thread.sleep(500);
        resultMatrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                resultMatrix[i][j] = constanta * matrixOne[i][j];
            }
        }
        System.out.println("Результат умножения:");
        printMatrix(resultMatrix);
    }

    public void reverseMatrix() {
        if ((m > 4 & m < 2) | (n > 4 & n < 2)) {
            System.out.println("Расчет обратной матрицы только для матриц второго и третьего порядка");
            return;
        }
        if (m != n) {
            System.out.println("Обратная матрица возможна только для квадратных матриц!");
            return;
        }
        System.out.println("Выполняю расчет определителя...");
        if (determinantMatrix(m)) {
            System.out.println("Определитель расчитан и равен: " + det);
            System.out.println("Выполняю расчет обратной матрицы...");

        }

    }

    public boolean determinantMatrix(int size) {
        if (size == 2) {
           det = (matrixOne[0][0] * matrixOne[1][1]) - (matrixOne[0][1] * matrixOne[1][0]);
        } else {
            det =   matrixOne[0][0] * matrixOne[1][1] * matrixOne[2][2] + //диагональ 0.0-2.0
                    matrixOne[0][1] * matrixOne[1][2] * matrixOne[2][0] + //первый треугольник (верхний)
                    matrixOne[0][2] * matrixOne[1][0] * matrixOne[2][1] - //второй треугольник (нижний) переход к минусу
                    matrixOne[0][2] * matrixOne[1][1] * matrixOne[2][0] - //диагональ 0.2-2.0
                    matrixOne[0][0] * matrixOne[1][2] * matrixOne[2][1] - //первый треугольник (нижний)
                    matrixOne[0][1] * matrixOne[1][0] * matrixOne[2][2];  //второй треугольник (верхний)
        }
        if (det == 0) {
            System.out.println("Определитель равен нулю. Матрица вырожденная. Обратной матрицы не существует.");
            return false;
        }
        return true;
    }

    public void minorMatrixTwo(int[][] matrix, int size) {
        resultMatrix = new int[m][n];
        resultMatrix[0][0] = matrix[1][1];
        resultMatrix[0][1] = -matrix[1][0];
        resultMatrix[1][0] = -matrix[0][1];
        resultMatrix[1][1] = matrix[0][0];
        transpon(resultMatrix, size);
    }

    public int[][] transpon(int[][] matrix, int size) {
        int temp;
        if (size == 2) {
            temp = matrix[0][1];
            matrix[0][1] = matrix[1][0];
            matrix[1][0] = temp;
        } else {
            temp = matrix[0][1];
            matrix[0][1] = matrix[1][0];
            matrix[1][0] = temp;
            temp = matrix[2][0];
            matrix[2][0] = matrix[0][2];
            matrix[0][2] = temp;

        }
            return matrix;
    }

    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        System.out.println("------------");
    }

    private void printResult() {
        System.out.println("Результат получен:");
        for (int i = 0; i < m; i++) {
            if (i == Math.round(n / 2)) {
                System.out.println(Arrays.toString(matrixOne[i]) + sign + Arrays.toString(matrixTwo[i]) +
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
