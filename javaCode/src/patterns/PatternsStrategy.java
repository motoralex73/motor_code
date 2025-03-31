package patterns;

//Паттерн Стратегия, реализуем класс-стратегию и при необходимости подсовываем нужный вариант имплементации этой стратегии
public class PatternsStrategy {

    interface Strategy {
        double getPrice(double price);
    }
    class FullPrice implements Strategy{

        @Override
        public double getPrice(double price) {
            return price;
        }
    }
    static class HalfPrice implements Strategy {

        @Override
        public double getPrice(double price) {
            return price * 0.5;
        }
    }
    //стратегия
    static class Context {
        Strategy strategy;

        public Context(Strategy strategy) {
            this.strategy = strategy;
        }
        public double getPrice(double price) {
            return strategy.getPrice(price);
        }
    }

    public static void main(String[] args) {
        double startPrice = 100.0;
        Context context = new Context(new HalfPrice());
        double price = context.getPrice(startPrice);
        System.out.println(price);


    }
}
