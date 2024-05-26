package izarkaoui.passwordgenerator.password;


import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.security.SecureRandom;

@ShellComponent
public class PasswordCommands {

    private static final String DEFAULT_LENGTH = "8";
    private static final SecureRandom secureRandom = new SecureRandom();

    /**
     * This command generates a password of length {@code length} if specified by the user
     * or length 8 by default
     * @param length the length of the generated password
     * @return a password
     */
    @ShellMethod(key = "generate", value = "Generates a random password of custom length or default 8")
    public String generate(@ShellOption(defaultValue = DEFAULT_LENGTH) int length) {

        if(length <= 0) {
            throw new IllegalArgumentException("Password length should be grater than 0");
        }

        StringBuilder generated = new StringBuilder();
        for(int i=0; i<length; i++) {
            // 33 and 126: from ascii table
//            int random = (int) (Math.random() * 94 + 32);
            int random = secureRandom.nextInt(94) + 32;
            char c = (char) random;
            generated.append(c);
        }
        return generated.toString();
    }


    /**
     * This command generates a password, of custom length or 8 if not specified, from the specified characters
     * @param charsToInclude a String including characters that the password should contain
     * @param length length of the password to be generated
     * @return a password
     */
    @ShellMethod(key = "generate-with-chars", value = "This command generates a password from the specified characters")
    public String generateWithCustomCharacters(@ShellOption(help = "Characters to be included in the generated password", defaultValue = "") String charsToInclude, @ShellOption(defaultValue = DEFAULT_LENGTH) int length) {

        if(length <= 0) {
            throw new IllegalArgumentException("Password length should be grater than 0");
        }

        if(charsToInclude == null || charsToInclude.isEmpty()) {
            return generate(length);
        } else {
            StringBuilder generatedPassword = new StringBuilder();
            for(int i=0; i<length; i++) {
                int random = secureRandom.nextInt(charsToInclude.length());
                generatedPassword.append(charsToInclude.charAt(random));
            }
            return generatedPassword.toString();
        }
    }
}
