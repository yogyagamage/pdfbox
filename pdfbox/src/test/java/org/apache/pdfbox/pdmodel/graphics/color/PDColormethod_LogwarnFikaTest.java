package org.apache.pdfbox.pdmodel.graphics.color;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class PDColormethod_LogwarnFikaTest {

    @Test
    public void testLogWarnInvocation() throws IOException {
        // Create a COSArray that will trigger the warning path
        COSArray array = new COSArray();
        // Add at least one element that is NOT a COSName at the last position
        array.add(COSName.getPDFName("SomeName"));
        array.add(new COSArray()); // Last element is COSArray, not COSName
        
        // Mock PDColorSpace as it's required for constructor but not directly related to the warning
        PDColorSpace colorSpace = Mockito.mock(PDColorSpace.class);
        
        // This should trigger the warning when the last element is not a COSName
        new PDColor(array, colorSpace);
    }
}
