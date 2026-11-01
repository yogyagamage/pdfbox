package org.apache.pdfbox.pdmodel.font;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.ResourceCache;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDFontFactory;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class PDFontFactorycreateFont_LogwarnFikaTest {

    @Test
    void testCreateFont_InvokesLogWarn() throws IOException {
        // Create a dictionary with an invalid subtype to trigger the LOG.warn call
        COSDictionary dictionary = new COSDictionary();
        dictionary.setItem(COSName.TYPE, COSName.FONT);
        dictionary.setItem(COSName.SUBTYPE, COSName.getPDFName("InvalidSubtype"));
        
        ResourceCache resourceCache = null;
        
        // This should execute the else branch and call LOG.warn
        PDFontFactory.createFont(dictionary, resourceCache);
    }
}
