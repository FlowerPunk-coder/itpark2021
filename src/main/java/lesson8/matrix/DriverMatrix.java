package lesson8.matrix;

public class DriverMatrix {

    private double[][] resultMatrix;

    public DriverMatrix() {

    }

    public double[][] summaMatrices(double[][] matrixOne, double[][] matrixTwo) throws InterruptedException {
        resultMatrix = new double[matrixOne.length][matrixOne[0].length];
        if (matrixOne.length != matrixTwo.length || matrixOne[0].length != matrixTwo[0].length) {
            System.out.println("Матрицы имеют разный размер. Сложение невозможно.");
            return resultMatrix;
        }
        System.out.println("Выполняю сложение введеных матриц...");
        for (int i = 0; i < matrixOne.length; i++) {
            for (int j = 0; j < matrixOne[i].length; j++) {
                resultMatrix[i][j] = matrixOne[i][j] + matrixTwo[i][j];
            }
        }
        Thread.sleep(500);
        return resultMatrix;
    }

    public double[][] subtractMatrices(double[][] matrixOne, double[][] matrixTwo) throws InterruptedException {
        resultMatrix = new double[matrixOne.length][matrixOne[0].length];
        if (matrixOne.length != matrixTwo.length || matrixOne[0].length != matrixTwo[0].length) {
            System.out.println("Матрицы имеют разный размер. Вычитание невозможно.");
            return resultMatrix;
        }
        System.out.println("Выполняю вычитание введеных матриц...");
        for (int i = 0; i < matrixOne.length; i++) {
            for (int j = 0; j < matrixOne[i].length; j++) {
                resultMatrix[i][j] = matrixOne[i][j] - matrixTwo[i][j];
            }
        }
        Thread.sleep(500);
        return resultMatrix;
    }

    public double[][] multiplicationMatrices(double[][] matrixOne, double[][] matrixTwo) throws InterruptedException {
        resultMatrix = new double[matrixOne.length][matrixTwo[0].length];
        if (matrixOne[0].length != matrixTwo.length) {
            System.out.println("Для умножения, количество столбцов первой матрицы " +
                    "должны быть равны количеству строк второй матрицы");
            return resultMatrix;
        }
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
        return resultMatrix;
    }

    public double[][] multiplyAtConst(double[][] matrixOne, double constanta) throws InterruptedException {
        System.out.println("Выполняю умножение матрицы на число...");
        Thread.sleep(500);
        resultMatrix = new double[matrixOne.length][matrixOne[0].length];
        for (int i = 0; i < matrixOne.length; i++) {
            for (int j = 0; j < matrixOne[0].length; j++) {
                resultMatrix[i][j] = constanta * matrixOne[i][j];
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

    public double[][] pow(double[][] matrix, double x) throws InterruptedException {
        double[][] tempMatrix = matrix;
        System.out.println("Возвожу матрицу в степень " + (int) x + "...");
        for (int i = 0; i < (int) x - 1; i++) {
            tempMatrix = multiplicationMatrices(tempMatrix, matrix);
        }
        return tempMatrix;
    }
}
