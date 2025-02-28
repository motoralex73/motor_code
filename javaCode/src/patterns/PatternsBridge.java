package patterns;

//Паттерн Бридж, создает имплементации для классов
public class PatternsBridge {

    abstract static class ICar {
        IBridge iBridge;

        public ICar(IBridge iBridge) {
            this.iBridge = iBridge;
        }
        public abstract void drive();
    }
    abstract class ITrack {
        IBridge iBridge;

        public ITrack(IBridge iBridge) {
            this.iBridge = iBridge;
        }
        public abstract void drive();
    }

    interface IBridge {}

    static class CarBridge implements IBridge { }
    class TrackBridge implements IBridge { }

    static class Toyota extends ICar {
        public Toyota(IBridge iBridge) {
            super(iBridge);
        }
        @Override
        public void drive() {
            System.out.println("drive car toyota");
        }
    }

    class Audi extends ICar {
        public Audi(IBridge iBridge) {
            super(iBridge);
        }
        @Override
        public void drive() {
            System.out.println("drive car audi");
        }
    }

    public static void main(String[] args) {

        ICar сar = new Toyota(new CarBridge());
        сar.drive();
    }
}
