package patterns;

//Паттер Билдер
public class PatternsBuilder {

    static class SportCar {
        private String name;
        private String color;
        private int speed;

        public String getName() {
            return name;
        }

        public String getColor() {
            return color;
        }

        public int getSpeed() {
            return speed;
        }

        static class Builder {
            private String name;
            private String color = "black";
            private int speed = 210;
            //должен быть конструктор с обязательным полем
            public Builder(String name) {
                this.name = name;
            }
            //сеттеры на остальные поля
            public Builder setColor(String color) {
                this.color = color;
                return this;
            }
            public Builder setSpeed(int speed) {
                this.speed = speed;
                return this;
            }
            public SportCar build() {
                return new SportCar(this);
            }
        }

        private SportCar(Builder builder) {
            this.name = builder.name;
            this.color = builder.color;
            this.speed = builder.speed;
        }

    }

    public static void main(String[] args) {

        SportCar sportCar = new SportCar.Builder("Audi").setColor("green").setSpeed(310).build();
        System.out.println(sportCar.getName());
        System.out.println(sportCar.getColor());
        System.out.println(sportCar.getSpeed());
    }
}
