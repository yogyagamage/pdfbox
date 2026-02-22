package org.apache.pdfbox.pdmodel.font;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.ResourceCache;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class PDFontFactorycreateFont_LogwarnFikaTest {

    @Test
    public void testCreateFontTriggersLogWarn() throws IOException {
        // Create a dictionary with an invalid subtype to trigger the log.warn path
        COSDictionary fontDict = new COSDictionary();
        fontDict.setItem(COSName.TYPE, COSName.FONT);
        // Set an invalid subtype that doesn't match any known font type
        fontDict.setItem(COSName.SUBTYPE, COSName.getPDFName("InvalidSubtype"));
        
        // ResourceCache can be null as per method documentation
        ResourceCache resourceCache = null;
        
        // This should execute the else branch and call LOG.warn()
        PDFontFactory.createFont(fontDict, resourceCache);
    }
}
