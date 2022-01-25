package lesson8.matrix;

import java.util.Scanner;

public class MatrixRunner {

    private static MainMatrix mainMatrix;



    public static void main(String[] args) {

        choiceOfProgram();
    }

    public static void choiceOfProgram() {
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
            double choice = checkValue(scanner);
            if (choice == 0) {
                break;
            }
            try {
                if (choice > 0 & choice < 8) {
                    mainMatrix = preStart(scanner);
                }
                if (choice == 1) {
                    mainMatrix.printMatrix(
                            mainMatrix.summaMatrices(
                                    mainMatrix.createMatrix(scanner)));

                } else if (choice == 2) {
                    mainMatrix.printMatrix(
                            mainMatrix.subtractMatrices(
                                    mainMatrix.createMatrix(scanner)));
                } else if (choice == 3) {
                    mainMatrix.printMatrix(
                            mainMatrix.multiplicationMatrices(
                                    mainMatrix.createMatrix(scanner)));
                } else if (choice == 4) {
                    System.out.print("Введите число на которое нужно умножить матрицу: ");
                    double x = checkValue(scanner);
                    mainMatrix.printMatrix(
                            mainMatrix.multiplyAtConst(x));
                } else if (choice == 5) {
                    ReverseMatrix rM = new ReverseMatrix();
                    rM.reverseMatrix(mainMatrix.getValues());
                } else if (choice == 6) {
                    System.out.print("Введите степень: ");
                    double x  = checkValue(scanner);
                    mainMatrix.printMatrix(
                            mainMatrix.pow(x));
                } else if (choice == 7) {
                    mainMatrix.printMatrix(mainMatrix.transpon(mainMatrix.getValues()));
                } else {
                    System.out.println("Введено некорректное значение");
                }
            } catch (InterruptedException ex) {
                System.out.println("Что-то пошло не так -> " + ex.getMessage());
            }
        }
        scanner.close();
    }

    public static MainMatrix preStart(Scanner scanner) throws InterruptedException {
        MainMatrix mM = new MainMatrix();
        mM.setValues(mM.createMatrix(scanner));
        return mM;
    }

    public static double checkValue(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            scanner.next();
            System.out.println("Для ввода доступны только цифры");
        }
        return scanner.nextDouble();
    }
}
