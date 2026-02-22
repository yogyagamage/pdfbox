package org.apache.pdfbox.pdmodel.font;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.ResourceCache;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class PDFontFactorymethod_LogFactorygetLogFikaTest2 {

    @Test
    void testCreateFontTriggersStaticInitializer() throws IOException {
        // Create a minimal font dictionary that will trigger the static initializer
        COSDictionary fontDict = new COSDictionary();
        fontDict.setItem(COSName.TYPE, COSName.FONT);
        fontDict.setItem(COSName.SUBTYPE, COSName.TYPE1);
        
        ResourceCache cache = null;
        
        // This call will trigger the static initializer which calls LogFactory.getLog()
        PDFontFactory.createFont(fontDict, cache);
    }
}
