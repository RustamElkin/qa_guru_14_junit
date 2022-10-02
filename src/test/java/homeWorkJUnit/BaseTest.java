package homeWorkJUnit;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://www.citilink.ru";
//        Configuration.browserSize = "1920x1080";
    }
}
