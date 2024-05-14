import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleJUnitTest {

    int result;

    @BeforeAll
    static void beforeAll() {
        System.out.println("###   beforeAll()\n");
    }

    @AfterAll
    static void AfterAll() {
        System.out.println("###   afterAll()\n");
    }
    @BeforeEach
    void beforeEach() {
        System.out.println("###   beforeEach()\n");
        result = getResult();
    }
    @Test
    void firstTest() {
        System.out.println("###    firstTest()\n");
        Assertions.assertTrue(result > 2);
    }

    @Test
    void secondTest() {
        int result = getResult();
        System.out.println("###    secondTest()\n");
        Assertions.assertTrue(result > 2);
    }

    @Test
    void thirdTest() {
        int result = getResult();
        System.out.println("###    thirdTest()\n");
        Assertions.assertTrue(result > 2);
    }

    private int getResult() {
        return 3;
    }
}
