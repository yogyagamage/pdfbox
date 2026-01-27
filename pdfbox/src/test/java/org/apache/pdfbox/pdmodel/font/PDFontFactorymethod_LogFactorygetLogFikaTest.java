package org.apache.pdfbox.pdmodel.font;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PDFontFactorymethod_LogFactorygetLogFikaTest {

    @Test
    public void testCreateFontTriggersStaticInitializer() throws Exception {
        // Create a minimal COSDictionary with required structure
        COSDictionary fontDict = new COSDictionary();
        fontDict.setItem(COSName.TYPE, COSName.FONT);
        fontDict.setItem(COSName.SUBTYPE, COSName.TYPE1);
        
        // This call will trigger static initialization of PDFontFactory
        // which includes LogFactory.getLog(PDFontFactory.class)
        PDFontFactory.createFont(fontDict);
    }
}
