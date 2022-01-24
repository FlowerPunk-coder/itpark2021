package lesson8.matrix;

import org.junit.Assert;
import org.junit.Test;


public class MatrixTest {

    MainMatrix mainMatrix = new MainMatrix();
    ReverseMatrix reverseMatrix = new ReverseMatrix();


    @Test
    public void shouldGetSumMatrices() throws InterruptedException {
        double[][] test = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
        double[][] matrixTwo = {{0, -1, -2}, {1, 0, -1}, {2, 1, 0}};
        double[][] result = {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}};
        mainMatrix.setValues(test);
        Assert.assertArrayEquals(result, mainMatrix.summaMatrices(matrixTwo));
    }

    @Test
    public void shouldGetSubtractMatrices() throws InterruptedException {
        double[][] test = {{5, 4, -3}, {23, 21, -43}, {18, 21, 36}};
        double[][] matrixTwo = {{0, -1, -2}, {1, 0, -1}, {2, 1, 0}};
        double[][] result = {{5, 5, -1}, {22, 21, -42}, {16, 20, 36}};
        mainMatrix.setValues(test);
        Assert.assertArrayEquals(result, mainMatrix.subtractMatrices(matrixTwo));
    }

    @Test
    public void shouldMultiplicationMatrices() throws InterruptedException {
        double[][] test = {{1, 1, 1}, {1, 1, 1}};
        double[][] matrixTwo = {{3}, {3}, {3}};
        double[][] resultMulti = {{9}, {9}};
        mainMatrix.setValues(test);
        Assert.assertArrayEquals(resultMulti, mainMatrix.multiplicationMatrices(matrixTwo));
        double[][] secondTest = {{1, 2}, {4, 5}, {7, 8}};
        double[][] secondMatrixTwo = {{5}, {3}};
        double[][] secondResult = {{11}, {35}, {59}};
        mainMatrix.setValues(secondTest);
        Assert.assertArrayEquals(secondResult, mainMatrix.multiplicationMatrices(secondMatrixTwo));
        double[][] thirdTest = {{1}, {2}, {3}, {4}};
        double[][] thirdMatrixTwo = {{2}};
        double[][] thirdResult = {{2}, {4}, {6}, {8}};
        mainMatrix.setValues(thirdTest);
        Assert.assertArrayEquals(thirdResult, mainMatrix.multiplicationMatrices(thirdMatrixTwo));
    }

    @Test
    public void shouldGetTransponMatrix() throws InterruptedException {
        double[][] test = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
        double[][] result = {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}};
        Assert.assertArrayEquals(result, mainMatrix.transpon(test));
        double[][] secondTest = {{5, 6, 7}, {12, 13, 15}, {1, 2, 3}};
        double[][] secondResult = {{5, 12, 1}, {6, 13, 2}, {7, 15, 3}};
        Assert.assertArrayEquals(secondResult, mainMatrix.transpon(secondTest));
    }

    @Test
    public void shouldGetMultiplyAtConst() throws InterruptedException {
        double[][] test = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
        double[][] result = {{3, 6, 9}, {3, 6, 9}, {3, 6, 9}};
        mainMatrix.setValues(test);
        Assert.assertArrayEquals(result, mainMatrix.multiplyAtConst(3));
        double[][] secondTest = {{5, 2, 10}, {3, -4, 12}, {6, -9, 4}};
        double[][] secondResult = {{25, 10, 50}, {15, -20, 60}, {30, -45, 20}};
        mainMatrix.setValues(secondTest);
        Assert.assertArrayEquals(secondResult, mainMatrix.multiplyAtConst(5));
        double[][] thirdTest = {{5, 2, 10}, {3, 4, 12}, {6, 9, 4}};
        double[][] thirdResult = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        mainMatrix.setValues(thirdTest);
        Assert.assertArrayEquals(thirdResult, mainMatrix.multiplyAtConst(0));
    }

    @Test
    public void shouldGetPow() throws InterruptedException {
        double[][] test = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        double[][] result = {{30, 36, 42}, {66, 81, 96}, {102, 126, 150}};
        mainMatrix.setValues(test);
        Assert.assertArrayEquals(result, mainMatrix.pow(2));
        double[][] secondTest = {{0, 3, 1}, {2, 4, 1}, {2, 3, 6}};
        double[][] secondResult = {{376, 819, 621}, {546, 1207, 882}, {1242, 2646, 2275}};
        mainMatrix.setValues(secondTest);
        Assert.assertArrayEquals(secondResult, mainMatrix.pow(4));
    }

    @Test
    public void shouldGetMinor() {
        double[][] test = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        double[][] result = {{5, 6}, {8, 0}};
        Assert.assertArrayEquals(result, reverseMatrix.minorMatrixThree(test, 0, 0));
        double[][] secondTest = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        double[][] secondResult = {{1, 3}, {4, 6}};
        Assert.assertArrayEquals(secondResult, reverseMatrix.minorMatrixThree(secondTest, 2, 1));
        double[][] thirdTest = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        double[][] thirdResult = {{1, 2}, {7, 8}};
        Assert.assertArrayEquals(thirdResult, reverseMatrix.minorMatrixThree(thirdTest, 1, 2));

    }
}
