package ru.iteco.fmhandroid.ui;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class TopbarTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);


    @Test
    public void appActivityTest3() {
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
        onView(withText("News")).check(matches(isDisplayed()));

        //Нажимаем на кнопку главного меню
        ViewInteraction appCompatImageButton = onView(withId(R.id.main_menu_image_button));
        appCompatImageButton.check(matches(isDisplayed()));
        appCompatImageButton.perform(click());

        // Проверяем активность строк главного меню
        ViewInteraction textView2 = onView(
                allOf(withId(android.R.id.title), withText("Main"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        textView2.check(matches(withText("Main")));

        ViewInteraction textView3 = onView(
                allOf(withId(android.R.id.title), withText("News"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        textView3.check(matches(withText("News")));

        ViewInteraction textView4 = onView(
                allOf(withId(android.R.id.title), withText("About"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        textView4.check(matches(withText("About")));

        //Нажимаем на кнопку бабочку
        ViewInteraction appCompatImageButton3 = onView(withId(R.id.our_mission_image_button));
        appCompatImageButton3.check(matches(isDisplayed()));
        appCompatImageButton3.perform(click());

//        Проверяем заголовок страница бабочка
        ViewInteraction textView5 = onView(withId(R.id.our_mission_title_text_view));
        textView5.check(matches(isDisplayed()));
        textView5.check(matches(withText("Love is all")));

        //Нажимаем на кнопку главного меню
        ViewInteraction appCompatImageButton4 = onView(withId(R.id.main_menu_image_button));
        appCompatImageButton4.check(matches(isDisplayed()));
        appCompatImageButton4.perform(click());

        // Проверяем активность строк главного меню
        ViewInteraction textView6 = onView(
                allOf(withId(android.R.id.title), withText("Main"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        textView6.check(matches(withText("Main")));

        ViewInteraction textView7 = onView(
                allOf(withId(android.R.id.title), withText("News"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        textView7.check(matches(withText("News")));

        ViewInteraction textView8 = onView(
                allOf(withId(android.R.id.title), withText("About"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        textView8.check(matches(withText("About")));

        //Нажимаем на кнопку Новости в главном меню
        ViewInteraction materialTextView = onView(
                allOf(withId(android.R.id.title), withText("News"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        materialTextView.perform(click());

//        Проверяем, что открыта страница Новости
        ViewInteraction textView9 = onView(withText("News"));
        textView9.check(matches(isDisplayed()));
        textView9.check(matches(withText("News")));

        //Проверяем видимость кнопок сортировка, фильтр и редактирование
        ViewInteraction compoundButton = onView(withId(R.id.sort_news_material_button));
        compoundButton.check(matches(isDisplayed()));

        ViewInteraction compoundButton2 = onView(withId(R.id.filter_news_material_button));
        compoundButton2.check(matches(isDisplayed()));

        ViewInteraction compoundButton3 = onView(withId(R.id.edit_news_material_button));
        compoundButton3.check(matches(isDisplayed()));

        //Нажимаем на кнопку главного меню
        ViewInteraction appCompatImageButton5 = onView(withId(R.id.main_menu_image_button));
        appCompatImageButton5.check(matches(isDisplayed()));
        appCompatImageButton5.perform(click());

        // Проверяем активность строк главного меню
        ViewInteraction textView10 = onView(
                allOf(withId(android.R.id.title), withText("Main"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        textView10.check(matches(withText("Main")));

        ViewInteraction textView11 = onView(
                allOf(withId(android.R.id.title), withText("News"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        textView11.check(matches(withText("News")));

        ViewInteraction textView12 = onView(
                allOf(withId(android.R.id.title), withText("About"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        textView12.check(matches(withText("About")));

        // Нажимаем на кнопку About
        ViewInteraction materialTextView2 = onView(
                allOf(withId(android.R.id.title), withText("About"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        materialTextView2.perform(click());

//       Проверяем видимость ссылок
        ViewInteraction textView13 = onView(withId(R.id.about_privacy_policy_label_text_view));
        textView13.check(matches(isDisplayed()));
        textView13.check(matches(withText("Privacy Policy:")));

        ViewInteraction textView14 = onView(withId(R.id.about_terms_of_use_label_text_view));
        textView14.check(matches(isDisplayed()));
        textView14.check(matches(withText("Terms of use:")));

//        Нажимаем на кнопку назад
        ViewInteraction appCompatImageButton6 = onView(withId(R.id.about_back_image_button));
        appCompatImageButton6.check(matches(isDisplayed()));
        appCompatImageButton6.perform(click());

        //Проверяем, что открыта страница главного меню
        ViewInteraction textView15 = onView(
                allOf(withText("News"),
                        withParent(withParent(withId(R.id.container_list_news_include_on_fragment_main))),
                        isDisplayed()));
        textView15.check(matches(withText("News")));

//        Выходим из приложения
        ViewInteraction appCompatImageButton7 = onView(withId(R.id.authorization_image_button));
        appCompatImageButton7.check(matches(isDisplayed()));
        appCompatImageButton7.perform(click());

        ViewInteraction materialTextView3 = onView(withId(android.R.id.title));
        materialTextView3.check(matches(isDisplayed()));
        materialTextView3.perform(click());

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
