package patterns;

//Паттерн Композит Энтити, есть взаимосвязь между сервисами, паттерн объединяет их всех в один объект и клиент дергает одну сущность и берет то, что ему от всех нужно
public class PatternsCompositeEntity {

    static class DependentObject1 {
        String getData() {
            return "one";
        }
    }
    static class DependentObject2 {
        String getData() {
            return "two";
        }
    }
    static class CoarseGainedObject {
        DependentObject1 dependentObject1 = new DependentObject1();
        DependentObject2 dependentObject2 = new DependentObject2();
        public String[] getData() {
            return new String[] {dependentObject1.getData(), dependentObject2.getData()};
        }
    }
    static class CompositeEntity {
        CoarseGainedObject coarseGainedObject = new CoarseGainedObject();
        public String[] getData() {
            return coarseGainedObject.getData();
        }
    }

    public static void main(String[] args) {
        CompositeEntity compositeEntity = new CompositeEntity();
        for (String s : compositeEntity.getData()) {
            System.out.println(s);
        }
    }
}
