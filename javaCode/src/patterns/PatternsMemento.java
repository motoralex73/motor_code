package patterns;

//Паттерн Хранитель,
public class PatternsMemento {

    //создает моменто и устанавливает статусы
    static class Originator {
        String state;
        public String getState() {
            return state;
        }
        public void setState(String state) {
            this.state = state;
        }
        Memento createMemento() {
            return new Memento(state);
        }
        void getDataFromMemento(Memento memento) {
            this.state = memento.getState();
        }

    }

    //отвечает за статус
    static class Memento {
        String state;
        public String getState() {
            return state;
        }

        public Memento(String state) {
            this.state = state;
        }
    }

    //хранит моменто
    static class CareTaker {
        Memento memento;

        public Memento getMemento() {
            return memento;
        }

        public void setMemento(Memento memento) {
            this.memento = memento;
        }
    }

    public static void main(String[] args) {

        Originator originator = new Originator();
        originator.setState("one");
        CareTaker careTaker = new CareTaker();
        careTaker.setMemento(originator.createMemento());
        originator.setState("two");
        originator.getDataFromMemento(careTaker.getMemento());
        System.out.println(originator.getState());
    }
}
