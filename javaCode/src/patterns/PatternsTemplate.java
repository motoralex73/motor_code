package patterns;

//Паттерн Шаблон, разные классы наследники будут работать по одному алгоритму (шаблону)
public class PatternsTemplate {

    abstract static class Game {
        abstract void startGame();
        abstract void playGame();
        abstract void endGame();

        void run() {
            startGame();
            playGame();
            endGame();
        }
    }

    static class MyGame extends Game {

        @Override
        void startGame() {
            System.out.println("start game");
        }

        @Override
        void playGame() {
            System.out.println("play game");
        }

        @Override
        void endGame() {
            System.out.println("end game");
        }
    }

    public static void main(String[] args) {

        Game game = new MyGame();
        game.run();
    }
}
