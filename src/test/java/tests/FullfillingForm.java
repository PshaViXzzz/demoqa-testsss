package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FullfillingForm {

@BeforeAll
static void beforeAll() {
    Configuration.browserSize = "1920x1080";
    Configuration.baseUrl = "https://demoqa.com";
    Configuration.pageLoadStrategy = "eager";
}

@Test
void fillFormTest() {
    open("/automation-practice-form");

    $("#firstName").setValue("Pavel");
    $("#lastName").setValue("Volchenkov");
    $("#userEmail").setValue("test@test.com");
    $(byText("Male")).click();
    $("#userNumber").setValue("9107655546");

    //Date of birth
    $("#dateOfBirthInput").click();
    $(".react-datepicker__year-select").click();
    $(byText("1999")).click();
    $(".react-datepicker__month-select").click();
    $(byText("March")).click();
    $(".react-datepicker__day", 15).click();

    //Subjects
    $("#subjectsInput").setValue("Math").pressEnter();

    //Hobbies
    $(byText("Sports")).click();
    $(byText("Reading")).click();
    $(byText("Music")).click();

    //File
    $("#uploadPicture").uploadFromClasspath("images.jpg");

    //Address
    $("#currentAddress").setValue("ssssstreeet");

    //State
    $("#state").click();
    $(byText("Haryana")).click();

    //City
    $("#city").click();
    $(byText("Karnal")).click();

    $("#submit").click();

    //Assertions
    $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    $$("tr").get(1).shouldHave(text("Pavel Volchenkov"));
    $$("tr").get(2).shouldHave(text("test@test.com"));
    $$("tr").get(3).shouldHave(text("Male"));
    $$("tr").get(4).shouldHave(text("9107655546"));
    $$("tr").get(5).shouldHave(text("15 March,1999"));
    $$("tr").get(6).shouldHave(text("Maths"));
    $$("tr").get(7).shouldHave(text("Sports, Reading, Music"));
    $$("tr").get(8).shouldHave(text("images.jpg"));
    $$("tr").get(9).shouldHave(text("ssssstreeet"));
    $$("tr").get(10).shouldHave(text("Haryana Karnal"));
    $("#closeLargeModal").shouldHave(text("Close"));

    $("#closeLargeModal").click();
}
}