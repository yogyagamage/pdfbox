package org.apache.pdfbox.pdmodel.font;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;
import java.io.IOException;

class PDFontFactorycreateFont_LogwarnFikaTest {

    @Test
    void testCreateFont_TriggersLogWarn() throws IOException {
        // Create a dictionary with an invalid subtype to trigger the LOG.warn call
        COSDictionary fontDict = new COSDictionary();
        fontDict.setItem(COSName.TYPE, COSName.FONT);
        fontDict.setItem(COSName.SUBTYPE, COSName.getPDFName("InvalidSubtype"));
        
        // Execute the method - this should reach the LOG.warn() call
        PDFontFactory.createFont(fontDict, null);
    }
}
