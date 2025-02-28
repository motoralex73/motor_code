package patterns;

//Паттерн Декоратор, обертка добавляющая функционал к уже существующим методам класса
public class PatternsDecorator {

    interface FileStream {
        void read();
    }

    static class FileStreamReader implements FileStream {

        @Override
        public void read() {
            System.out.println("read file");
        }
    }

    abstract static class FileDecorator implements FileStream {
        FileStream fileStream;

        public FileDecorator(FileStream fileStream) {
            this.fileStream = fileStream;
        }
        public abstract void read();
    }

    static class FileBufferedReader extends FileDecorator {

        public FileBufferedReader(FileStream fileStream) {
            super(fileStream);
        }

        @Override
        public void read() {
            fileStream.read();
            System.out.println("buffered read");
        }
    }

    public static void main(String[] args) {
        FileStream fileStream = new FileBufferedReader(new FileStreamReader());
        fileStream.read();
    }
}
