package org.apache.pdfbox.cos;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.util.DateConverter;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

public class COSDictionary_DateConvertermethod_LogFactorygetLogFikaTest {

    @Test
    public void testSetDateTriggersLogFactoryGetLog() {
        // Create instance using default constructor
        COSDictionary dictionary = new COSDictionary();
        
        // Create required parameters
        COSName key = COSName.DATE;
        Calendar calendar = Calendar.getInstance();
        
        // This call should trigger:
        // 1. COSDictionary.setDate()
        // 2. DateConverter.toString() which triggers static initialization
        // 3. DateConverter.<clinit>() which calls LogFactory.getLog(DateConverter.class)
        dictionary.setDate(key, calendar);
    }
}
