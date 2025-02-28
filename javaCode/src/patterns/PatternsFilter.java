package patterns;

import java.util.ArrayList;
import java.util.List;

//Паттерн Фильтр
public class PatternsFilter {

    static class CarFilter {

        private int speed;
        private String color;
        private int countDoors;

        public int getSpeed() {
            return speed;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getCountDoors() {
            return countDoors;
        }

        public void setCountDoors(int countDoors) {
            this.countDoors = countDoors;
        }

        public CarFilter(int speed, String color, int countDoors) {
            this.speed = speed;
            this.color = color;
            this.countDoors = countDoors;
        }

        @Override
        public String toString() {
            return "> Car " + "speed=" + speed + ", color='" + color + ", countDoors=" + countDoors;
        }
    }

    interface CarFilterImpl {
        List<CarFilter> filter(List<CarFilter> cars);
    }

    static class SpeedFilter implements CarFilterImpl {

        @Override
        public List<CarFilter> filter(List<CarFilter> cars) {
            List<CarFilter> list = new ArrayList<>();
            for (CarFilter car : cars) {
                if (car.getSpeed() > 270) list.add(car);
            }
            return list;
        }
    }

    static class DoorsFilter implements CarFilterImpl {

        @Override
        public List<CarFilter> filter(List<CarFilter> cars) {
            List<CarFilter> list = new ArrayList<>();
            for (CarFilter car : cars) {
                if (car.getCountDoors() > 2) list.add(car);
            }
            return list;
        }
    }

    static class AndFilter implements CarFilterImpl {
        CarFilterImpl filterOne, filterTwo;

        public AndFilter(CarFilterImpl filterOne, CarFilterImpl filterTwo) {
            this.filterOne = filterOne;
            this.filterTwo = filterTwo;
        }

        @Override
        public List<CarFilter> filter(List<CarFilter> cars) {
            List<CarFilter> list = filterOne.filter(cars);
            return filterTwo.filter(list);
        }
    }

    static class OrFilter implements CarFilterImpl {
        CarFilterImpl filterOne, filterTwo;

        public OrFilter(CarFilterImpl filterOne, CarFilterImpl filterTwo) {
            this.filterOne = filterOne;
            this.filterTwo = filterTwo;
        }

        @Override
        public List<CarFilter> filter(List<CarFilter> cars) {
            List<CarFilter> list1 = filterOne.filter(cars);
            List<CarFilter> list2 = filterTwo.filter(cars);
            for (CarFilter car : list2) {
                if (!list1.contains(car)) list1.add(car);
            }
            return list1;
        }
    }


    public static void main(String[] args) {

        CarFilter carFilter1 = new CarFilter(270,"GREEN", 4);
        CarFilter carFilter2 = new CarFilter(270,"RED", 2);
        CarFilter carFilter3 = new CarFilter(300,"BLUE", 4);
        List<CarFilter> cars = new ArrayList<>();
        cars.add(carFilter1);
        cars.add(carFilter2);
        cars.add(carFilter3);

        List<CarFilter> carsSpeed = new SpeedFilter().filter(cars);
        System.out.println(carsSpeed);

        List<CarFilter> carsDoors = new DoorsFilter().filter(cars);
        System.out.println(carsDoors);

//        AndFilter andFilter = new AndFilter(new SpeedFilter(), new SpeedFilter());
//        cars = andFilter.filter(cars);
//        System.out.println(cars);

        OrFilter orFilter = new OrFilter(new SpeedFilter(), new SpeedFilter());
        cars = orFilter.filter(cars);
        System.out.println(cars);


    }
}
