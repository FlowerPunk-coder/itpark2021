package lesson12;

import lesson12.except.MyArrayDataException;
import lesson12.except.MyArraySizeException;

public class Matrix {

    public void sumElementsOfMatrix(String[][] matrix) {
        try {
            if (matrix == null || matrix.length != 4 || matrix[0].length != 4) {
                throw new MyArraySizeException("Матрица пустая или неподходящий размер");
            }
            System.out.println("Сумма всех чисел в ячейках матрицы равна " + calculate(matrix));
        } catch (MyArraySizeException ex) {
            System.out.println(ex.getMsg());
        } catch (MyArrayDataException ex) {
            System.out.println(ex.getMsg());
        }
    }

    private int calculate(String[][] matrix) {
        int summa = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                try {
                    summa += Integer.parseInt(matrix[i][j]);
                } catch (NumberFormatException ex) {
                    throw new MyArrayDataException("В ячейке " + i + " " + j + " не число! -> " + matrix[i][j]);
                }
            }
        }
        return summa;
    }
}
