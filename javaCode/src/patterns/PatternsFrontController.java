package patterns;

import java.util.Scanner;

//Паттерн Фронт Контроллер, для обработки (POST, GET) запросов, допустим с адресной строки, Диспетчер сервлетов
public class PatternsFrontController {

    static class DispatcherServlet {
        void process(String url) {
            switch (url) {
                case "home": new HomeController().show(); break;
                case "user": new UserController().show(); break;
                default: new DefaultController().show(); break;
            }
        }
    }

    static class HomeController {
        void show() {
            System.out.println("home page");
        }
    }

    static class UserController {
        void show() {
            System.out.println("home user");
        }
    }

    static class DefaultController {
        void show() {
            System.out.println("default error page");
        }
    }

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNext()) {
                new DispatcherServlet().process(scanner.nextLine());
            }
        }
    }
}
