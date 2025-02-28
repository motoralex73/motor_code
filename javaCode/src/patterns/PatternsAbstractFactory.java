package patterns;

//паттерн Фабрика фабрик
public class PatternsAbstractFactory {

    interface Car {
        void drive();
        void buy();
    }

    static class Toyota implements Car {
        @Override
        public void drive() {
            System.out.println("drive Toyota");
        }

        @Override
        public void buy() {
            System.out.println("congratulations, you bought a toyota");
        }
    }

    static class Audi implements Car {
        @Override
        public void drive() {
            System.out.println("drive Audi");
        }

        @Override
        public void buy() {
            System.out.println("congratulations, you bought a audi");
        }
    }

    static class CarFactory implements Factory {

        public Car createCar(String typeOfCar) {
            switch (typeOfCar) {
                case "Toyota": return new Toyota();
                case "Audi": return new Audi();
                default : return null;
            }
        }

        @Override
        public Tank createTank(String typeOfTank) {
            return null;
        }
    }

    interface Tank {
        void drive();
    }

    static class T34 implements Tank {

        @Override
        public void drive() {
            System.out.println("drive T34");
        }
    }

    static class T52 implements Tank {

        @Override
        public void drive() {
            System.out.println("drive T52");
        }
    }

    static class TankFactory implements Factory {
        @Override
        public Car createCar(String typeOfCar) {
            return null;
        }

        public Tank createTank(String typeOfTank) {
            switch (typeOfTank) {
                case "T34": return new T34();
                case "T52": return new T52();
                default: return null;
            }
        }
    }

    interface Factory {
        Car createCar(String typeOfCar);
        Tank createTank(String typeOfTank);
    }

    static class AbstractFactory {

        Factory createFactory(String typeOfFactory) {
            switch (typeOfFactory) {
                case "Car": return new CarFactory();
                case "Tank": return new TankFactory();
                default: return null;
            }
        }
    }

    public static void main(String[] args) {

        Factory carFactory = new AbstractFactory().createFactory("Car");
        Factory tankFactory = new AbstractFactory().createFactory("Tank");
        Car audi = carFactory.createCar("Audi");
        Tank t34 = tankFactory.createTank("T34");
        audi.buy();
        audi.drive();
        t34.drive();
    }

}
