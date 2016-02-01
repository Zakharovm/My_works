package fileUploading;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
@RunWith(value = Parameterized.class)

public class ParametrizedCipherDecryptTest {
    private static final Cipher cipher = new Cipher();
    private String message, expectedMessage;
    private int shiftNumber;

    public ParametrizedCipherDecryptTest(String message, int shiftNumber, String expectedMessage) {
        this.message = message;
        this.shiftNumber = shiftNumber;
        this.expectedMessage = expectedMessage;
    }

    //declare parameters
    @Parameterized.Parameters(name = "(index): decrypt(<{0}> by the shift {1}) = {2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"lipps", 4, "hello"},
                {"btwqi", 5, "world"},
                {"LIPPS", 4, "HELLO"},
                {"BTWQI", 5, "WORLD"}
        });
    }

    @Test
    public void testDecryption() {
        Assert.assertEquals(expectedMessage, cipher.decryption(message, shiftNumber));
    }
}
