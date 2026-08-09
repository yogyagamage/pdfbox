package org.apache.pdfbox.cos;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.util.DateConverter;
import org.junit.jupiter.api.Test;
import java.util.Calendar;

public class COSDictionary_DateConvertermethod_LogFactorygetLogFikaTest {

    @Test
    public void testGetDateTriggersLogFactoryGetLog() {
        // Create COSDictionary instance using default constructor
        COSDictionary dictionary = new COSDictionary();
        
        // Create a COSString with a valid date format to ensure DateConverter.toCalendar is called
        // PDF date format: "D:YYYYMMDDHHmmSSOHH'mm"
        COSString dateString = new COSString("D:20230101120000+00'00'");
        
        // Add the date string to the dictionary with a key
        dictionary.setItem(COSName.DATE, dateString);
        
        // Create a default calendar (can be null or any Calendar instance)
        Calendar defaultValue = Calendar.getInstance();
        
        // Call the entry point method - this should trigger the full chain ending with LogFactory.getLog()
        dictionary.getDate("Date", defaultValue);
    }
}
