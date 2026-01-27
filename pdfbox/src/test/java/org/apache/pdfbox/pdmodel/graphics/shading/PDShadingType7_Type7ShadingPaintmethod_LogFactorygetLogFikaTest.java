package org.apache.pdfbox.pdmodel.graphics.shading;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDShadingType7_Type7ShadingPaintmethod_LogFactorygetLogFikaTest {

    @Test
    void testToPaintTriggersLogFactoryGetLog() {
        COSDictionary mockDict = Mockito.mock(COSDictionary.class);
        PDShadingType7 shading = new PDShadingType7(mockDict);
        Matrix matrix = new Matrix();
        
        shading.toPaint(matrix);
    }
}
