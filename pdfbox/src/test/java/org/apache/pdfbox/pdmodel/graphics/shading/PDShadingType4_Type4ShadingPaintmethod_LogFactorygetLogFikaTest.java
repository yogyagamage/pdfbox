package org.apache.pdfbox.pdmodel.graphics.shading;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;

class PDShadingType4_Type4ShadingPaintmethod_LogFactorygetLogFikaTest {

    @Test
    void testToPaintTriggersLogFactoryGetLog() {
        COSDictionary mockDict = mock(COSDictionary.class);
        PDShadingType4 shading = new PDShadingType4(mockDict);
        Matrix matrix = new Matrix();
        
        shading.toPaint(matrix);
    }
}
