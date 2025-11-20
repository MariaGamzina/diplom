package ru.iteco.fmhandroid.ui;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
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
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class FourTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Test
    public void fourTest() {
        ViewInteraction textInputEditText = onView(
                allOf(childAtPosition(
                                childAtPosition(
                                        withId(R.id.login_text_input_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText.perform(replaceText("login2"), closeSoftKeyboard());

        ViewInteraction textInputEditText2 = onView(
                allOf(childAtPosition(
                                childAtPosition(
                                        withId(R.id.password_text_input_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText2.perform(replaceText("password2"), closeSoftKeyboard());

        ViewInteraction materialButton = onView(
                allOf(withId(R.id.enter_button), withText("Sign in"), withContentDescription("Save"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.RelativeLayout")),
                                        1),
                                2),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction appCompatImageButton = onView(
                allOf(withId(R.id.main_menu_image_button), withContentDescription("Main menu"),
                        childAtPosition(
                                allOf(withId(R.id.container_custom_app_bar_include_on_fragment_main),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(android.R.id.title), withText("Main"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        textView.check(matches(withText("Main")));

        ViewInteraction textView2 = onView(
                allOf(withId(android.R.id.title), withText("News"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        textView2.check(matches(withText("News")));

        ViewInteraction appCompatImageButton2 = onView(
                allOf(withId(R.id.main_menu_image_button), withContentDescription("Main menu"),
                        childAtPosition(
                                allOf(withId(R.id.container_custom_app_bar_include_on_fragment_main),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatImageButton2.perform(click());

        ViewInteraction textView3 = onView(
                allOf(withId(android.R.id.title), withText("About"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        textView3.check(matches(withText("About")));

        ViewInteraction appCompatImageButton3 = onView(
                allOf(withId(R.id.our_mission_image_button), withContentDescription("Our Mission"),
                        childAtPosition(
                                allOf(withId(R.id.container_custom_app_bar_include_on_fragment_main),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                0)),
                                6),
                        isDisplayed()));
        appCompatImageButton3.perform(click());

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.our_mission_title_text_view), withText("Love is all"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class))),
                        isDisplayed()));
        textView4.check(matches(withText("Love is all")));

        ViewInteraction appCompatImageButton4 = onView(
                allOf(withId(R.id.main_menu_image_button), withContentDescription("Main menu"),
                        childAtPosition(
                                allOf(withId(R.id.container_custom_app_bar_include_on_fragment_our_mission),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatImageButton4.perform(click());

        ViewInteraction textView5 = onView(
                allOf(withId(android.R.id.title), withText("Main"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        textView5.check(matches(withText("Main")));

        ViewInteraction textView6 = onView(
                allOf(withId(android.R.id.title), withText("News"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        textView6.check(matches(withText("News")));

        ViewInteraction textView7 = onView(
                allOf(withId(android.R.id.title), withText("About"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        textView7.check(matches(withText("About")));

        ViewInteraction materialTextView = onView(
                allOf(withId(android.R.id.title), withText("News"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        materialTextView.perform(click());

        ViewInteraction textView8 = onView(
                allOf(withText("News"),
                        withParent(withParent(withId(R.id.container_list_news_include))),
                        isDisplayed()));
        textView8.check(matches(withText("News")));

        ViewInteraction compoundButton = onView(
                allOf(withId(R.id.sort_news_material_button), withContentDescription("Sort news list button"),
                        withParent(withParent(withId(R.id.container_list_news_include))),
                        isDisplayed()));
        compoundButton.check(matches(isDisplayed()));

        ViewInteraction compoundButton2 = onView(
                allOf(withId(R.id.filter_news_material_button),
                        withParent(withParent(withId(R.id.container_list_news_include))),
                        isDisplayed()));
        compoundButton2.check(matches(isDisplayed()));

        ViewInteraction compoundButton3 = onView(
                allOf(withId(R.id.edit_news_material_button),
                        withParent(withParent(withId(R.id.container_list_news_include))),
                        isDisplayed()));
        compoundButton3.check(matches(isDisplayed()));

        ViewInteraction appCompatImageButton5 = onView(
                allOf(withId(R.id.main_menu_image_button), withContentDescription("Main menu"),
                        childAtPosition(
                                allOf(withId(R.id.container_custom_app_bar_include_on_fragment_news_list),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatImageButton5.perform(click());

        ViewInteraction textView9 = onView(
                allOf(withId(android.R.id.title), withText("Main"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        textView9.check(matches(withText("Main")));

        ViewInteraction textView10 = onView(
                allOf(withId(android.R.id.title), withText("News"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        textView10.check(matches(withText("News")));

        ViewInteraction textView11 = onView(
                allOf(withId(android.R.id.title), withText("About"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        textView11.check(matches(withText("About")));

        ViewInteraction materialTextView2 = onView(
                allOf(withId(android.R.id.title), withText("About"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        materialTextView2.perform(click());

        ViewInteraction materialTextView3 = onView(
                allOf(withId(android.R.id.title), withText("Main"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        materialTextView3.perform(click());

        ViewInteraction appCompatImageButton6 = onView(
                allOf(withId(R.id.main_menu_image_button), withContentDescription("Main menu"),
                        childAtPosition(
                                allOf(withId(R.id.container_custom_app_bar_include_on_fragment_main),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatImageButton6.perform(click());

        ViewInteraction materialTextView4 = onView(
                allOf(withId(android.R.id.title), withText("About"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        materialTextView4.perform(click());

        ViewInteraction textView12 = onView(
                allOf(withId(R.id.about_privacy_policy_label_text_view), withText("Privacy Policy:"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class))),
                        isDisplayed()));
        textView12.check(matches(withText("Privacy Policy:")));

        ViewInteraction textView13 = onView(
                allOf(withId(R.id.about_terms_of_use_label_text_view), withText("Terms of use:"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class))),
                        isDisplayed()));
        textView13.check(matches(withText("Terms of use:")));

        ViewInteraction appCompatImageButton7 = onView(
                allOf(withId(R.id.about_back_image_button),
                        childAtPosition(
                                allOf(withId(R.id.container_custom_app_bar_include_on_fragment_about),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton7.perform(click());

        ViewInteraction textView14 = onView(
                allOf(withText("News"),
                        withParent(withParent(withId(R.id.container_list_news_include_on_fragment_main))),
                        isDisplayed()));
        textView14.check(matches(withText("News")));
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
