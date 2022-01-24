package lesson8.matrix;

public class ReverseMatrix {

    private static double det;
    private MainMatrix mtx = new MainMatrix();

    public ReverseMatrix() {

    }

    public void reverseMatrix(double[][] matrix) throws InterruptedException {
        if ((matrix.length != 3 | (matrix[0].length != 3))) {
            System.out.println("Расчет обратной матрицы только для матриц третьего порядка");
            return;
        }

        if (matrix.length != matrix[0].length) {
            System.out.println("Обратная матрица возможна только для квадратных матриц!");
            return;
        }
        double[][] resultMatrix = new double[matrix.length][matrix[0].length];
        System.out.println("Выполняю расчет определителя...");
        if (determinantMatrix(matrix, matrix.length)) {
            double[][] tempMatrix;
            int x;
            System.out.println("Определитель расчитан и равен: " + det);
            System.out.println("Выполняю расчет обратной матрицы...");
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                   tempMatrix = minorMatrixThree(matrix, i, j);
                   x = ((i + j) % 2 == 0) ? 1 : -1;
                   resultMatrix[i][j] = x * ((tempMatrix[0][0] * tempMatrix[1][1]) -
                           (tempMatrix[0][1] * tempMatrix[1][0]));
                }
            }
        }
        mtx.transpon(resultMatrix);
        mtx.printWithDet(resultMatrix, det);
        System.out.println("Выполняю проверку...");
        mtx.setValues(matrix);
        resultMatrix = mtx.multiplicationMatrices(resultMatrix);
        mtx.setValues(resultMatrix);
        resultMatrix = mtx.multiplyAtConst( 1/det);
        mtx.printMatrix(resultMatrix);
    }

    public boolean determinantMatrix(double[][] matrixOne, int size) {
        if (size == 2) {
            det = (matrixOne[0][0] * matrixOne[1][1]) - (matrixOne[0][1] * matrixOne[1][0]);
        } else {
            det = matrixOne[0][0] * matrixOne[1][1] * matrixOne[2][2] + //диагональ 0.0-2.2
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

    public double[][] minorMatrixThree(double[][] matrix, int row, int col) {
        double[][] minor = new double[matrix.length-1][matrix[0].length-1];
        int count = 0;
        int c = 0;
        for (int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(row != i && col != j) {
                    if (count == 2) {
                        c++;
                        count = 0;
                        minor[c][count] = matrix[i][j];
                    }
                    minor[c][count] = matrix[i][j];
                    count++;
                }
            }
        }
        return minor;
    }
}
