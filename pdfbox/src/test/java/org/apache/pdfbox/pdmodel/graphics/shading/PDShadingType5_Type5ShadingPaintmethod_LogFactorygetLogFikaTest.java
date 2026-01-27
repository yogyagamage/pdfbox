package org.apache.pdfbox.pdmodel.graphics.shading;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDShadingType5_Type5ShadingPaintmethod_LogFactorygetLogFikaTest {

    @Test
    void testToPaintTriggersLogFactoryGetLog() {
        COSDictionary mockDictionary = Mockito.mock(COSDictionary.class);
        PDShadingType5 shadingType5 = new PDShadingType5(mockDictionary);
        Matrix matrix = new Matrix();
        
        shadingType5.toPaint(matrix);
    }
}
