package org.apache.pdfbox.util;

import org.junit.jupiter.api.Test;
import java.util.Calendar;

public class DateConverterparseBigEndianDate_LogdebugFikaTest {

    @Test
    public void testToCalendarTriggersLogDebug() {
        // This input will cause parseBigEndianDate to throw IllegalArgumentException
        // when creating the GregorianCalendar, which triggers LOG.debug() call
        String text = "1970 13 32 25 61 61"; // Invalid month, day, hour, minute, second
        
        // Execute the entry point method
        Calendar result = DateConverter.toCalendar(text);
        
        // No assertions - test passes if no exception is thrown during execution
        // The goal is to reach Log.debug() call in parseBigEndianDate
    }
}
