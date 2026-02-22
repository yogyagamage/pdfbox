package org.apache.pdfbox.cos;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class COSDictionary_DateConvertermethod_LogFactorygetLogFikaTest {

    @Test
    public void testSetDateTriggersLogFactoryGetLog() {
        COSDictionary dictionary = new COSDictionary();
        COSName key = COSName.DATE;
        Calendar calendar = new GregorianCalendar();
        
        dictionary.setDate(key, calendar);
    }
}
