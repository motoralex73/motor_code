package generics;

public class GenericExampleCode {

    static class Car {}
    static class Honda extends Car {}
    static class Accord extends Honda {}

    static class Cell<T> {
        T t;
        public T getT() {
            return t;
        }
        public void setT(T t) {
            this.t = t;
        }
    }

    public static void main(String[] args) {

        //wildcard
        Cell<? super Honda> cell  = new Cell<Honda>();
        cell.setT(new Honda());
        cell.setT(new Accord());

        Cell<? extends Car> cell2 = new Cell<Car>();
       // Honda h = new cell2.getT();
    }
}
