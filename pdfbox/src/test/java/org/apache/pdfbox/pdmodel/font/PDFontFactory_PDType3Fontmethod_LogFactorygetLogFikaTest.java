package org.apache.pdfbox.pdmodel.font;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.ResourceCache;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;

class PDFontFactory_PDType3Fontmethod_LogFactorygetLogFikaTest {

    @Test
    void testCreateFontTriggersPDType3FontStaticInitializer() throws IOException {
        // Create a COSDictionary with TYPE3 subtype to trigger PDType3Font path
        COSDictionary fontDictionary = new COSDictionary();
        fontDictionary.setItem(COSName.TYPE, COSName.FONT);
        fontDictionary.setItem(COSName.SUBTYPE, COSName.TYPE3);
        
        // Create a mock ResourceCache (required for PDType3Font constructor)
        ResourceCache resourceCache = mock(ResourceCache.class);
        
        // This call should trigger:
        // 1. PDFontFactory.createFont()
        // 2. PDType3Font class initialization (which calls LogFactory.getLog)
        // 3. org.apache.commons.logging.LogFactory.getLog(PDType3Font.class)
        PDFontFactory.createFont(fontDictionary, resourceCache);
    }
}
