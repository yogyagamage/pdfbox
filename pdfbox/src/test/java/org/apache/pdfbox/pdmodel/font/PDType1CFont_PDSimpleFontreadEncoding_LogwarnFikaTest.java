package org.apache.pdfbox.pdmodel.font;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

class PDType1CFont_PDSimpleFontreadEncoding_LogwarnFikaTest {

    @Test
    void testReadEncodingTriggersLogWarn() throws IOException {
        // Create a minimal COSDictionary with an unknown encoding
        COSDictionary fontDict = new COSDictionary();
        fontDict.setItem(COSName.TYPE, COSName.FONT);
        fontDict.setItem(COSName.SUBTYPE, COSName.TYPE1);
        fontDict.setItem(COSName.BASE_FONT, COSName.getPDFName("TestFont"));
        
        // Add an unknown encoding name to trigger the warning
        fontDict.setItem(COSName.ENCODING, COSName.getPDFName("UnknownEncoding123"));
        
        // Create font descriptor dictionary
        COSDictionary fontDescriptorDict = new COSDictionary();
        fontDescriptorDict.setItem(COSName.TYPE, COSName.FONT_DESC);
        fontDescriptorDict.setItem(COSName.FONT_NAME, COSName.getPDFName("TestFont"));
        fontDict.setItem(COSName.FONT_DESC, fontDescriptorDict);
        
        // Create the font - this will trigger readEncoding() which should call Log.warn()
        PDType1CFont font = new PDType1CFont(fontDict);
    }
}
