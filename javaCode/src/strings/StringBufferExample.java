package strings;

public class StringBufferExample {

    public static void main(String[] args) {

        StringBuffer stringBuffer = new StringBuffer();
        System.out.println("buffer length = " + stringBuffer.length() + " capacity = " + stringBuffer.capacity());
        String string = new String();
        System.out.println("string length = " + string.length());
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println("builder length = " + stringBuilder.length() + " capacity = " + stringBuilder.capacity());
    }
}
