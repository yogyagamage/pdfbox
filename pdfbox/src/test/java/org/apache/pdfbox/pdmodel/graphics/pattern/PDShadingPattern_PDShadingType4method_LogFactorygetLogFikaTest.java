package org.apache.pdfbox.pdmodel.graphics.pattern;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.graphics.shading.PDShadingType4;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDShadingPattern_PDShadingType4method_LogFactorygetLogFikaTest {

    @Test
    void testGetShadingTriggersLogFactoryGetLog() throws Exception {
        // Create a mock COSDictionary that will trigger PDShadingType4 creation
        COSDictionary mockShadingDict = Mockito.mock(COSDictionary.class);
        Mockito.when(mockShadingDict.getInt(COSName.SHADING_TYPE, 0)).thenReturn(4);
        
        // Create a mock COSDictionary for the pattern with SHADING entry
        COSDictionary mockPatternDict = Mockito.mock(COSDictionary.class);
        Mockito.when(mockPatternDict.getCOSDictionary(COSName.SHADING)).thenReturn(mockShadingDict);
        
        // Create PDShadingPattern using constructor that accepts COSDictionary
        PDShadingPattern pattern = new PDShadingPattern(mockPatternDict);
        
        // This call should traverse:
        // 1. PDShadingPattern.getShading()
        // 2. PDShading.create(mockShadingDict)
        // 3. PDShadingType4.<clinit>() which calls LogFactory.getLog(PDShadingType4.class)
        pattern.getShading();
    }
}
