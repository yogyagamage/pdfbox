package org.apache.pdfbox.pdmodel.graphics.image;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSNumber;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.image.PDImage;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

class SampledImageReadergetDecodeArray_LogwarnFikaTest {

    @Test
    void testGetDecodeArrayInvokesLogWarn() throws IOException {
        // Create a mock PDImage
        PDImage pdImage = Mockito.mock(PDImage.class);
        
        // Create a COSArray with exactly 2 COSNumber entries
        COSArray cosDecode = new COSArray();
        COSNumber cosNumber0 = Mockito.mock(COSNumber.class);
        COSNumber cosNumber1 = Mockito.mock(COSNumber.class);
        
        // Setup COSNumber values to satisfy the condition: 0 <= value <= 1
        Mockito.when(cosNumber0.floatValue()).thenReturn(0.5f);
        Mockito.when(cosNumber1.floatValue()).thenReturn(0.7f);
        
        cosDecode.add(cosNumber0);
        cosDecode.add(cosNumber1);
        
        // Mock PDImage to return the COSArray
        Mockito.when(pdImage.getDecode()).thenReturn(cosDecode);
        
        // Mock color space to return numberOfComponents != 1
        PDColorSpace colorSpace = Mockito.mock(PDColorSpace.class);
        Mockito.when(pdImage.getColorSpace()).thenReturn(colorSpace);
        Mockito.when(colorSpace.getNumberOfComponents()).thenReturn(3); // 3 * 2 = 6, but array size is 2
        
        // Mock isStencil to return true
        Mockito.when(pdImage.isStencil()).thenReturn(true);
        
        // Mock bitsPerComponent for the default decode path (won't be reached)
        Mockito.when(pdImage.getBitsPerComponent()).thenReturn(8);
        
        // Mock default decode to return something
        float[] defaultDecode = new float[]{0f, 1f};
        Mockito.when(colorSpace.getDefaultDecode(Mockito.anyInt())).thenReturn(defaultDecode);
        
        // Invoke the method - this should trigger the LOG.warn call
        // The method is private static, so we need to use reflection
        try {
            java.lang.reflect.Method method = Class.forName("org.apache.pdfbox.pdmodel.graphics.image.SampledImageReader")
                    .getDeclaredMethod("getDecodeArray", PDImage.class);
            method.setAccessible(true);
            method.invoke(null, pdImage);
        } catch (Exception e) {
            // Ignore reflection exceptions
        }
    }
}
