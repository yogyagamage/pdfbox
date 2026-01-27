package org.apache.pdfbox.pdmodel.graphics.image;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.apache.pdfbox.pdmodel.graphics.image.PDImage;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSNumber;
import java.awt.Paint;
import java.awt.Color;
import java.io.IOException;

class SampledImageReadergetDecodeArray_LogwarnFikaTest2 {

    @Test
    void testGetStencilImageTriggersLogWarn() throws IOException {
        PDImage pdImage = Mockito.mock(PDImage.class);
        Paint paint = Color.BLACK;
        
        PDColorSpace colorSpace = Mockito.mock(PDColorSpace.class);
        Mockito.when(pdImage.getColorSpace()).thenReturn(colorSpace);
        Mockito.when(colorSpace.getNumberOfComponents()).thenReturn(3);
        
        COSArray cosDecode = new COSArray();
        COSNumber decode0 = Mockito.mock(COSNumber.class);
        COSNumber decode1 = Mockito.mock(COSNumber.class);
        Mockito.when(decode0.floatValue()).thenReturn(0.5f);
        Mockito.when(decode1.floatValue()).thenReturn(0.7f);
        
        cosDecode.add(decode0);
        cosDecode.add(decode1);
        
        Mockito.when(pdImage.getDecode()).thenReturn(cosDecode);
        Mockito.when(pdImage.isStencil()).thenReturn(true);
        
        Mockito.when(pdImage.getWidth()).thenReturn(8);
        Mockito.when(pdImage.getHeight()).thenReturn(8);
        Mockito.when(pdImage.getBitsPerComponent()).thenReturn(1);
        
        Mockito.when(pdImage.createInputStream()).thenReturn(
            new java.io.ByteArrayInputStream(new byte[8])
        );
        
        SampledImageReader.getStencilImage(pdImage, paint);
    }
}
