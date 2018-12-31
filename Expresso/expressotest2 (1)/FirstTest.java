package com.wolfenterprisesllc.expressotest2;

//https://www.youtube.com/watch?v=sDp8JNbITm4
//https://developer.android.com/reference/android/support/test/espresso/matcher/ViewMatchers.html



import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)//uses j unit testing software
@LargeTest//has many rest cases inside
@FixMethodOrder(MethodSorters.NAME_ASCENDING)//annotation that says this line  sorts names ascending order

public class FirstTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);//starts execution with main activity then app launches
//comstructor

    @Before
    public void setUp() throws Exception {
        //Before Test case execution for example any test case , config, set-up, or initialization
    }

    @Test   //this is where you put what you want to test arguments
    public void test1ChatId() {
        onView(withText("Hello World")).check(matches(isDisplayed()));
    }
    //http://adventuresinqa.com/2015/04/16/espresso-cheat-sheet/
    //.perform(typeText("Espresso"), closeSoftKeyboard())          closesSoftKeyboard
    //.check(matches(withText(containsString("Espresso"))));       containsString
    //be sure to end it all with a semicolon

    @After
    public void tearDown() throws Exception {
        //After Test case Execution for example whatever....close app and/or relaunch
    }
}

//after running the test if you have a green bar o the bottom left and it says test ran to completion
//then the test passed.


/*

//Perform click event on a view that is a sibling
 of another view
onView(allOf(withText("Espresso"),        ...object matcher(user property(String),
            hasSibling(withText("sibling item: 10"))))   .....hierarchy(user property(String))))
.perform(click());         ...........ViewAction

//Check that text in view with id R.id.et_name
 contains text "Espresso"
onView(withId(R.id.et_name))     ......User Property(what you are looking for))
.check(matches(withText(containsString("Espresso"))));      .////View Assertion(User Property("containsString" is not listed(the String))));


//Perform click event on view with id R.id.btn_login
onView(withId(R.id.btn_login))         .......user Property(What you are looking for))
.perform(click());            ......View Action/Click-Press


//Type text in view with id R.id.et_name
onView(withId(R.id.et_name))    .....user Property(what you are looking for))
.perform(typeText("Espresso"), closeSoftKeyboard());         .....View Action/Text(what you want it to type into the field as a String), close Soft Keyboard is not listed


//Asserting that a view is not present
onView(withId(R.id.btn_login))      ......User Property(what you are looking into))
.check(doesNotExist());    ...........View Assertion

//view that might have been rendered using WindowManager
onView(withText("Espresso"))    ......User Property(the text you are looking for as a String))
.inRoot(withDecorView(            .......****none of this is listed
       not(is(getActivity().getWindow().getDecorView()))))    .....object matcher(object matcher(i think this is actually the location site))))
.perform(click());

ADAPTER VIEW TESTS
//To test AdapterView, Espresso provides a separate onData() entry point which first brings the adapter item to be tested in focus
before performing any operation on itself or its children. So in case we want to test an AdapterView, we need to use the onData() method
instead of the onView() method.

//finds a list item of type String matching the word “Espresso” and performing a click()  event on it:
onData(allOf(is(instanceOf(String.class)), ("Espresso")))   .....object matcher(object matcher(object matcher(where to look, String you are looking for)))
.perform(click());       .....View Action/Click-Press

//find the list item having content “item content: 10” and perform a click event on its child view having id R.id.item_id:
onData(withItemContent("item content: 10"))   ....not listed(the String you are looking for))
.onChildView(withId(R.id.item_id))        ....data options(user property(where it is))
.perform(click());     ....view action/click-press

RECYCLER VIEW TESTS
****cannot use onData() to test RecyclerView objects
*****add the ‘com.android.support.test.espresso:espresso-contrib:2.2.2’ dependency in app/build.gradle
*****scrollTo() – This RecyclerViewActions scrolls to the matched View.
    scrollToHolder() – This RecyclerViewActions scrolls to the matched View Holder.
    scrollToPosition() – This RecyclerViewActions scrolls to a specific position.
    actionOnHolderItem() – This RecyclerViewActions performs a View Action on a matched View Holder.
    actionOnItem() – This RecyclerViewActions performs a View Action on a matched View.
    actionOnItemAtPosition() –  This RecyclerViewActions performs a ViewAction on a view at a specific position.




 */