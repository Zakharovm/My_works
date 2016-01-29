package caesarCipher;

public class Cipher {
    public static final int ALPHABET_SIZE = 26;
    public static final int INITIAL_ALPHABET_NUMBER_LC = 97;
    public static final int INITIAL_ALPHABET_NUMBER_UC = 65;

    public String encryption(String message, int shiftNumber) {
        char[] text = message.toCharArray();

        for (int i = 0; i < text.length; i++) {
            if (text[i] >= 'a' && text[i] <= 'z') {
                text[i] = (char) ((text[i] + shiftNumber) % (ALPHABET_SIZE + INITIAL_ALPHABET_NUMBER_LC));
            }
            if (text[i] >= 'A' && text[i] <= 'Z') {
                text[i] = (char) ((text[i] + shiftNumber) % (ALPHABET_SIZE + INITIAL_ALPHABET_NUMBER_UC));
            }
        }
        return new String(text);
    }

    public String decryption(String message, int shiftNumber) {
        char[] text = message.toCharArray();

        for (int i = 0; i < message.length(); i++) {
            if (text[i] >= 'a' && text[i] <= 'z') {
                text[i] = (char) ((text[i] - shiftNumber) % (ALPHABET_SIZE + INITIAL_ALPHABET_NUMBER_LC));
            }
            if (text[i] >= 'A' && text[i] <= 'Z') {
                text[i] = (char) ((text[i] - shiftNumber) % (ALPHABET_SIZE + INITIAL_ALPHABET_NUMBER_UC));
            }
        }
        return new String(text);
    }
}
