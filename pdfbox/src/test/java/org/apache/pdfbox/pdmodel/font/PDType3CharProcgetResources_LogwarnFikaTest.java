package org.apache.pdfbox.pdmodel.font;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.font.PDType3CharProc;
import org.apache.pdfbox.pdmodel.font.PDType3Font;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class PDType3CharProcgetResources_LogwarnFikaTest {

    @Test
    public void testGetResourcesTriggersLogWarn() throws IOException {
        // Create a mock font that will be used as fallback
        PDType3Font mockFont = Mockito.mock(PDType3Font.class);
        Mockito.when(mockFont.getResources()).thenReturn(new PDResources());
        
        // Create a COSStream that contains RESOURCES key
        COSStream charStream = Mockito.mock(COSStream.class);
        COSDictionary resourcesDict = new COSDictionary();
        Mockito.when(charStream.containsKey(COSName.RESOURCES)).thenReturn(true);
        Mockito.when(charStream.getCOSDictionary(COSName.RESOURCES)).thenReturn(resourcesDict);
        
        // Create the object under test
        PDType3CharProc charProc = new PDType3CharProc(mockFont, charStream);
        
        // This should trigger the LOG.warn calls
        charProc.getResources();
    }
}
