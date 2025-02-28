package generics;

public class GenericLesson {

    // Generic T or Object type
    public static class Cell<T> {
        T t;

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
            System.out.println(t);
        }
    }

    public static class CellObject {
        Object t;

        public Object getT() {
            return t;
        }
        public void setT(Object t) {
            this.t = t;
            System.out.println(t);
        }
    }

    // example extends class
    class Parent {
        Parent() {
            System.out.println("Constructor default generics.Parent");
        }
    }
    class GetParent<T> extends Parent {
        GetParent() {
            System.out.println("Constructor GetParent");
        }
    }
    class Child1 extends GetParent {}
    class Child2 extends GetParent<String> {}
    class Child3<T> extends GetParent<T> {}
    class Child4<X, Y, T> extends GetParent<Y> {}

    // implements interface
    interface GenericInterface<T> {
        T getT();
    }

    class One<T> implements GenericInterface {
        @Override
        public Object getT() {
            return null;
        }
    }

    class Two implements GenericInterface<String> {
        @Override
        public String getT() {
            return null;
        }
    }

    public static void main(String[] args) {
        Cell<String> cell = new Cell<>();
        cell.setT("HELLO");
        String s = cell.getT();
        System.out.println(s+", my friend");

        CellObject cellObject = new CellObject();
        cellObject.setT("GOODBYE");
        String sObject = (String)cellObject.getT();
        System.out.println(sObject+", my friend");
    }
}
