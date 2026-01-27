package org.apache.pdfbox.pdmodel.graphics.shading;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDShadingType3_RadialShadingPaintmethod_LogFactorygetLogFikaTest {

    @Test
    void testToPaintTriggersLogFactoryGetLog() {
        COSDictionary mockDict = Mockito.mock(COSDictionary.class);
        PDShadingType3 shading = new PDShadingType3(mockDict);
        Matrix matrix = new Matrix();
        
        shading.toPaint(matrix);
    }
}
