package caesarCipher;

public class Cipher {
    public static final int ALPHABET_SIZE = 26;
    public static final int INITIAL_ALPHABET_NUMBER_LC = 97;
    public static final int INITIAL_ALPHABET_NUMBER_UC = 65;

    public String encryption(String message, int shiftNumber) {
        char[] text = message.toCharArray();

        for (int i = 0; i < text.length; i++) {
            if (text[i] >= 'a' && text[i] <= 'z') {
                if (text[i] >= INITIAL_ALPHABET_NUMBER_LC + ALPHABET_SIZE - shiftNumber) {
                    text[i] = (char) ((text[i] + shiftNumber - ALPHABET_SIZE) % (ALPHABET_SIZE + INITIAL_ALPHABET_NUMBER_LC));
                } else {
                    text[i] = (char) ((text[i] + shiftNumber) % (ALPHABET_SIZE + INITIAL_ALPHABET_NUMBER_LC));
                }
            }
            if (text[i] >= 'A' && text[i] <= 'Z') {
                if (text[i] >= INITIAL_ALPHABET_NUMBER_UC + ALPHABET_SIZE - shiftNumber) {
                    text[i] = (char) ((text[i] + shiftNumber - ALPHABET_SIZE) % (ALPHABET_SIZE + INITIAL_ALPHABET_NUMBER_UC));
                } else {
                    text[i] = (char) ((text[i] + shiftNumber) % (ALPHABET_SIZE + INITIAL_ALPHABET_NUMBER_UC));
                }
            }
        }
        return new String(text);
    }

    public String decryption(String message, int shiftNumber) {
        char[] text = message.toCharArray();

        for (int i = 0; i < message.length(); i++) {
            if (text[i] >= 'a' && text[i] <= 'z') {
                if (text[i] <= INITIAL_ALPHABET_NUMBER_LC - 1 + shiftNumber) {
                    text[i] = (char) ((text[i] - shiftNumber + ALPHABET_SIZE) % (ALPHABET_SIZE + INITIAL_ALPHABET_NUMBER_LC));
                } else {
                    text[i] = (char) ((text[i] - shiftNumber) % (ALPHABET_SIZE + INITIAL_ALPHABET_NUMBER_LC));
                }
            }
            if (text[i] >= 'A' && text[i] <= 'Z') {
                if (text[i] <= INITIAL_ALPHABET_NUMBER_UC - 1 + shiftNumber) {
                    text[i] = (char) ((text[i] - shiftNumber + ALPHABET_SIZE) % (ALPHABET_SIZE + INITIAL_ALPHABET_NUMBER_UC));
                } else {
                    text[i] = (char) ((text[i] - shiftNumber) % (ALPHABET_SIZE + INITIAL_ALPHABET_NUMBER_UC));
                }
            }
        }
        return new String(text);
    }
}
