package patterns;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//Паттерн Композит, древовидная структура паттерна, папка с паками
//содержит список самого себя, композитных объектов
public class PatternsComposite {

    class File {
        String name;
    }

    class Folder {
        String name;
        Date createDate;
        List<Folder> folders = new ArrayList<>();
        List<File> files = new ArrayList<>();

        public Folder(String name) {
            this.name = name;
        }
        void addFolder(Folder folder) {
            folders.add(folder);
        }
        void removeFolder(Folder folder) {
            folders.remove(folder);
        }
        List<Folder> getFolders() {
            return folders;
        }
        void addFile(File file) {
            files.add(file);
        }
        void removeFiles(File file) {
            files.remove(file);
        }
        List<File> getFiles() {
            return files;
        }







    }



    public static void main(String[] args) {

    }
}
