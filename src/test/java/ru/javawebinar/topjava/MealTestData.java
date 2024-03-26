package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.javawebinar.topjava.model.AbstractBaseEntity.START_SEQ;

public class MealTestData {

    public static final int USER_BREAKFAST_FIRST_ID = START_SEQ + 3;
    public static final int USER_DINNER_FIRST_ID = START_SEQ + 4;
    public static final int USER_EVENING_FIRST_ID = START_SEQ + 5;
    public static final int USER_BORDER_MEAL_ID = START_SEQ + 6;
    public static final int USER_BREAKFAST_SECOND_ID = START_SEQ + 7;
    public static final int USER_DINNER_SECOND_ID = START_SEQ + 8;
    public static final int USER_EVENING_SECOND_ID = START_SEQ + 9;
    public static final int ADMIN_DINNER_ID = START_SEQ + 10;
    public static final int ADMIN_EVENING_ID = START_SEQ + 11;

    public static final int NOT_FOUND = 987654;

    public static final Meal userBreakfastFirst = new Meal(USER_BREAKFAST_FIRST_ID, LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500);
    public static final Meal userDinnerFirst = new Meal(USER_DINNER_FIRST_ID, LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000);
    public static final Meal userEveningFirst = new Meal(USER_EVENING_FIRST_ID, LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500);
    public static final Meal userBorderMeal = new Meal(USER_BORDER_MEAL_ID, LocalDateTime.of(2020, Month.JANUARY, 31, 0, 0), "Еда на граничное значение", 100);
    public static final Meal userBreakfastSecond = new Meal(USER_BREAKFAST_SECOND_ID, LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Завтрак", 1000);
    public static final Meal userDinnerSecond = new Meal(USER_DINNER_SECOND_ID, LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Обед", 500);
    public static final Meal userEveningSecond = new Meal(USER_EVENING_SECOND_ID, LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 410);
    public static final Meal adminDinner = new Meal(ADMIN_DINNER_ID, LocalDateTime.of(2015, Month.JUNE, 1, 14, 0), "Админ ланч", 510);
    public static final Meal adminEvening = new Meal(ADMIN_EVENING_ID, LocalDateTime.of(2015, Month.JUNE, 1, 21, 0), "Админ ужин", 1500);

    public static final List<Meal> meals = Arrays.asList(
            userBreakfastFirst,
            userDinnerFirst,
            userEveningFirst,
            userBorderMeal,
            userBreakfastSecond,
            userDinnerSecond,
            userEveningSecond
    );

    public static final Meal getNew() {
        return new Meal(null, LocalDateTime.of(2024, Month.MARCH, 26, 14, 0), "New", 456);
    }

    public static final Meal getUpdated() {
        Meal updated = new Meal(userBreakfastFirst);
        updated.setDateTime(LocalDateTime.of(2024, Month.MARCH, 25, 14, 0));
        updated.setDescription("UpdatedDescription");
        updated.setCalories(330);
        return updated;
    }

    public static void assertMatch(Meal actual, Meal expected) {
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    public static void assertMatch(Iterable<Meal> actual, Meal... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Meal> actual, Iterable<Meal> expected) {
        assertThat(actual).usingRecursiveFieldByFieldElementComparator().isEqualTo(expected);
    }
}
