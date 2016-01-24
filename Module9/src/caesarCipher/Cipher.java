package caesarCipher;


import java.util.Arrays;

public class Cipher {
    private char[] charArray = new char[100];

    public String encryption(String message, int shiftNumber) {
        char[] text = convertToCharArray(message);

        for (int i = 0; i < text.length; i++) {
            text[i] = (char) (text[i] + shiftNumber);
            if (text[i] > 'z') {
                text[i] = (char) (text[i] - 26);
            } else if (text[i] < 'a') {
                text[i] = (char) (text[i] + 26);
            }

        }
        message = convertToString(text);
        return message;
    }

    public String decryption(String message, int shiftNumber) {
        char[] text = convertToCharArray(message);

        for (int i = 0; i < message.length(); i++) {
            text[i] = (char) (text[i] - shiftNumber);
            if (text[i] > 'z') {
                text[i] = (char) (text[i] - 26);
            } else if (text[i] < 'a') {
                text[i] = (char) (text[i] + 26);
            }

        }
        message = convertToString(text);
        return message;
    }

    public char[] convertToCharArray(String text) {
        for (int i = 0; i < text.length(); i++) {
            charArray[i] = text.charAt(i);
        }

        return charArray;
    }

    public String convertToString(char[] charArray) {
        return Arrays.toString(charArray).replace("[", "").replace("]", "").replace(",", "").replace(" ", "").trim();

    }

}
