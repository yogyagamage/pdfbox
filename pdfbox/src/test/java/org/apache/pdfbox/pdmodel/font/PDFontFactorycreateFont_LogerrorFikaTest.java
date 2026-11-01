package org.apache.pdfbox.pdmodel.font;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class PDFontFactorycreateFont_LogerrorFikaTest {

    @Test
    public void testCreateFontTriggersLogError() throws IOException {
        // Create a dictionary with wrong TYPE to trigger the Log.error call
        COSDictionary dictionary = new COSDictionary();
        // Set TYPE to something other than "Font"
        dictionary.setItem(COSName.TYPE, COSName.CATALOG);
        
        // Call the method - this should trigger LOG.error(...) 
        // when the TYPE check fails
        PDFontFactory.createFont(dictionary, null);
    }
}
