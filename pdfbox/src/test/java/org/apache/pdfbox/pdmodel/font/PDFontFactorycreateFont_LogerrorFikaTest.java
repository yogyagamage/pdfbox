package org.apache.pdfbox.pdmodel.font;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.ResourceCache;
import org.junit.jupiter.api.Test;

class PDFontFactorycreateFont_LogerrorFikaTest {

    @Test
    void testCreateFontTriggersLogError() throws Exception {
        // Create a dictionary that will trigger the error log
        COSDictionary dictionary = new COSDictionary();
        // Set TYPE to something other than COSName.FONT to trigger the error log
        dictionary.setItem(COSName.TYPE, COSName.CATALOG);
        
        ResourceCache resourceCache = null;
        
        // This should trigger LOG.error() when TYPE is not COSName.FONT
        PDFontFactory.createFont(dictionary, resourceCache);
    }
}
