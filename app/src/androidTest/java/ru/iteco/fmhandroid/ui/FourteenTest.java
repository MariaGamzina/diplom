package ru.iteco.fmhandroid.ui;


import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

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
public class FourteenTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Test
    public void fourteenTest() {
        ViewInteraction materialTextView = onView(
                allOf(withId(R.id.all_news_text_view), withText("All news"),
                        childAtPosition(
                                allOf(withId(R.id.container_list_news_include_on_fragment_main),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        materialTextView.perform(click());

        ViewInteraction materialButton = onView(
                allOf(withId(R.id.edit_news_material_button),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.container_list_news_include),
                                        0),
                                3),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.add_news_image_view), withContentDescription("Add news button"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                3),
                        isDisplayed()));
        materialButton2.perform(click());

        ViewInteraction checkableImageButton = onView(
                allOf(withId(com.google.android.material.R.id.text_input_end_icon), withContentDescription("Show dropdown menu"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                0),
                        isDisplayed()));
        checkableImageButton.perform(click());

        DataInteraction materialTextView2 = onData(anything())
                .inAdapterView(childAtPosition(
                        withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
                        0))
                .atPosition(0);
        materialTextView2.perform(click());

        ViewInteraction textInputEditText = onView(
                allOf(withId(R.id.news_item_title_text_input_edit_text), withText("Объявление"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.news_item_title_text_input_layout),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText.perform(replaceText("New"));

        ViewInteraction textInputEditText2 = onView(
                allOf(withId(R.id.news_item_title_text_input_edit_text), withText("New"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.news_item_title_text_input_layout),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText2.perform(closeSoftKeyboard());

        ViewInteraction textInputEditText3 = onView(
                allOf(withId(R.id.news_item_publish_date_text_input_edit_text),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.news_item_create_date_text_input_layout),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText3.perform(click());

        ViewInteraction materialButton3 = onView(
                allOf(withId(android.R.id.button1), withText("OK"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        materialButton3.perform(scrollTo(), click());

        ViewInteraction textInputEditText4 = onView(
                allOf(withId(R.id.news_item_publish_time_text_input_edit_text),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.news_item_publish_time_text_input_layout),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText4.perform(click());

        ViewInteraction materialButton4 = onView(
                allOf(withId(android.R.id.button1), withText("OK"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        materialButton4.perform(scrollTo(), click());

        ViewInteraction textInputEditText5 = onView(
                allOf(withId(R.id.news_item_description_text_input_edit_text),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.news_item_description_text_input_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText5.perform(replaceText("New notes"), closeSoftKeyboard());

        ViewInteraction materialButton5 = onView(
                allOf(withId(R.id.save_button), withText("Save"), withContentDescription("Save"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("com.google.android.material.card.MaterialCardView")),
                                        0),
                                6)));
        materialButton5.perform(scrollTo(), click());

        ViewInteraction materialButton6 = onView(
                allOf(withId(R.id.sort_news_material_button),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                1),
                        isDisplayed()));
        materialButton6.perform(click());

        ViewInteraction appCompatImageView = onView(
                allOf(withId(R.id.edit_news_item_image_view), withContentDescription("News editing button"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.news_item_material_card_view),
                                        0),
                                15),
                        isDisplayed()));
        appCompatImageView.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.custom_app_bar_title_text_view), withText("Editing"),
                        withParent(allOf(withId(R.id.container_custom_app_bar_include_on_fragment_create_edit_news),
                                withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class)))),
                        isDisplayed()));
        textView.check(matches(withText("Editing")));

        ViewInteraction checkableImageButton2 = onView(
                allOf(withId(com.google.android.material.R.id.text_input_end_icon), withContentDescription("Show dropdown menu"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                0),
                        isDisplayed()));
        checkableImageButton2.perform(click());

        DataInteraction materialTextView3 = onData(anything())
                .inAdapterView(childAtPosition(
                        withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
                        0))
                .atPosition(1);
        materialTextView3.perform(click());

        ViewInteraction textInputEditText6 = onView(
                allOf(withId(R.id.news_item_title_text_input_edit_text), withText("New"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.news_item_title_text_input_layout),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText6.perform(replaceText("New1"));

        ViewInteraction textInputEditText7 = onView(
                allOf(withId(R.id.news_item_title_text_input_edit_text), withText("New1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.news_item_title_text_input_layout),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText7.perform(closeSoftKeyboard());

        ViewInteraction textInputEditText8 = onView(
                allOf(withId(R.id.news_item_description_text_input_edit_text), withText("New notes"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.news_item_description_text_input_layout),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText8.perform(replaceText("New notes two"));

        ViewInteraction textInputEditText9 = onView(
                allOf(withId(R.id.news_item_description_text_input_edit_text), withText("New notes two"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.news_item_description_text_input_layout),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText9.perform(closeSoftKeyboard());

        ViewInteraction switchMaterial = onView(
                allOf(withId(R.id.switcher), withText("Active"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("com.google.android.material.card.MaterialCardView")),
                                        0),
                                5)));
        switchMaterial.perform(scrollTo(), click());

        ViewInteraction materialButton7 = onView(
                allOf(withId(R.id.cancel_button), withText("Cancel"), withContentDescription("Cancel"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("com.google.android.material.card.MaterialCardView")),
                                        0),
                                7)));
        materialButton7.perform(scrollTo(), click());

        ViewInteraction materialButton8 = onView(
                allOf(withId(android.R.id.button2), withText("Cancel"),
                        childAtPosition(
                                childAtPosition(
                                        withId(com.google.android.material.R.id.buttonPanel),
                                        0),
                                2)));
        materialButton8.perform(scrollTo(), click());

        ViewInteraction materialButton9 = onView(
                allOf(withId(R.id.cancel_button), withText("Cancel"), withContentDescription("Cancel"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("com.google.android.material.card.MaterialCardView")),
                                        0),
                                7)));
        materialButton9.perform(scrollTo(), click());

        ViewInteraction textView2 = onView(
                allOf(withId(android.R.id.message), withText("The changes won't be saved, do you really want to log out?"),
                        withParent(withParent(withId(com.google.android.material.R.id.scrollView))),
                        isDisplayed()));
        textView2.check(matches(withText("The changes won't be saved, do you really want to log out?")));

        ViewInteraction materialButton10 = onView(
                allOf(withId(android.R.id.button2), withText("Cancel"),
                        childAtPosition(
                                childAtPosition(
                                        withId(com.google.android.material.R.id.buttonPanel),
                                        0),
                                2)));
        materialButton10.perform(scrollTo(), click());

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.custom_app_bar_title_text_view), withText("Editing"),
                        withParent(allOf(withId(R.id.container_custom_app_bar_include_on_fragment_create_edit_news),
                                withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class)))),
                        isDisplayed()));
        textView3.check(matches(withText("Editing")));

        ViewInteraction materialButton11 = onView(
                allOf(withId(R.id.save_button), withText("Save"), withContentDescription("Save"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("com.google.android.material.card.MaterialCardView")),
                                        0),
                                6)));
        materialButton11.perform(scrollTo(), click());

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.news_item_title_text_view), withText("New1"),
                        withParent(withParent(withId(R.id.news_item_material_card_view))),
                        isDisplayed()));
        textView4.check(matches(withText("New1")));

        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.news_list_recycler_view),
                        childAtPosition(
                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                0)));
        recyclerView.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction textView5 = onView(
                allOf(withId(R.id.news_item_description_text_view), withText("New notes two"),
                        withParent(withParent(withId(R.id.news_item_material_card_view))),
                        isDisplayed()));
        textView5.check(matches(withText("New notes two")));

        ViewInteraction appCompatImageView2 = onView(
                allOf(withId(R.id.edit_news_item_image_view), withContentDescription("News editing button"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.news_item_material_card_view),
                                        0),
                                15),
                        isDisplayed()));
        appCompatImageView2.perform(click());

        ViewInteraction textView6 = onView(
                allOf(withId(R.id.custom_app_bar_title_text_view), withText("Editing"),
                        withParent(allOf(withId(R.id.container_custom_app_bar_include_on_fragment_create_edit_news),
                                withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class)))),
                        isDisplayed()));
        textView6.check(matches(withText("Editing")));

        ViewInteraction textInputEditText10 = onView(
                allOf(withId(R.id.news_item_description_text_input_edit_text), withText("New notes two"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.news_item_description_text_input_layout),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText10.perform(replaceText("New notes three"));

        ViewInteraction textInputEditText11 = onView(
                allOf(withId(R.id.news_item_description_text_input_edit_text), withText("New notes three"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.news_item_description_text_input_layout),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText11.perform(closeSoftKeyboard());

        ViewInteraction materialButton12 = onView(
                allOf(withId(R.id.cancel_button), withText("Cancel"), withContentDescription("Cancel"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("com.google.android.material.card.MaterialCardView")),
                                        0),
                                7)));
        materialButton12.perform(scrollTo(), click());

        ViewInteraction textView7 = onView(
                allOf(withId(android.R.id.message), withText("The changes won't be saved, do you really want to log out?"),
                        withParent(withParent(withId(com.google.android.material.R.id.scrollView))),
                        isDisplayed()));
        textView7.check(matches(withText("The changes won't be saved, do you really want to log out?")));

        ViewInteraction materialButton13 = onView(
                allOf(withId(android.R.id.button1), withText("OK"),
                        childAtPosition(
                                childAtPosition(
                                        withId(com.google.android.material.R.id.buttonPanel),
                                        0),
                                3)));
        materialButton13.perform(scrollTo(), click());

        ViewInteraction textView8 = onView(
                allOf(withId(R.id.news_item_title_text_view), withText("New1"),
                        withParent(withParent(withId(R.id.news_item_material_card_view))),
                        isDisplayed()));
        textView8.check(matches(withText("New1")));

        ViewInteraction textView9 = onView(
                allOf(withId(R.id.news_item_description_text_view), withText("New notes two"),
                        withParent(withParent(withId(R.id.news_item_material_card_view))),
                        isDisplayed()));
        textView9.check(matches(withText("New notes two")));
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
