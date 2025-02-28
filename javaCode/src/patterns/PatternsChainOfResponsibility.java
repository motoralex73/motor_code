package patterns;

//Паттерн ЧейнРеспонсибилити, Цепная ответственность, абстрактный класс, дает общие обертки методов для наследников
public class PatternsChainOfResponsibility {

    static abstract class MessagePrinter {
        MessagePrinter nextPrinter;
        public void setNextPrinter(MessagePrinter nextPrinter) {
            this.nextPrinter = nextPrinter;
        }
        void print(String message) {
            printMessage(message);
            if (nextPrinter != null) nextPrinter.print(message);
        }
        abstract void printMessage(String message);
    }

    static class ConsoleMessagePrinter extends MessagePrinter {
        @Override
        void printMessage(String message) {
            System.out.println("print to console " + message);
        }
    }
    static class FileMessagePrinter extends MessagePrinter {
        @Override
        void printMessage(String message) {
            System.out.println("print to file " + message);
        }
    }
    static class DatabaseMessagePrinter extends MessagePrinter {
        @Override
        void printMessage(String message) {
            System.out.println("print to database " + message);
        }
    }

    public static void main(String[] args) {

        MessagePrinter messagePrinter = new ConsoleMessagePrinter();
        FileMessagePrinter fileMessagePrinter = new FileMessagePrinter();
        messagePrinter.setNextPrinter(fileMessagePrinter);
        fileMessagePrinter.setNextPrinter(new DatabaseMessagePrinter());
        messagePrinter.print("hello");
    }
}
