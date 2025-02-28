package generics;

import com.sun.tools.javac.Main;
import java.io.Serializable;

public class GenericMethod<T extends Comparable & Serializable> {

    T var;
    //Generic method
    static <T,U> T method(T type) {
        System.out.println("method "+type);
        return type;
    }

    static class Cell<T> extends JobClass {
        T t;
        Cell() {}
        <X> Cell(X x) {
            System.out.println("This construct Generic");
        }
        public T getT() {
            return t;
        }
        public void setT(T t) {
            this.t = t;
        }
        <E> E getE(E e) {
            return e;
        }
    }

    static class JobClass implements JobInterface, Serializable {
        void doit() {
            System.out.println("doit");
        }
    }
    interface JobInterface {
        static void doInterface() {
            System.out.println("this interface");
        }
    }

    static class CellJob<T extends JobClass & JobInterface & Serializable> {
        T t;
    }

    static abstract class Car implements Comparable, Serializable {
        @Override
        public String toString() {
            return "toString Car-class";
        }
    }

    public static void main(String[] args) {

        Cell<String> c = new Cell<>();
        System.out.println(c.getE("This string get number = "+new Integer(5)));

        Cell<String> cConst = new Cell<>(new Main());
        CellJob<JobClass> cj = new CellJob<>();

        method("hello");

        GenericMethod<Car> m = new GenericMethod();
        m.var = new Car() {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };
        System.out.println(m.var);
    }
}
