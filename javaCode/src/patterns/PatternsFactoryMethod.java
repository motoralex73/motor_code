package patterns;

//Паттерн Фабричный метод, метод для создания объекта класса (бина)
public class PatternsFactoryMethod {

    static class Person {
        private Person() {}
        public static Person create() {
            return new Person();
        }
    }

    public static void main(String[] args) {
        Person person = Person.create();
        System.out.println(person);
    }
}
