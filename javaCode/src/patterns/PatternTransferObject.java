package patterns;

//Паттерн Трансфер Обджект, все данные транслируются через транспортный объект
public class PatternTransferObject {

    //dao
    static class User {
        String name;
        int age;

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

    static class ServiceEJB {
        public User getUser() {
            User user = new User();
            user.setName("Minakov");
            user.setAge(34);
            return user;
        }
    }

    static class BO {
        ServiceEJB serviceEJB = new ServiceEJB();
        public User getUser() {
            return serviceEJB.getUser();
        }

        @Override
        public String toString() {
            return "name=" + serviceEJB.getUser().name;
        }
    }

    public static void main(String[] args) {

        BO bo = new BO();
        System.out.println("name = " + bo.getUser().getName() + ", age = " + bo.getUser().getAge());
    }
}
