package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultComponent;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumber = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesCheckbox = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state"),
            stateCityInput = $("#stateCity-wrapper"),
            cityInput = $("#city"),
            submit = $("#submit"),
            modalContent = $(".modal-content");

    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultComponent modalComponent = new RegistrationResultComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setEmail(String email) {
        userEmailInput.setValue(email);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String phone) {
        userNumber.setValue(phone);
        return this;
    }

    public RegistrationPage setDateOfBirth(int day, String month, int year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, String.valueOf(year));
        return this;
    }

    public RegistrationPage checkResultInModal(String key, String value) {
        modalComponent.checkResult(key, value);
        return this;
    }

    public RegistrationPage notResultInModal() {
        modalComponent.notResult();
        return this;
    }

    public RegistrationPage setSubjects(String subjects) {
        subjectsInput.setValue(subjects).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String hobbies) {
        hobbiesCheckbox.$(byText(hobbies)).click();
        return this;
    }

    public RegistrationPage setUploadPicture(String file) {
        uploadPicture.uploadFromClasspath(file);
        return this;
    }

    public RegistrationPage setAddress(String address) {
        currentAddressInput.setValue(address);
        return this;
    }

    public RegistrationPage setState(String stateCity) {
        stateInput.click();
        stateCityInput.$(byText(stateCity)).click();
        return this;
    }

    public RegistrationPage setCity(String city) {
        cityInput.click();
        cityInput.$(byText(city)).click();
        return this;
    }

    public RegistrationPage clickTheButton() {
        submit.click();
        return this;
    }

    public RegistrationPage getTextInAModalWindow() {
        modalContent.shouldNotBe();
        return this;
    }
}
