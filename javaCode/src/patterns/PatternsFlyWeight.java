package patterns;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Паттерн Легковесный, множество однотипных объектов возвращаются или переиспользуются
public class PatternsFlyWeight {

    static class Mercedes {
        String color;
    }

    static class FlyWeightGarage {
        Map<String, Mercedes> map = new HashMap<>();
        Mercedes getMercedes(String color) {
            Mercedes mercedes = map.get(color);
            if (mercedes == null) {
                mercedes = new Mercedes();
                mercedes.color = color;
                map.put(color, mercedes);
            }
            return mercedes;
        }
    }

    public static void main(String[] args) {

        FlyWeightGarage flyWeightGarage = new FlyWeightGarage();

        Mercedes mercedes1 = flyWeightGarage.getMercedes("green");
        Mercedes mercedes2 = flyWeightGarage.getMercedes("green");

        System.out.println(mercedes1.color);
        System.out.println(mercedes2.color);
    }
}
