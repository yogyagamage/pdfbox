package org.apache.pdfbox.pdmodel.font;

import org.apache.commons.logging.Log;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.ResourceCache;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class PDFontFactorycreateFont_LogerrorFikaTest {

    @Test
    public void testCreateFontTriggersLogError() throws IOException {
        // Create a COSDictionary that will cause the LOG.error() call
        // The createFont method checks if dictionary.getCOSName(COSName.TYPE, COSName.FONT) equals COSName.FONT
        // We need to create a dictionary where this condition is false
        COSDictionary dictionary = new COSDictionary();
        // Set TYPE to something other than "Font" - using "Page" as an example
        dictionary.setItem(COSName.TYPE, COSName.PAGE);
        
        // ResourceCache can be null as per method documentation
        ResourceCache resourceCache = null;
        
        // Call the entry point method - this should trigger LOG.error() 
        // when the TYPE check fails
        PDFontFactory.createFont(dictionary, resourceCache);
    }
}
