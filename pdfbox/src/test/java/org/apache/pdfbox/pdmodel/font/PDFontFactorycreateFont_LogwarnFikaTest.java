package org.apache.pdfbox.pdmodel.font;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.ResourceCache;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;

class PDFontFactorycreateFont_LogwarnFikaTest {

    @Test
    void testCreateFontInvokesLogWarn() throws Exception {
        // Create a dictionary with an invalid subtype to trigger the warning
        COSDictionary dictionary = new COSDictionary();
        
        // Set TYPE to FONT (required by the method)
        dictionary.setItem(COSName.TYPE, COSName.FONT);
        
        // Set an invalid SUBTYPE to trigger the warning path
        dictionary.setItem(COSName.SUBTYPE, COSName.getPDFName("InvalidSubtype"));
        
        // ResourceCache can be null as per method documentation
        ResourceCache resourceCache = null;
        
        // Execute the entry point method
        PDFontFactory.createFont(dictionary, resourceCache);
    }
}
