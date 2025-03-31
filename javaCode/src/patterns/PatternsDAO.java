package patterns;

//Паттерн Data Access Object, делаем несколько имплементаций interface
public class PatternsDAO {

    interface Data {
        String getData();

    }

    static class Database implements Data {
        @Override
        public String getData() {
            return "get data base";
        }
    }

    class FileSystem implements Data{
        @Override
        public String getData() {
            return "get file system";
        }
    }

    public static void main(String[] args) {

        Data db = new Database();
        System.out.println(db.getData());
    }
}
