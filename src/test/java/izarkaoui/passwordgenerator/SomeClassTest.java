package izarkaoui.passwordgenerator;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = SomeClass.class)
public class SomeClassTest {

    @Autowired
    private SomeClass someClass;

    @Test
    public void testSomeMethod() {
        int result = someClass.someMethod();
        assertEquals(result, 7);
    }

    @Test
    public void testSomeString() {
        String res = someClass.someString();
        assertEquals(res, "password");
    }
}
