package tests;

import com.github.javafaker.Faker;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class TestData {
    public static Faker faker = new Faker();
    static Random random = new Random();

    static String[]
            gender = {"Male", "Female", "Other"},
            hobbies = {"Sports", "Reading", "Music"},
            month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"},
            subjects = {"Math", "Chemistry", "Computer Science", "Accounting", "Arts", "Social Studies", "History", "Physics", "Hindi"},
            state = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};

    public static String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userGender = gender[random.nextInt(gender.length)],
            userDay = getRandomDayOfBirth(),
            userMonth = month[random.nextInt(month.length)],
            userYear = getRandomYearOfBirth(),
            phone = getRandomPhone(),
            userSubject = subjects[random.nextInt(subjects.length)],
            userHobbies = hobbies[random.nextInt(hobbies.length)],
            file = "cat.jfif",
            currentAddress = faker.address().streetAddress(),
            emailWrong = firstName + lastName + "ru",
            stateCity = state[random.nextInt(state.length)],
            city = randomCity(stateCity);

    public static String randomCity(String state) {
        if (state.equals("NCR")) {
            return faker.options().option("Delhi", "Gurgaon", "Noida");
        }
        if (state.equals("Uttar Pradesh")) {
            return faker.options().option("Agra", "Lucknow", "Merrut");
        }
        if (state.equals("Haryana")) {
            return faker.options().option("Karnal", "Panipat");
        }
        if (state.equals("Rajasthan")) {
            return faker.options().option("Jaipur", "Jaiselmer");
        }
        return "Штата нет в списке";
    }

    private static Object getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    public static String getRandomPhone() {
        return String.format("%s%s%s%s", getRandomInt(7, 8), getRandomInt(900, 999), getRandomInt(100, 999), getRandomInt(100, 999));
    }

    public static String getRandomDayOfBirth() {
        if (!month.equals("February")) {
            return String.format("%s", getRandomInt(1, 31));
        } else
            return String.format("%s", getRandomInt(1, 29));
    }

    public static String getRandomYearOfBirth() {
        return String.format("%s", getRandomInt(1900, 2100));
    }
}
