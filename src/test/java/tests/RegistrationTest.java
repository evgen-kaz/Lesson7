package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static tests.TestData.*;

public class RegistrationTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @DisplayName("Успешная регистрация с полным набором данных")
    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setUserNumber(phone)
                .setDateOfBirth(userDay, userMonth, userYear)
                .setSubjects(userSubject)
                .setHobbies(userHobbies)
                .setUploadPicture(file)
                .setAddress(currentAddress)
                .setState(stateCity)
                .setCity(city)
                .clickTheButton()
                .checkResultInModal("Student Name", firstName + " " + lastName)
                .checkResultInModal("Student Email", userEmail)
                .checkResultInModal("Gender", userGender)
                .checkResultInModal("Mobile", phone)
                .checkResultInModal("Date of Birth", userDay + " " + userMonth + "," + userYear)
                .checkResultInModal("Subjects", userSubject)
                .checkResultInModal("Hobbies", userHobbies)
                .checkResultInModal("Picture", file)
                .checkResultInModal("Address", currentAddress)
                .checkResultInModal("State and City", stateCity + " " + city);
    }

    @DisplayName("Успешная регистрация с минимальным набором данных")
    @Test
    void successfulRegistrationOnWithAMinimumCountOfDataTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(userGender)
                .setUserNumber(phone)
                .clickTheButton()
                .getTextInAModalWindow()
                .checkResultInModal("Student Name", firstName + " " + lastName)
                .checkResultInModal("Gender", userGender)
                .checkResultInModal("Mobile", phone);
    }

    @DisplayName("Невозможна регистрация с неправильным email")
    @Test
    void registrationIsNotPossibleWithWrongEmailTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(emailWrong)
                .setGender(userGender)
                .setUserNumber(phone)
                .clickTheButton()
                .getTextInAModalWindow()
                .notResultInModal();
    }
}
