package izarkaoui.passwordgenerator.password;


import izarkaoui.passwordgenerator.assertions.PasswordAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = PasswordCommands.class)
public class PasswordCommandsTests {

    private static final String charsToInclude = "&@#?";

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

    @Test
    public void whenGenerateGivenCharactersThenPasswordGenerated() {
        String generatedPassword = this.passwordCommands.generateWithCustomCharacters(charsToInclude, 8);
        assertNotNull(generatedPassword);
        assertEquals(generatedPassword.length(), 8);
        PasswordAssertions.assertContainsCharacters(generatedPassword, charsToInclude);
    }

    @Test
    public void whenGenerateGivenCharactersAndCustomLengthThenPasswordGenerated() {
        int customLength = 17;
        String generatedPassword = this.passwordCommands.generateWithCustomCharacters(charsToInclude, customLength);
        assertNotNull(generatedPassword);
        assertEquals(generatedPassword.length(), customLength);
        PasswordAssertions.assertContainsCharacters(generatedPassword, charsToInclude);
    }

    @Test
    public void whenGenerateMultiplePasswordsGivenNumberOfPasswords() {
        int number = 5;

        List<String> generatedPasswords = this.passwordCommands.generateMultiplePasswords(number);

        assertNotNull(generatedPasswords);
        assertEquals(number, generatedPasswords.size(), "Should generate the number specified of passwords");
    }

}
