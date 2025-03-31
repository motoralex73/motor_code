package patterns;


import java.util.ArrayList;
import java.util.List;

//Паттерн Медиатор (Посредник), облегчает общение между объектами, объекты коллеги общаются между собой через посредника
public class PatternsMediator {

    //посредник
    interface Mediator {
        void requestAll(College college);
    }
    static class ConcreteMediator implements Mediator {

        List<College> colleges = new ArrayList<>();
        void add(College college) {
            colleges.add(college);
        }
        @Override
        public void requestAll(College college) {
            college.serTrue();
            for (College c : colleges) {
                c.setFalse();
            }
        }
    }

    //коллега
    interface College {
        void serTrue();
        void setFalse();
        void changeStatus();
    }
    static class ConcreteCollege implements College{

        boolean status;
        String name;
        Mediator mediator;

        public ConcreteCollege(Mediator mediator, String name) {
            this.mediator = mediator;
            this.name = name;
        }

        @Override
        public void serTrue() {
            status = true;
            System.out.println(name + " status is true");
        }
        @Override
        public void setFalse() {
            status = false;
            System.out.println(name + " status is false");
        }
        @Override
        public void changeStatus() {
            System.out.println(name + " set status is " + status);
            mediator.requestAll(this);
        }
    }

    public static void main(String[] args) {

        ConcreteMediator mediator = new ConcreteMediator();
        mediator.add(new ConcreteCollege(mediator, "one"));
        mediator.add(new ConcreteCollege(mediator, "two"));
        ConcreteCollege concreteCollege = new ConcreteCollege(mediator, "three");
        mediator.add(concreteCollege);
        concreteCollege.changeStatus();
    }

}
