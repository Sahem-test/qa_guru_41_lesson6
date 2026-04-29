package guru.qa.tests;

import guru.qa.TestBase;
import guru.qa.pages.PracticeFormPages;
import guru.qa.testData.TestData;
import org.junit.jupiter.api.Test;


public class PracticeFormTests extends TestBase {
    PracticeFormPages practiceFormPages = new PracticeFormPages();
    TestData td = new TestData();

    @Test
    void fillPracticeFormPositiveTest() {
        practiceFormPages.openPage()
                .removeAds()
                .setFirstName(td.userName)
                .setLastName(td.lastName)
                .setUserEmail(td.userEmail)
                .setGender(td.gender)
                .setUserNumber(td.userNumber)
                .setDateOfBirth(td.day, td.month, td.year)
                .setSubjects(td.subjects)
                .setHobby(td.hobby)
                .uploadPicture(td.uploadPicture)
                .setCurrentAddress(td.currentAddress)
                .setStateAndCite(td.state, td.city)
                .submitForm()

                .modalWindowShouldBeVisible()
                .checkGreetingTextModalWindow()
                .checkResult("Student Name", td.userName + " " + td.lastName)
                .checkResult("Student Email", td.userEmail)
                .checkResult("Gender", td.gender)
                .checkResult("Mobile", td.userNumber)
                .checkDateOfBirth(td.day, td.month, td.year)
                .checkResult("Subjects", td.subjects)
                .checkResult("Hobbies", td.hobby)
                .checkResult("Picture", td.uploadPicture)
                .checkResult("Address", td.currentAddress)
                .checkResult("State and City", td.state + " " + td.city);
    }

    @Test
    void minimalRequiredFieldsPositiveTest() {
        practiceFormPages.openPage()
                .removeAds()
                .setFirstName(td.userName)
                .setLastName(td.lastName)
                .setGender(td.gender)
                .setUserNumber(td.userNumber)
                .submitForm()

                .modalWindowShouldBeVisible()
                .checkGreetingTextModalWindow()
                .checkResult("Student Name", td.userName + " " + td.lastName)
                .checkResult("Gender", td.gender)
                .checkResult("Mobile", td.userNumber);
    }

    @Test
    void lessMinimalRequiredFieldsNegativeTest() {
        practiceFormPages.openPage()
                .removeAds()
                .setFirstName(td.userName)
                .submitForm()

                .modalWindowShouldNotBeVisible();

    }

    @Test
    void lessMinimalSignPhoneNegativeTest() {
        practiceFormPages.openPage()
                .removeAds()
                .setFirstName(td.userName)
                .setLastName(td.lastName)
                .setGender(td.gender)
                .setUserNumber(td.wrongNumber)
                .submitForm()

                .modalWindowShouldNotBeVisible();
    }

    @Test
    void EmptyFormTest() {
        practiceFormPages.openPage()
                .removeAds()
                .submitForm()

                .modalWindowShouldNotBeVisible()
                .requirementFillFormTest();

    }

}
