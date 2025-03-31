package generics;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GenericSomeExample {
    static class Parent {
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    static class Child extends Parent {
    }

    static class ChildLittle extends Child {
    }

    static class GenericSomeClass<T extends Parent & Serializable & Comparable> {

        // T == Object
        String var;

        //extend вниз по иерархии generics.Parent
        //T method(List<? super generics.ChildLittle> type) { // любой наследник generics.Child, можно добавлять то, что ниже по иерархии или ==
        T method(List<? extends Parent> type) {
            System.out.println(type.toString());
            return (T) type;
        }

        public static void main(String[] args) {

            List<File> lst = new ArrayList<>();
            GenericSomeClass se = new GenericSomeClass<>();
            se.var = "CHUCK NORRIS";
            lst.add(new File("/abs/hello.dat"));
            System.out.println(lst.toString());

            List<Parent> p = new ArrayList();
            Parent p1 = new Parent();
            p1.setName(se.var);
            p.add(p1);
            p.add(new Child());
            for (Parent pp : p) System.out.println(pp.toString() + " this name = " + pp.getName());
        }
    }
}
