public class Files {
    public static void main(String[] args) {

         class File {

             Directory image = new Directory("C:/folder1/image.jpg");
             Directory audio = new Directory("C:/folder1/hello.mp3");
             Directory video = new Directory("C:/folder1/prestige.avi");
            protected String name;
            protected String extension;
        }


            // наследуем класс File текстовым файлом
            class TextFile extends File {
                private String size;

                // создаем и конструктор
                public TextFile(String n, String s, String p) {
                    name = n;
                    extension = s;
                    size = p;
                }

            }

            // наследуем класс File аудиофайлом
            class AudioFile extends File {
                private String bitrate;

                // создаем и конструктор
                public AudioFile(String n, String s, String p) {
                    name = n;
                    extension = s;
                    bitrate = p;
                }
            }

            // наследуем класс File графическим файлом
            class ImageFile extends File {
                private String resolution;

                // создаем и конструктор
                public ImageFile(String n, String s, String p) {
                    name = n;
                    extension = s;
                    resolution = p;
                }
            }

        }
    }