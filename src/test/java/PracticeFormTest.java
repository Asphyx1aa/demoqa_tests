import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {
    @BeforeAll
    static void setUpTest() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void successfulFillingFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Timur");
        $("#lastName").setValue("Vlasov");
        $("#userEmail").setValue("test@email.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("7941643176");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__year-select").selectOption("1996");
        $("div[aria-label='Choose Thursday, October 3rd, 1996']").click();
        $("#subjectsInput").setValue("E");
        $(byText("English")).click();
        $("#subjectsInput").setValue("C");
        $(byText("Computer Science")).click();
        $(byText("Reading")).click();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("sample-pic.jpg");
        $("#currentAddress").setValue("г. Барнаул, ул. Гоголя, д. 38");
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();
        $("#submit").click();

        $(".table").$(byText("Student Name")).parent().shouldHave(text("Timur Vlasov"));
        $(".table").$(byText("Student Email")).parent().shouldHave(text("test@email.com"));
        $(".table").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table").$(byText("Mobile")).parent().shouldHave(text("7941643176"));
        $(".table").$(byText("Date of Birth")).parent().shouldHave(text("03 October,1996"));
        $(".table").$(byText("Subjects")).parent().shouldHave(text("English, Computer Science"));
        $(".table").$(byText("Hobbies")).parent().shouldHave(text("Reading, Music"));
        $(".table").$(byText("Picture")).parent().shouldHave(text("sample-pic.jpg"));
        $(".table").$(byText("Address")).parent().shouldHave(text("г. Барнаул, ул. Гоголя, д. 38"));
        $(".table").$(byText("State and City")).parent().shouldHave(text("Haryana Karnal"));
    }
}
