package org.apache.pdfbox.pdmodel.font;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.ResourceCache;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class PDFontFactorycreateFont_LogerrorFikaTest {

    @Test
    public void testCreateFontTriggersLogError() throws IOException {
        // Create a COSDictionary that will cause the LOG.error() call
        // The dictionary must NOT have TYPE=FONT to trigger the error log
        COSDictionary dictionary = new COSDictionary();
        // Set TYPE to something other than COSName.FONT
        dictionary.setItem(COSName.TYPE, COSName.CATALOG);
        
        // ResourceCache can be null as per method documentation
        ResourceCache resourceCache = null;
        
        // Call the entry point method - this should trigger LOG.error()
        PDFontFactory.createFont(dictionary, resourceCache);
    }
}
