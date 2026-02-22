package org.apache.pdfbox.pdmodel.font;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.PDResources;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

class PDType3CharProcmethod_LogFactorygetLogFikaTest {

    @Test
    void testGetResourcesTriggersStaticInitializer() throws IOException {
        // Create a mock font that returns a non-null PDResources
        PDType3Font font = Mockito.mock(PDType3Font.class);
        Mockito.when(font.getResources()).thenReturn(new PDResources());
        
        // Create a COSStream that does NOT contain RESOURCES key
        // This ensures font.getResources() is called, but static initializer already ran
        COSStream charStream = Mockito.mock(COSStream.class);
        Mockito.when(charStream.containsKey(COSName.RESOURCES)).thenReturn(false);
        
        // Instantiate PDType3CharProc - this triggers static initializer
        PDType3CharProc proc = new PDType3CharProc(font, charStream);
        
        // Call getResources() - static initializer already executed during construction
        proc.getResources();
    }
}
