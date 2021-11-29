package lesson8.matrix;

public class DriverMatrix {

    private int[][] resultMatrix;
    private double det;
    private MainMatrix mtx = new MainMatrix();

    public void summaMatrices(int[][] matrixOne, int[][] matrixTwo) throws InterruptedException {
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
        mtx.printResult(matrixOne, matrixTwo, resultMatrix);
    }

    public void subtractMatrices(int[][] matrixOne, int[][] matrixTwo) throws InterruptedException {
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
        mtx.printResult(matrixOne, matrixTwo, resultMatrix);
    }

    public void multiplicationMatrices(int[][] matrixOne, int[][] matrixTwo) throws InterruptedException {
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
        mtx.printResult(matrixOne, matrixTwo, resultMatrix);
    }

    public void multiplyAtConst(int[][] matrixOne, int constanta) throws InterruptedException {
        System.out.println("Выполняю умножение матрицы на число...");
        Thread.sleep(500);
        resultMatrix = new int[matrixOne.length][matrixOne[0].length];
        for (int i = 0; i < matrixOne.length; i++) {
            for (int j = 0; j < matrixOne[0].length; j++) {
                resultMatrix[i][j] = constanta * matrixOne[i][j];
            }
        }
        System.out.println("Результат умножения:");
        mtx.printMatrix(resultMatrix);
    }

    public void reverseMatrix(int[][] matrix) {
        if ((matrix.length > 4 & matrix.length < 2) | (matrix[0].length > 4 & matrix[0].length < 2)) {
            System.out.println("Расчет обратной матрицы только для матриц второго и третьего порядка");
            return;
        }
        if (matrix.length != matrix[0].length) {
            System.out.println("Обратная матрица возможна только для квадратных матриц!");
            return;
        }
        System.out.println("Выполняю расчет определителя...");
        if (determinantMatrix(matrix, matrix.length)) {
            System.out.println("Определитель расчитан и равен: " + det);
            System.out.println("Выполняю расчет обратной матрицы...");

        }

    }

    public boolean determinantMatrix(int[][] matrixOne, int size) {
        if (size == 2) {
            det = (matrixOne[0][0] * matrixOne[1][1]) - (matrixOne[0][1] * matrixOne[1][0]);
        } else {
            det = matrixOne[0][0] * matrixOne[1][1] * matrixOne[2][2] + //диагональ 0.0-2.0
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

    public void minorMatrixThree(int[][] matrix, int row, int col) {
        resultMatrix = new int[matrix.length][matrix[0].length];
        int[][] minor = new int[matrix.length-1][matrix[0].length-1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                boolean isRemoveRow;
            }
        }
        mtx.printMatrix(resultMatrix);
    }

    public void transpon(int[][] matrix) {
        int temp;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i < j) {
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
        mtx.printMatrix(matrix);
    }
}
