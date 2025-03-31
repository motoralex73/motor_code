package example;

import java.util.Optional;

//используется для обхода NPE, стримы возвращают Optional
public class OptionalExample {

    static Optional<String> getNull() {
        if (false) return Optional.of("HELLO");
        return Optional.empty();
    }

    public static void main(String[] args) {

        Optional<String> optional = getNull();
        if (optional.isPresent())
        System.out.println(optional.get());
    }
}
