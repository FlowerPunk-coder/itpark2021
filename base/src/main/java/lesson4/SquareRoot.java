package lesson4;


public class SquareRoot {

    public static void main(String[] args) {

        int sqrt = sqrt(50248000);
        if (sqrt > 0) {
            System.out.println("Квадратный корень равен: " +
                    sqrt + " Значение точное.");
        } else if (sqrt < 0) {
            System.out.println("Квадратный корень равен: " +
                    -sqrt + " Значение приблизительное.");
        }else if (sqrt == 0) {
            System.out.println("Введено недопустимое значение");
        }
    }

    /**
     * Вычисляет квадратный корень числа, если число является квадратным
     * возвращает точное значение корня, иначе приблизительное.
     * @param a Положительное число больше нуля
     * @return Возвращает положительное значение если значение квадратного корня числа точное.
     * Отрицательное значение если значение квадратного корня приблизительное.
     * Возвращает 0 если переданное значение равно или меньше нуля.
     */
    public static int sqrt(int a) {

        if (a > 0) {
            int sqrt = 0;
            int nextValue = 0; // получает следующую грань из массива
            int deductible;
            int counter; // множитель
            int[] points = numberDivision(a);
            for (int i = points.length - 1; i >= 0; i--) {
                if (points[i] >= 0) {
                    nextValue = (nextValue * 100) + points[i]; // остаток от вычитания переводим в сотни и добавляем следующую грань
                    deductible = ((sqrt * 2) * 10);
                    for (counter = 1; counter <= 10; counter++) {
                        if ((deductible + counter) * counter > nextValue) {
                            counter--;
                            nextValue = nextValue - ((deductible + counter) * counter); // остаток от вычитания
                            sqrt = (sqrt * 10) + counter;
                            break;
                        }
                    }
                }
                if (nextValue != 0 & i == 0) {

                    return -sqrt;
                }
            }
            return sqrt;
        } else {
            return 0;
        }
    }

    /**
     * Разбивает число на "грани" по две цифры справа налево,
     * если последняя (крайняя левая) цифра одна, то добавляет только ее.
     * Т.е. нулевая ячейка массива заполнена последними двумя цифрами числа.
     * При @param a равным или меньше нуля возвращает пустой массив int[10].
     * @param a Положительное число больше нуля
     * @return возвращает массив int[10].
     */
    private static int[] numberDivision(int a) {

        int[] points = new int[10];
        if (a > 0) {
            for (int i = 0; ; i++) {
                if (a > 10) {
                    points[i] = a % 100; // отделяем правую грань, по 2 цифры
                    a = a / 100; // убираем из числа отделенную грань
                } else {
                    points[i] = a;
                    break;
                }
            }
        }
        return points;
    }
}
