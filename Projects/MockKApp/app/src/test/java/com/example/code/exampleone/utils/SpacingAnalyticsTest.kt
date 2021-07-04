package com.example.code.exampleone.utils

import io.mockk.*
import junit.framework.Assert.assertEquals
import org.junit.Test


class SpacingAnalyticsTest {


    @Test
    fun `new analytics events are added before the events are sent`() {

        mockkObject(ThirdPartyAnalyticsProvider)

        // Lets use the combination of slot and capture

        // slot is a capturing tool used to capture the arguments
        val slot = slot<Map<String,String>>()

        every { ThirdPartyAnalyticsProvider.logEvent(any(),capture(slot)) } just Runs

        SpacingAnalytics().logEvent("Test event", mapOf("attribute" to "value"))

        // Now you expect to call the third party analytics with the value you supplied along with other attributes
        val expected = mapOf(
                "attribute" to "value",
                "client_type" to "Android",
                "version" to "1"
        )

        // List of attributes passed to the analytics was captured in the slot previously supplied earlier
        assertEquals(expected,slot.captured)

    }

}