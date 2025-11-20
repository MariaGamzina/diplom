package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.is;

import android.os.SystemClock;
import android.view.View;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AuthorizationTest {


    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    private View decorView;
    @Before
    public void setUp() {
        mActivityScenarioRule.getScenario().onActivity(new ActivityScenario.ActivityAction<AppActivity>() {
            @Override
            public void perform(AppActivity activity) {
                decorView = activity.getWindow().getDecorView();
            }
        });
    }

    @Test
    public void successfulAuthorizationTest() {
        // Ждем загрузки экрана авторизации
        waitForAppToLoad();

        // Ввод логина - находим EditText внутри TextInputLayout
        onView(allOf(
                withClassName(endsWith("EditText")),
                isDescendantOfA(withId(R.id.login_text_input_layout))
        )).perform(replaceText("login2"), closeSoftKeyboard());

        // Ввод пароля - находим EditText внутри TextInputLayout
        onView(allOf(
                withClassName(endsWith("EditText")),
                isDescendantOfA(withId(R.id.password_text_input_layout))
        )).perform(replaceText("password2"), closeSoftKeyboard());

        // Нажимаем кнопку входа
        onView(withId(R.id.enter_button)).perform(click());

        // Ждем загрузки главного экрана и проверяем
        waitForMainScreen();
        onView(withText("News")).check(matches(isDisplayed()));

        ViewInteraction appCompatImageButton = onView(withId(R.id.authorization_image_button));
        appCompatImageButton.check(matches(isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction materialTextView = onView(withId(android.R.id.title));
        materialTextView.check(matches(isDisplayed()));
        materialTextView.perform(click());
    }

    @Test
    public void failedAuthorizationTest() {
        // Ждем загрузки экрана авторизации
        waitForAppToLoad();

        // Ввод логина - находим EditText внутри TextInputLayout
        onView(allOf(
                withClassName(endsWith("EditText")),
                isDescendantOfA(withId(R.id.login_text_input_layout))
        )).perform(replaceText("12345"), closeSoftKeyboard());

        // Ввод пароля - находим EditText внутри TextInputLayout
        onView(allOf(
                withClassName(endsWith("EditText")),
                isDescendantOfA(withId(R.id.password_text_input_layout))
        )).perform(replaceText("54321"), closeSoftKeyboard());

        // Нажимаем кнопку входа
        onView(withId(R.id.enter_button)).perform(click());

        //waitForErrorMessage();

        // Ждем загрузки главного экрана и проверяем


        onView(withText("Something went wrong. Try again later."))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));

    }

    @Test
    public void emptyAuthorizationTest() {
        // Ждем загрузки экрана авторизации
        waitForAppToLoad();

        // Ввод логина - находим EditText внутри TextInputLayout
        onView(allOf(
                withClassName(endsWith("EditText")),
                isDescendantOfA(withId(R.id.login_text_input_layout))
        )).perform(replaceText("     "), closeSoftKeyboard());

        // Ввод пароля - находим EditText внутри TextInputLayout
        onView(allOf(
                withClassName(endsWith("EditText")),
                isDescendantOfA(withId(R.id.password_text_input_layout))
        )).perform(replaceText("     "), closeSoftKeyboard());

        // Нажимаем кнопку входа
        onView(withId(R.id.enter_button)).perform(click());

        //waitForErrorMessage();

        // Ждем загрузки главного экрана и проверяем


        onView(withText("Login and password cannot be empty"))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));

    }

    @Test
    public void oneSymbolAuthorizationTest() {
        // Ждем загрузки экрана авторизации
        waitForAppToLoad();

        // Ввод логина - находим EditText внутри TextInputLayout
        onView(allOf(
                withClassName(endsWith("EditText")),
                isDescendantOfA(withId(R.id.login_text_input_layout))
        )).perform(replaceText("5"), closeSoftKeyboard());

        // Ввод пароля - находим EditText внутри TextInputLayout
        onView(allOf(
                withClassName(endsWith("EditText")),
                isDescendantOfA(withId(R.id.password_text_input_layout))
        )).perform(replaceText("5"), closeSoftKeyboard());

        // Нажимаем кнопку входа
        onView(withId(R.id.enter_button)).perform(click());

        //waitForErrorMessage();

        // Ждем загрузки главного экрана и проверяем

        onView(withText("Something went wrong. Try again later."))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));

    }

    @Test
    public void inrusAuthorizationTest() {
        // Ждем загрузки экрана авторизации
        waitForAppToLoad();

        // Ввод логина - находим EditText внутри TextInputLayout
        onView(allOf(
                withClassName(endsWith("EditText")),
                isDescendantOfA(withId(R.id.login_text_input_layout))
        )).perform(replaceText("Логин"), closeSoftKeyboard());

        // Ввод пароля - находим EditText внутри TextInputLayout
        onView(allOf(
                withClassName(endsWith("EditText")),
                isDescendantOfA(withId(R.id.password_text_input_layout))
        )).perform(replaceText("Пароль"), closeSoftKeyboard());

        // Нажимаем кнопку входа
        onView(withId(R.id.enter_button)).perform(click());

        //waitForErrorMessage();

        // Ждем загрузки главного экрана и проверяем

        onView(withText("Something went wrong. Try again later."))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));

    }



    /**
     * Ожидание загрузки экрана авторизации
     */
    private void waitForAppToLoad() {
        // Ждем появления основных элементов
        waitForView(R.id.login_text_input_layout, 15000);
        waitForView(R.id.password_text_input_layout, 5000);
        waitForView(R.id.enter_button, 5000);
    }

    /**
     * Ожидание загрузки главного экрана
     */
    private void waitForMainScreen() {
        waitForView(R.id.container_list_news_include_on_fragment_main, 15000);
    }

    /**
     * Ожидание появления View по ID
     */
    private void waitForView(int viewId, long timeoutMs) {
        long startTime = System.currentTimeMillis();

        while (System.currentTimeMillis() - startTime < timeoutMs) {
            try {
                onView(withId(viewId)).check(matches(isDisplayed()));
                return;
            } catch (Exception e) {
                SystemClock.sleep(500);
            }
        }
        throw new RuntimeException("View with id " + viewId + " not found within " + timeoutMs + " ms");
    }
}