package caesarCipher;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
@RunWith(value = Parameterized.class)

public class ParametrizedCipherEncryptTest {
    private static final Cipher cipher = new Cipher();
    private String message, expectedMessage;
    private int shiftNumber;

    public ParametrizedCipherEncryptTest(String message, int shiftNumber, String expectedMessage) {
        this.message = message;
        this.shiftNumber = shiftNumber;
        this.expectedMessage = expectedMessage;
    }

    //declare parameters
    @Parameterized.Parameters(name = "(index): encrypt(<{0}> by the shift {1}) = {2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"hello", 4, "lipps"},
                {"world", 5, "btwqi"},
                {"HELLO", 4, "LIPPS"},
                {"WORLD", 5, "BTWQI"}
        });
    }

    @Test
    public void testEncryption() {
        Assert.assertEquals(expectedMessage, cipher.encryption(message, shiftNumber));

    }
}