import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest {
    @BeforeAll
    static void setUpTest() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void successfulFillingFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Timur");
        $("#lastName").setValue("Vlasov");
        $("#userEmail").setValue("test@email.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("7941643176");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(9);
        $(".react-datepicker__year-select").selectOption("1996");
        $("div[aria-label='Choose Thursday, October 3rd, 1996']").click();
        $("#subjectsInput").setValue("E");
        $(byText("English")).click();
        $("#subjectsInput").setValue("C");
        $(byText("Computer Science")).click();
        $(byText("Reading")).click();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/sample-pic.jpg"));
        $("#currentAddress").setValue("г. Барнаул, ул. Гоголя, д. 38");
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();
        $("#submit").click();

    }
}
