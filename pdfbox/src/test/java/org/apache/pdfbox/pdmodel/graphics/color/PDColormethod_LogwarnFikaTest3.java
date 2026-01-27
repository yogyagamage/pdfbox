package org.apache.pdfbox.pdmodel.graphics.color;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSNumber;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PDColormethod_LogwarnFikaTest3 {

    @Test
    public void testEntryPointToThirdPartyMethod() {
        // Create a COSArray where the last element is NOT a COSName
        // This will trigger the LOG.warn() call in the constructor
        COSArray array = mock(COSArray.class);
        when(array.size()).thenReturn(2);
        
        // First element should be a COSNumber to avoid initComponents() warning
        COSNumber cosNumber = mock(COSNumber.class);
        when(cosNumber.floatValue()).thenReturn(0.0f);
        
        // Last element should NOT be a COSName to trigger the warning path
        COSBase nonCosName = mock(COSBase.class);
        
        when(array.get(0)).thenReturn(cosNumber);
        when(array.get(1)).thenReturn(nonCosName);
        
        // Mock PDColorSpace
        PDColorSpace colorSpace = mock(PDColorSpace.class);
        
        // Create PDColor instance - this should trigger LOG.warn() 
        // when pattern name isn't a COSName
        new PDColor(array, colorSpace);
    }
}
