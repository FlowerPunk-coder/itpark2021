package lesson2;

public class SecondProgram {

    public static void main(String[] args) {

        System.out.println("В результате сложения получилось: " + summa(3,5));

        minus(48,56);

        long multi = multiply(15,8);
        System.out.println("В результате умножения получилось: " + multi);

        divide(5,0);
        divide(15,3);

        betweenTwoPoints(2.5, 1, 4.5, 2.5);
    }


    public static int summa(int a, int b) {

        return a + b;
    }

    public static void minus(int a, int b) {

        int result = a - b;
        System.out.println("В результате вычитания получилось: " + result);
    }

    public static int multiply(int a, int b) {

        return a * b;
    }

    public static void divide(double a, double b) {

        if (b != 0) {
            double result = a / b;
            System.out.println("В результате деления получилось: " + result);
        }else {
            System.out.println("На ноль делить нельзя!");
        }
    }

    /**
     * Вычисляет расстояние между двумя точками на плоскости и выводит результат.
     * @param xA    координата х точки А
     * @param yA    координата y точки A
     * @param xB    координата x точки B
     * @param yB    координата у точки В
     */
    public static void betweenTwoPoints(double xA, double yA, double xB, double yB) {

        double ab = Math.sqrt(Math.pow((xB - xA), 2) + Math.pow((yB - yA), 2));
        System.out.println("Расстояние между двумя точками равно: " + ab);
    }
}
