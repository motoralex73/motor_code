package patterns;

import java.io.File;

//Паттерн Нулевой объект, для борьбы с NPE,
public class PatternsNullObject {

    interface Animal {
        void eat();
    }
    static class Lion implements Animal {

        @Override
        public void eat() {
            System.out.println("Lion eat");
        }
    }

    public static Animal getAnimal() {
        try {
            if (new File("eat.txt").exists()) {
                return new Lion();
            }
        }
        finally {
            return new NoAnimal();
        }
    }

    static class NoAnimal implements Animal {

        @Override
        public void eat() {
            System.out.println("Nothing doing");
        }
    }

    public static void main(String[] args) {
        Animal animal = getAnimal();
        animal.eat();
    }
}
