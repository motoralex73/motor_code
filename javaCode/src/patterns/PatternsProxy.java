package patterns;

//Паттерн Прокси, что-то промежуточное, прокси.
public class PatternsProxy {

    static interface CarImpl {
        void drive();
    }
    static class CarProxy implements CarImpl {

        CarImpl car = new Reno();
        @Override
        public void drive() {
            System.out.println("proxy code");
            car.drive();
        }
    }

    static class Reno implements CarImpl {

        @Override
        public void drive() {
            System.out.println("drive Reno");
        }
    }


    public static void main(String[] args) {

        CarProxy carProxy = new CarProxy();
        carProxy.drive();
    }
}
