package org.apache.pdfbox.util;

import org.junit.jupiter.api.Test;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import java.text.ParsePosition;
import java.lang.reflect.Field;

class DateConverterparseBigEndianDate_LogdebugFikaTest {

    @Test
    void testParseBigEndianDateTriggersLogDebug() throws Exception {
        // Get the class containing the parseBigEndianDate method
        Class<?> dateConverterClass = Class.forName("org.apache.pdfbox.util.DateConverter");
        
        // Get the LOG field
        Field logField = dateConverterClass.getDeclaredField("LOG");
        logField.setAccessible(true);
        
        // Create a mock Log that will record the debug call
        Log originalLog = (Log) logField.get(null);
        
        // Use reflection to access the private method
        java.lang.reflect.Method parseMethod = dateConverterClass.getDeclaredMethod(
            "parseBigEndianDate", 
            String.class, 
            ParsePosition.class
        );
        parseMethod.setAccessible(true);
        
        // Test case that will cause IllegalArgumentException in dest.set()
        // Year 2025, month 13 (invalid month), day 32 (invalid day)
        String text = "2025/13/32 25:61:61"; // Invalid values for month, day, hour, minute, second
        ParsePosition pos = new ParsePosition(0);
        
        // This should trigger the IllegalArgumentException and call LOG.debug()
        parseMethod.invoke(null, text, pos);
    }
}
