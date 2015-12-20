public class File {
            protected String name;
            protected String extension;
            public void setName(String newName){
                name = newName;
            }
            public String getName(){
                return name;
            }
            public void setExtension(String newExtension){
                name = newExtension;
            }
            public String getExtension(){
                return extension;
            }

            //для агрегации с директорией
            private Directory directory;
            public void setDirectory(Directory d){
                directory = d;
            }
            public Directory getDepartment(){
                return directory;
        }


    // наследуем класс File текстовым файлом
    public class Text_file extends File {
        private String size;
        // создаем и конструктор
        public Text_file(String n, String s, String p) {
            name = n;
            extension = s;
            size = p;
        }
        public void setExtension(String newFormat){
            extension = newFormat;
        }
        public String getExtension(){
            return extension;
        }
    }

    // наследуем класс File аудиофайлом
    public class Audio_file extends File {
        private String bitrate;
        // создаем и конструктор
        public Audio_file(String n, String s, String p) {
            name = n;
            extension = s;
            bitrate = p;
        }
        public void setExtension(String newFormat){
            extension = newFormat;
        }
        public String getExtension(){
            return extension;
        }
    }

    // наследуем класс File графическим файлом
    public class Image_file extends File {
        private String resolution;
        // создаем и конструктор
        public Image_file(String n, String s, String p) {
            name = n;
            extension = s;
            resolution = p;
        }
        public void setExtension(String newFormat){
            extension = newFormat;
        }
        public String getExtension(){
            return extension;
        }
    }

         // Агрегация директории и файлов
public class Directory {
    private String path;
    private Set files = new HashSet();
    public Directory (String f) {
        path = f;
    }

    public void addFile(File newFile){
        files.add(newFile);
        // связываем файл с папкой
        newFile.setDirectory(this);
    }
    public Set getFile(){
        return files;
    }
    public void removeFile(File e){
        files.remove(e);
    }
}