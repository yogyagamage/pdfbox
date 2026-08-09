package org.apache.pdfbox.pdmodel.font;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.ResourceCache;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDFontFactorycreateFont_LogwarnFikaTest {

    @Test
    void testCreateFontTriggersLogWarn() throws Exception {
        // Create a dictionary with an invalid subtype to trigger the log warning
        COSDictionary dictionary = new COSDictionary();
        dictionary.setItem(COSName.TYPE, COSName.FONT);
        dictionary.setItem(COSName.SUBTYPE, COSName.getPDFName("InvalidSubtype"));
        
        // ResourceCache can be null as per method documentation
        ResourceCache resourceCache = null;
        
        // Invoke the entry point method which should trigger LOG.warn
        PDFontFactory.createFont(dictionary, resourceCache);
    }
}
