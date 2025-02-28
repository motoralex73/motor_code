package patterns;

//Паттерн Итератор, позволяет итерироваться по коллекции, либо каким-то данным
public class PatternsIterator {

    interface Iterator {
        boolean hasNext();
        Object next();
    }

    interface Container {
        Iterator getIterator();
    }

    static class ArrayContainer implements Container {
        String[] strings = {"Vasya","Sergey","Alex"};
        class ArrayIterator implements Iterator {
            int index;
            @Override
            public boolean hasNext() {
                return (index < strings.length) ? true : false;
            }
            @Override
            public Object next() {
                if (hasNext()) {
                    return strings[index++];
                }
                return null;
            }
        }

        @Override
        public Iterator getIterator() {
            return new ArrayIterator();
        }
    }

    public static void main(String[] args) {
        ArrayContainer arrayContainer = new ArrayContainer();
        Iterator iterator = arrayContainer.getIterator();
        while (iterator.hasNext()) System.out.println(iterator.next());
    }
}
