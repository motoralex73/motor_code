package example;

public class Add {

    public static void main(String[] args) {

        Integer i1 = 100;
        Integer i2 = 100;
        System.out.println(i1 == i2);

        Integer i3 = new Integer(100);
        Integer i4 = new Integer(100);
        System.out.println(i3 == i4);

        Integer i5 = 300;
        Integer i6 = 300;
        System.out.println(i5 == i6);
        int xz = 123;
        //System.out.println(String.format("0x%x", System.identityHashCode(xz)));
        System.out.println(Integer.toHexString(System.identityHashCode(xz)));

        String str1 = "Hello";
        String str0 = "lo";
        String str2 = "Hel"+str0;
        System.out.println(str2.equals(str1));
    }

}
