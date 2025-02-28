package patterns;

//Паттер Prototype, объект который умеет клонировать себя
public class PatternsPrototype {

    static class Student implements Cloneable {
        @Override
        public Student clone() throws CloneNotSupportedException {
            return (Student) super.clone();
        }
    }

    static class Cache {
        private Student student;

        public Student getStudent() throws CloneNotSupportedException {
            return student.clone();
        }

        public void setStudent(Student student) {
            this.student = student;
        }
    }


    public static void main(String[] args) {

        Cache cache = new Cache();
        cache.setStudent(new Student());
        Student student = cache.student;
    }
}
