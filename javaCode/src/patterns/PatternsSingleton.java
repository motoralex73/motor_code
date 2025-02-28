package patterns;

//Паттерн Синглтон, создает ссылки на один и тот же объект в памяти
class PatternsSingelton {

    static class Singelton {
        int i = 0;
        static Singelton singelton = new Singelton();
        private Singelton() {}
        public static Singelton getSingelton() {
            return singelton;
        }
    }

    public static void main(String[] args) {

        Singelton singelton = Singelton.getSingelton();
        Singelton singelton1 = Singelton.getSingelton();
        singelton.i = 100;
        System.out.println(singelton1.i);
    }
}
