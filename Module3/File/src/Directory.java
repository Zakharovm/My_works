public class Directory {

    File image = new ImageFile();
    File audio = new AudioFile();
    File text = new TextFile();

    public Directory (File image, File audio, File text) {
        this.image = image;
        this.audio = audio;
        this.text = text;
    }

}

