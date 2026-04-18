package guru.qa.tests;


import guru.qa.pages.TextBoxPage;
import guru.qa.TestBase;
import guru.qa.testData.TestData;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.sleep;
import static utils.RandomUtils.*;


public class TextBoxTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();
    TestData td = new TestData();


    @Test
    void successfulFillFormTest() {
        textBoxPage.openPage()
                .typeUserName(td.userName)
                .typeUserEmail(td.userEmail)
                .typeCurrentAddress(td.currentAddress)
                .typePermanentAddress(td.permanentAddress)
                .submitForm()
                .checkField("name", td.userName)
                .checkField("email", td.userEmail)
                .checkField("currentAddress", td.currentAddress)
                .checkField("permanentAddress", td.permanentAddress);
    }

    @Test
    void successfulFillFormTestWithUtils() {
        String userName = getRandomString(10);
        String userEmail = getRandomEmail();
        String currentAddress = getRandomAddress();
        String permanentAddress = getRandomAddress();

        textBoxPage.openPage()
                .typeUserName(userName)
                .typeUserEmail(userEmail)
                .typeCurrentAddress(currentAddress)
                .typePermanentAddress(permanentAddress)
                .submitForm();
        sleep(5000);

        textBoxPage.checkField("name", userName)
                .checkField("email", userEmail)
                .checkField("currentAddress", currentAddress)
                .checkField("permanentAddress", permanentAddress);
    }

    @Test
    void successfulFillFormWithoutAddressTest() {
        textBoxPage.openPage()
                .typeUserName(td.userName)
                .typeUserEmail(td.userEmail)
                .submitForm()
                .checkField("name", td.userName)
                .checkField("email", td.userEmail);
    }

    @Test
    void submitWithMinimalDataTest() {
        textBoxPage.openPage()
                .typeUserName(td.userName)
                .submitForm()
                .checkField("name", td.userName);
    }

}
