package collections;

import java.io.File;
import java.io.IOException;
import java.util.*;


public class CollectionExample {

    static class Book {
        String name;
        public Book(String name) {
            this.name = name;
        }
        @Override
        public String toString() { return "Book " + "name = '" + name + '\''; }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        int[] array = new int[15];
        array[0] = 1;
        ArrayList<Integer> arrays = new ArrayList();
        Collections collections;
        Collection collection = new ArrayList();
        collection.add(1);
        collection.add(2);
        collection.add(3);
        //while (collection.iterator().hasNext()) System.out.println(collection);
        for (Object o : collection) System.out.print(o+"; "); System.out.println("\n");

        // Collections
        List l = new ArrayList();       //список
        Set s = new LinkedHashSet();    //множество, Linked - сохраняет порядок, другие сортируют по порядку
        Queue q = new PriorityQueue();  //очередь
        Map m = new HashMap();          //словарь
        //неупорядоченные, упорядоченные и отсортированные (когда задаем алгоритм сортировки)

        l.add(1);
        l.set(0,11);
        for (int i=10;i>=0;i--) l.add(0, i);
        System.out.println(l);

        for (int i=0;i<10;i++) q.offer(i);
        System.out.println(q);
        while(q.iterator().hasNext()) System.out.print(q.poll()); //удаляет элементы из очереди
        System.out.println("\ncount of q-elements = "+q.size());

        for (int i=10;i>=0;i--) s.add(i); //повторные элементы в сет добавляются 1 раз,  сам сортирует
        System.out.println(s);

        m.put(3, new Book("Pelevin"));
        m.put(1, "one");
        m.put(2, new Book("King"));

        System.out.println(m);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter: ");
        Integer myInt = sc.nextInt();
        System.out.println(myInt);

        File f = new File("D:/123/data");
        f.createNewFile();

        int[] massive = new int[15];
        System.out.println("size of massive = "+massive.length);
        int initMassive[] = {1,2,3,4,5,6,7};
        for(int i=0;i<initMassive.length;i++) {
            System.out.print(initMassive[i]);
            Thread.sleep(i*100);
        }
        System.out.println("\n");

        String[] strings = new String[3];
        strings[0] = "hello";
        strings[1] += "my";
        strings[2] = "friend";
        for (String ss : strings) {
            System.out.println(ss);
        }

        String sss = null;
        sss += "HER";
        System.out.println(sss);

        int[][] matrix = { {1,2,3,4}, {5,6}, {7,8,9}};
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++ ) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

    }
}
