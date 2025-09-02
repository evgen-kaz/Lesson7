package tests;

import com.github.javafaker.Faker;

import java.util.Random;

public class TestData {
    public static Faker faker = new Faker();
    static Random random = new Random();

    static String[]
            gender = {"Male", "Female", "Other"},
            hobbies = {"Sports", "Reading", "Music"},
            months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"},
            subjects = {"Math", "Chemistry", "Computer Science", "Accounting", "Arts", "Social Studies", "History", "Physics", "Hindi"},
            state = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};

    public static String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userGender = gender[random.nextInt(gender.length)],
            userMonth = months[random.nextInt(months.length)],
            phone = faker.phoneNumber().subscriberNumber(10),
            userSubject = subjects[random.nextInt(subjects.length)],
            userHobbies = hobbies[random.nextInt(hobbies.length)],
            file = "cat.jfif",
            currentAddress = faker.address().streetAddress(),
            emailWrong = firstName + lastName + "ru",
            stateCity = state[random.nextInt(state.length)],
            city = selectCity(stateCity);
    public static int
            userYear = faker.number().numberBetween(1900, 2100),
            userDay = getRandomDayOfBirth(userMonth);

    private static int getRandomDayOfBirth(String userMonth) {
        if (!userMonth.equals("February")) {
            return faker.number().numberBetween(1, 31);
        } else
            return faker.number().numberBetween(1, 29);
    }

    public static String selectCity(String stateCity) {
        return switch (stateCity) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> null;
        };
    }
}
