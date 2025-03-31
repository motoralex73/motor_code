package patterns;

//Паттерн Визитор, засовываем Визитора, который будет подставлять наш код
public class PatternsVisitor {

    interface Animal {
        void doSame(Visitor visitor);
    }

    static class Dog implements Animal {
        @Override
        public void doSame(Visitor visitor) {
            visitor.doDog();
        }

    }

    static class Cat implements Animal {
        @Override
        public void doSame(Visitor visitor) {
            visitor.doCat();
        }
    }

    interface Visitor {
        void doDog();
        void doCat();
    }

    static class ConcreteVisitor implements Visitor {

        @Override
        public void doDog() {
            System.out.println("dog");
        }
        @Override
        public void doCat() {
            System.out.println("cat");
        }
    }

    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.doSame(new ConcreteVisitor());
        Animal cat = new Cat();
        cat.doSame(new ConcreteVisitor());
    }

}
