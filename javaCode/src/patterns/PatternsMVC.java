package patterns;

//Паттерн Модель-Представление-Контроллер
//Контроллер работает с моделью, забирает/кладет данные
public class PatternsMVC {

    static class Student {
        String name = "Alex";
        int age = 25;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    interface ModelLayer {
        Student getStudent();
    }

    static class DBLayer implements ModelLayer {

        @Override
        public Student getStudent() {
            return new Student();
        }
    }

    static class FileSystemLayer implements ModelLayer {

        @Override
        public Student getStudent() {
            return new Student();
        }
    }

    interface View {
        void showStudent(Student student);
    }

    static class ConsoleView implements View {

        @Override
        public void showStudent(Student student) {
            System.out.println("Student name: " + student.getName() + " age: " + student.getAge());
        }
    }

    static class HtmlView implements View {

        @Override
        public void showStudent(Student student) {
            System.out.println("<html> Student name: " + student.getName() + " age: " + student.getAge() + "</html>");
        }
    }

    static class Controller {
        ModelLayer modelLayer = new DBLayer();
        View view = new ConsoleView();
        View html = new HtmlView();

        void execute () {
            Student student = modelLayer.getStudent();
            view.showStudent(student);
            html.showStudent(student);
        }
    }

    public static void main(String[] args) {

        Controller controller = new Controller();
        controller.execute();
    }
}
