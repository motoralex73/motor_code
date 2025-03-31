package patterns;


import java.util.ArrayList;
import java.util.List;


//Паттерн Observable, схож с Медиатором, объекты могут непосредственно друг с другом комуницировать, без посредника (как в Медиаторе)
public class PatternsObservable {

    interface Observable {
        void update();
    }

    static class Observer implements Observable{
        static List<Observer> observers = new ArrayList<>();
        String name;
        String state;

        public Observer(String name) {
            this.name = name;
            observers.add(this);
        }
        public void setState(String state) {
            this.state = state;
            notifyAllObservers();
        }

        void notifyAllObservers() {
            for (Observer o : observers) {
                o.update();
            }
        }

        @Override
        public void update() {
            System.out.println(name + " change status:" + state);
        }
    }

    public static void main(String[] args) {

        Observer o1 = new Observer("one");
        Observer o2 = new Observer("two");
        o1.setState("new state");
        o2.setState("hello");

    }
}
