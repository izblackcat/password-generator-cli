package izarkaoui.passwordgenerator.password;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = PasswordCommands.class)
public class PasswordCommandsTests {

    @Autowired
    private PasswordCommands passwordCommands;

    @Test
    public void whenGenerateGivenNoLengthThenPasswordLength8() {
        String generatedPassword = this.passwordCommands.generate(8);
        assertNotNull(generatedPassword);
        assertEquals(generatedPassword.length(), 8);
    }

    @Test
    public void whenGenerateGivenLengthThenCustomLength() {
        int customLength = 17;
        String generatedPassword = this.passwordCommands.generate(customLength);
        assertEquals(generatedPassword.length(), customLength);
    }

}
