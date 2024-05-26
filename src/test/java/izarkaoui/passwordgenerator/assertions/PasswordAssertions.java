package izarkaoui.passwordgenerator.assertions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordAssertions {

    public static void assertContainsCharacters(String password, String chars) {
        for(char c : chars.toCharArray()) {
            assertTrue(password.indexOf(c) >= 0, "Password should contain character " + c);
        }
    }
}
