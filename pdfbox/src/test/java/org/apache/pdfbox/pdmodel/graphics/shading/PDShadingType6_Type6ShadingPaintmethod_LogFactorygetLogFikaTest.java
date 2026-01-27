package org.apache.pdfbox.pdmodel.graphics.shading;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDShadingType6_Type6ShadingPaintmethod_LogFactorygetLogFikaTest {

    @Test
    void testToPaintTriggersLogFactoryGetLog() {
        COSDictionary mockDictionary = Mockito.mock(COSDictionary.class);
        PDShadingType6 shading = new PDShadingType6(mockDictionary);
        Matrix matrix = new Matrix();
        
        shading.toPaint(matrix);
    }
}
