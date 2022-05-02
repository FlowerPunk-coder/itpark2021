package lesson9;

public class AutoRunner {

    public static void main(String[] args) {

        Automobile firstCar = new Car("Ferrari", "Энцо","красный", "купе",
                Fuel.PETROL100, 660, 350);
        Automobile secondCar = new Car("Porsche", "911","желтый", "купе",
                Fuel.PETROL98, 650, 310);
        Automobile thirdCar = new Car("Mercedes", "ML320","серебристый", "кроссовер",
                Fuel.DIESEL,224, 270);
        Automobile fourthCar = new Car("Volkswagen", "поло", "вишневый", "седан",
                Fuel.PETROL95, 105, 190);
        Automobile fifthCar = new Car("Lada", "веста", "баклажан", "седан",
                Fuel.PETROL92, 85, 160);
        Automobile firstTruck = new Truck("Renault", "Керакс", "белый", "самосвал",
                Fuel.DIESEL, 380, 20.8);
        Automobile secondTruck = new Truck("Faw", "J6", "синий", "самосвал",
                Fuel.DIESEL, 390, 23.0);
        Automobile thirdTruck = new Truck("Hyundai", "HD120", "белый", "изотермический фургон",
                Fuel.DIESEL, 224, 7.0);
        Automobile fourthTruck = new Truck("IVECO", "ЕвроКарго", "белый", "тент",
                Fuel.DIESEL, 280, 13.2);
        Automobile fifthTruck = new Truck("Урал", "5557", "синий", "лесовоз",
                Fuel.DIESEL, 230, 12.0);

        Automobile[] auto = new Automobile[]{firstCar, firstTruck, secondCar, secondTruck, thirdTruck, thirdCar,
                fourthCar, fourthTruck, fifthCar, fifthTruck};
        int n;
        for (Automobile car: auto) {
            n = (int) (Math.random() * 1500);
            System.out.println(car.toString() + " ");
            car.move(n);
        }



    }
}
