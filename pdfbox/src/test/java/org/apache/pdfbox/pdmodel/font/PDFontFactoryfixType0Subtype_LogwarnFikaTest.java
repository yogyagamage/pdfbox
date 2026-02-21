package org.apache.pdfbox.pdmodel.font;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDFontFactoryfixType0Subtype_LogwarnFikaTest {

    @Test
    void testFixType0Subtype() throws Exception {
        COSDictionary descendantFont = new COSDictionary();
        COSDictionary fontDescriptor = new COSDictionary();
        
        fontDescriptor.setItem(COSName.FONT_NAME, COSName.getPDFName("TestFont"));
        
        descendantFont.setItem(COSName.SUBTYPE, COSName.CID_FONT_TYPE0);
        
        java.lang.reflect.Method method = Class.forName("org.apache.pdfbox.pdmodel.font.PDFontFactory")
                .getDeclaredMethod("fixType0Subtype", COSDictionary.class, COSDictionary.class, COSName.class);
        method.setAccessible(true);
        
        method.invoke(null, descendantFont, fontDescriptor, COSName.CID_FONT_TYPE0);
    }
}
