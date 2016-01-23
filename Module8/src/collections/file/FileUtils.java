package collections.file;

import java.util.List;

public class FileUtils {


    public static final int quantityOfDividingLines = 3;

    public void print(List<File> arrayList) {
        int longestFileName = arrayList.get(0).getName().length();
        int longestFileSize = Integer.toString(arrayList.get(0).getSize()).length();
        for (int i = 1; i < arrayList.size(); i++) {
            if (arrayList.get(i).getName().length() > longestFileName) { //find longest name
                longestFileName = arrayList.get(i).getName().length();
            }
            if (Integer.toString(arrayList.get(i).getSize()).length() > longestFileSize) {  //find longest size
                longestFileSize = Integer.toString(arrayList.get(i).getSize()).length();
            }
        }
        int columnNameWidth = longestFileName + 4;
        int columnSizeWidth = longestFileSize + 4;

        int frameLength = columnNameWidth + columnSizeWidth + quantityOfDividingLines;

        framePrint(frameLength);

        int headerNameSpaceWidth = (columnNameWidth - 4) / 2;
        int headerSizeSpaceWidth = (columnSizeWidth - 4) / 2;
        int evenName = (columnNameWidth - 4) % 2;
        int evenSize = (columnSizeWidth - 4) % 2;
        if (evenName == 0) {
            if (evenSize == 0) {
                System.out.println("|" + spacePrint(headerNameSpaceWidth) + "Name" + spacePrint(headerNameSpaceWidth) + "|" + spacePrint(headerSizeSpaceWidth) + "Size" + spacePrint(headerSizeSpaceWidth) + "|");
            } else {
                System.out.println("|" + spacePrint(headerNameSpaceWidth) + "Name" + spacePrint(headerNameSpaceWidth) + "|" + spacePrint(headerSizeSpaceWidth) + "Size" + spacePrint(headerSizeSpaceWidth) + " |");
            }
        } else {
            if (evenSize == 0) {
                System.out.println("|" + spacePrint(headerNameSpaceWidth) + "Name" + spacePrint(headerNameSpaceWidth) + " |" + spacePrint(headerSizeSpaceWidth) + "Size" + spacePrint(headerSizeSpaceWidth) + "|");
            } else {
                System.out.println("|" + spacePrint(headerNameSpaceWidth) + "Name" + spacePrint(headerNameSpaceWidth) + " |" + spacePrint(headerSizeSpaceWidth) + "Size" + spacePrint(headerSizeSpaceWidth) + " |");
            }

        }

        framePrint(frameLength);

        arrayList
                .stream()
                .forEach(file -> System.out.println("| " + file.getName() + spacePrint(columnNameWidth - file.getName().length() - 2) + " | " + file.getSize() + spacePrint(columnSizeWidth - Integer.toString(file.getSize()).length() - 2) + " |"));
        framePrint(frameLength);
    }

    private void framePrint(int frameLength) {
        for (int i = 0; i < frameLength; i++) { //printing top frame
            if (i == frameLength - 1) {
                System.out.println("=");
            } else {
                System.out.print("=");
            }
        }
    }

    private String spacePrint(int quantityOfSpaces) {
        String spaceString = "";
        for (int i = 0; i < quantityOfSpaces; i++) {
            spaceString += " ";
        }
        return spaceString;
    }
}
