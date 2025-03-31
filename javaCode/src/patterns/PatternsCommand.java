package patterns;

import java.util.ArrayList;
import java.util.List;

//Паттерн Команда, инкапсулирует в себе информацию от нескольких классов и выполняет несколько команд, предоставляя общий интерфейс.
public class PatternsCommand {

    interface Command {
        void execute();
    }
    static class MouseClick implements Command {

        @Override
        public void execute() {
            System.out.println("click command");
        }
    }
    static class MousePress implements Command {

        @Override
        public void execute() {
            System.out.println("click mouse press");
        }
    }

    static class Receiver {

        List<Command> commands = new ArrayList<>();
        void addCommand(Command command) {
            commands.add(command);
        }
        void runCommand() {
            for (Command command : commands) command.execute();
        }
    }

    public static void main(String[] args) {

        Receiver receiver = new Receiver();

        receiver.addCommand(new MousePress());
        receiver.addCommand(new MouseClick());
        receiver.addCommand(new MousePress());

        receiver.runCommand();
    }
}
