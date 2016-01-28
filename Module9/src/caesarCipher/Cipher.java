package caesarCipher;

import java.util.Arrays;
import java.util.List;

public class Cipher {

    public static final int ALPHABET_SIZE = 26;

    public String encryption(String message, int shiftNumber) {
        char[] text = convertToCharArray(message);

        for (int i = 0; i < text.length; i++) {
            if (text[i] >= 'a' && text[i] <= 'z') {
                text[i] = (char) (text[i] + shiftNumber);
                if (text[i] > 'z') {
                    text[i] = (char) (text[i] - ALPHABET_SIZE);
                } else if (text[i] < 'a') {
                    text[i] = (char) (text[i] + ALPHABET_SIZE);
                }
            }
        }
        message = convertToString(text);
        return message;
    }

    public String decryption(String message, int shiftNumber) {
        char[] text = convertToCharArray(message);

        for (int i = 0; i < message.length(); i++) {
            if (text[i] >= 'a' && text[i] <= 'z') {
                text[i] = (char) (text[i] - shiftNumber);
                if (text[i] > 'z') {
                    text[i] = (char) (text[i] - ALPHABET_SIZE);
                } else if (text[i] < 'a') {
                    text[i] = (char) (text[i] + ALPHABET_SIZE);
                }
            }
        }
        message = convertToString(text);
        return message;
    }

    public char[] convertToCharArray(String text) {
        return text.toCharArray();
    }

    public String convertToString(char[] charArray) {
        return Arrays.toString(charArray).replace("[", "").replace("]", "").replace(",", "").trim();

    }

    public String convertCollectionToString(List list) {
        return list.toString();
    }

}
