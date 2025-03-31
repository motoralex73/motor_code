package patterns;

import java.util.Locale;

//Шаблон, в котором меняется один из параметров и меняется поведение
public class PatternsState {

    interface State {
        void doAction(Context context);
    }

    static class Context {
        State state;
        String name;

        public Context(State state, String name) {
            this.state = state;
            this.name = name;
        }

        public void setState(State state) {
            this.state = state;
        }

        public void doAction() {
            state.doAction(this);
        }
    }

    static class LoverCaseStart implements State {

        @Override
        public void doAction(Context context) {
            System.out.println(context.name.toLowerCase());
        }
    }

    static class UpperCaseStart implements State {

        @Override
        public void doAction(Context context) {
            System.out.println(context.name.toUpperCase());
        }
    }

    public static void main(String[] args) {

        new Context(new LoverCaseStart(), "Max").doAction();
        new Context(new UpperCaseStart(),"Min").doAction();
    }
}
