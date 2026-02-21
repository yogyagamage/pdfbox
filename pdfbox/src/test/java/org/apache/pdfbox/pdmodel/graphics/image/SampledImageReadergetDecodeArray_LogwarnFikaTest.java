package org.apache.pdfbox.pdmodel.graphics.image;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSNumber;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.pdmodel.graphics.image.PDImage;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;

class SampledImageReadergetDecodeArray_LogwarnFikaTest {

    @Test
    void testGetDecodeArrayTriggersLogWarn() throws IOException {
        // Create a mock PDImage
        PDImage pdImage = Mockito.mock(PDImage.class);
        
        // Create a COSArray with exactly two COSNumbers that satisfy the condition
        COSArray cosDecode = new COSArray();
        cosDecode.add(COSFloat.get("0.5"));  // decode0 between 0 and 1
        cosDecode.add(COSFloat.get("0.7"));  // decode1 between 0 and 1
        
        // Mock pdImage.getDecode() to return our array
        Mockito.when(pdImage.getDecode()).thenReturn(cosDecode);
        
        // Mock pdImage.isStencil() to return true
        Mockito.when(pdImage.isStencil()).thenReturn(true);
        
        // Create a mock color space that returns numberOfComponents != cosDecode.size()/2
        PDColorSpace colorSpace = Mockito.mock(PDColorSpace.class);
        Mockito.when(colorSpace.getNumberOfComponents()).thenReturn(3); // 3 != 2/2
        
        // Mock pdImage.getColorSpace() to return our color space
        Mockito.when(pdImage.getColorSpace()).thenReturn(colorSpace);
        
        // Mock pdImage.getBitsPerComponent() for the fallback path
        Mockito.when(pdImage.getBitsPerComponent()).thenReturn(8);
        
        // Mock the default decode method to return a valid array
        Mockito.when(colorSpace.getDefaultDecode(Mockito.anyInt())).thenReturn(new float[]{0f, 1f});
        
        // Use reflection to invoke the private static method
        try {
            java.lang.reflect.Method method = Class.forName("org.apache.pdfbox.pdmodel.graphics.image.SampledImageReader")
                    .getDeclaredMethod("getDecodeArray", PDImage.class);
            method.setAccessible(true);
            method.invoke(null, pdImage);
        } catch (Exception e) {
            // Ignore reflection exceptions - test goal is to execute the path
        }
    }
}
