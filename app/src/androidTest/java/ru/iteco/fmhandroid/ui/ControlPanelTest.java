package ru.iteco.fmhandroid.ui;


import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.longClick;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.isDialog;
import static androidx.test.espresso.matcher.RootMatchers.isPlatformPopup;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ControlPanelTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Test
    public void addNewsInControlPanelTest() {
        waitForView(R.id.all_news_text_view, 15000);
        ViewInteraction materialTextView = onView(withId(R.id.all_news_text_view));
        materialTextView.check(matches(isDisplayed()));
        materialTextView.perform(click());

        ViewInteraction materialButton = onView(withId(R.id.edit_news_material_button));
        materialButton.check(matches(isDisplayed()));
        materialButton.perform(click());

        ViewInteraction textView = onView(withText("Control panel"));
        textView.check(matches(isDisplayed()));
        textView.check(matches(withText("Control panel")));

        ViewInteraction materialButton2 = onView(withId(R.id.add_news_image_view));
        materialButton2.check(matches(isDisplayed()));
        materialButton2.perform(click());

        ViewInteraction textView2 = onView(withId(R.id.custom_app_bar_title_text_view));
        textView2.check(matches(isDisplayed()));
        textView2.check(matches(withText("Creating")));

        selectFromDropdown("Объявление");

        ViewInteraction textInputEditText3 = onView(withId(R.id.news_item_title_text_input_edit_text));
        textInputEditText3.check(matches(isDisplayed()));
        textInputEditText3.perform(replaceText("New"));

        ViewInteraction editText2 = onView(withId(R.id.news_item_title_text_input_edit_text));
        editText2.check(matches(isDisplayed()));
        editText2.check(matches(withText("New")));

        ViewInteraction textInputEditText5 = onView(withId(R.id.news_item_publish_date_text_input_edit_text));
        textInputEditText5.check(matches(isDisplayed()));
        textInputEditText5.perform(click());

        ViewInteraction materialButton3 = onView(withId(android.R.id.button1));
        materialButton3.check(matches(isDisplayed()));
        materialButton3.perform(scrollTo(), click());

        ViewInteraction textInputEditText6 = onView(withId(R.id.news_item_publish_time_text_input_edit_text));
        textInputEditText6.check(matches(isDisplayed()));
        textInputEditText6.perform(click());

        ViewInteraction materialButton4 = onView(withId(android.R.id.button1));
        materialButton4.check(matches(isDisplayed()));
        materialButton4.perform(scrollTo(), click());

        ViewInteraction textInputEditText8 = onView(withId(R.id.news_item_description_text_input_edit_text));
        textInputEditText8.check(matches(isDisplayed()));
        textInputEditText8.perform(replaceText("New notes"));

        ViewInteraction editText4 = onView(withId(R.id.news_item_description_text_input_edit_text));
        editText4.check(matches(isDisplayed()));
        editText4.check(matches(withText("New notes")));

        ViewInteraction materialButton6 = onView(withId(R.id.save_button));
        materialButton6.check(matches(isDisplayed()));
        materialButton6.perform(scrollTo(), click());

        ViewInteraction textView3 = onView(withText("Control panel"));
        textView3.check(matches(isDisplayed()));
        textView3.check(matches(withText("Control panel")));

        ViewInteraction materialButton7 = onView(withId(R.id.sort_news_material_button));
        materialButton7.check(matches(isDisplayed()));
        materialButton7.perform(click());

        ViewInteraction textView4 = onView(withText("New"));
        textView4.check(matches(isDisplayed()));
        textView4.check(matches(withText("New")));

        ViewInteraction appCompatImageButton = onView(withId(R.id.main_menu_image_button));
        appCompatImageButton.check(matches(isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction materialTextView3 = onView(withText("News"));
        materialTextView3.check(matches(isDisplayed()));
        materialTextView3.perform(click());

        ViewInteraction viewGroup = onView(withId(R.id.all_news_cards_block_constraint_layout));
        viewGroup.check(matches(isDisplayed()));

        ViewInteraction textView5 = onView(withText("New"));
        textView5.check(matches(isDisplayed()));
        textView5.check(matches(withText("New")));
    }

    private void selectFromDropdown(String text) {
        // Кликаем на поле ввода
        onView(withId(R.id.news_item_category_text_auto_complete_text_view))
                .perform(click());

        // Ждем появления списка
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Ищем элемент по тексту
        onView(withText(text))
                .inRoot(isPlatformPopup())
                .check(matches(isDisplayed()))
                .perform(click());
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
