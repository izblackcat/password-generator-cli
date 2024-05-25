package izarkaoui.passwordgenerator.password;


import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class PasswordCommands {

    private static final String DEFAULT_LENGTH = "8";

    @ShellMethod(key = "generate", value = "Generates a password")
    public String generate(@ShellOption(defaultValue = DEFAULT_LENGTH) int length) {
        StringBuilder generated = new StringBuilder();

        for(int i=0; i<length; i++) {
            // 33 and 126: from ascii table
            int random = (int) (Math.random() * 94 + 32);

            char c = (char) random;
            generated.append(c);
        }
        return generated.toString();
    }
}
