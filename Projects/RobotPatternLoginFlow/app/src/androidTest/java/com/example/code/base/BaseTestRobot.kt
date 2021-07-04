package com.example.code.base

import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Matchers

open class BaseTestRobot {

    /** Fill the text in the edit-text field and close the keyboard **/
    fun fillEditText(resId:Int,text:String): ViewInteraction =
        onView(withId(resId))
            .perform(replaceText(text), ViewActions.closeSoftKeyboard())

    /** Perform button click **/
    fun clickButton(resId: Int): ViewInteraction =
        onView((withId(resId)))
            .perform(ViewActions.click())

    fun textView(resId: Int): ViewInteraction =
        onView(withId(resId))

    /** On a view interaction, Check if it matches a text **/
    fun matchText(viewInteraction: ViewInteraction, text: String): ViewInteraction =
        viewInteraction.check(matches(withText(text)))

    fun matchText(resId: Int, text: String): ViewInteraction =
        matchText(textView(resId), text)

    fun clickListItem(listRes: Int, position: Int) {
        onData(Matchers.anything())
            .inAdapterView(allOf(withId(listRes)))
            .atPosition(position).perform(ViewActions.click())
    }

}