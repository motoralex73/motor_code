package example;

public class DefaultMethod {

    interface A {
        static int add(int x, int y) {
            return x * y;
        }
        //default method
        void printMessage(String message);
        default void sayHello() {
            printMessage("say ");
        }
    }

    interface C extends A {
        default void sayHello() {
            System.out.println("hello C");
        }
    }

    static class B implements A, C {
        @Override
        public void printMessage(String message) {
            System.out.println("say " + message);
        }
        @Override
        public void sayHello() {
            printMessage("hello B");
        }
    }

    public static void main(String[] args) {
        System.out.println(A.add(5,7));
        A b = new B();
        b.sayHello();
    }
}
