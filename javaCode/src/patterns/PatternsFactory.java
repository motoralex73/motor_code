package patterns;

//Паттерн Фабрика (что-то производит похожее)
public class PatternsFactory {

    interface Car {
        void drive();
    }

    static class Toyota implements Car {
        @Override
        public void drive() {
            System.out.println("drive Toyota");
        }
    }

    static class Audi implements Car {
        @Override
        public void drive() {
            System.out.println("drive Audi");
        }
    }

    static class Factory {
        public Car create(String typeOfCar) {
            switch (typeOfCar) {
                case "Toyota" : return new Toyota();
                case "Audi" : return new Audi();
                default : return null;
            }
        }
    }

    public static void main(String[] args) {

        Factory factory = new Factory();
        Car toyota = factory.create("Toyota");
        Car audi = factory.create("Audi");
        toyota.drive();
        audi.drive();
    }
}
