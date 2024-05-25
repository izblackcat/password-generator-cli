package izarkaoui.passwordgenerator;


import org.springframework.shell.standard.ShellComponent;
import org.springframework.stereotype.Component;

@Component
@ShellComponent
public class SomeClass {

    public int someMethod() {
        return 7;
    }

    public String someString() {
        return "password";
    }
}
