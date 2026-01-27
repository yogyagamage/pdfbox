package org.apache.pdfbox.util;

import org.apache.commons.logging.Log;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

class DateConverterparseBigEndianDate_LogdebugFikaTest {

    @Test
    void testToCalendarTriggersLogDebug() {
        // This input will cause parseBigEndianDate to throw IllegalArgumentException
        // when creating GregorianCalendar with invalid month value (13-1 = 12)
        // which triggers LOG.debug() call
        String invalidDate = "20231301"; // Year: 2023, Month: 13 (invalid), Day: 01
        
        // Call the entry point method
        Calendar result = DateConverter.toCalendar(invalidDate);
        
        // No assertions - test only needs to execute the call chain
        // that leads to Log.debug() being invoked
    }
}
