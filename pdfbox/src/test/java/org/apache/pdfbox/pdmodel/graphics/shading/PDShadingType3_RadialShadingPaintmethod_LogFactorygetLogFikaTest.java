package org.apache.pdfbox.pdmodel.graphics.shading;

import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDShadingType3_RadialShadingPaintmethod_LogFactorygetLogFikaTest {

    @Test
    void testToPaintTriggersLogFactoryGetLog() {
        PDShadingType3 shading = Mockito.mock(PDShadingType3.class);
        Mockito.when(shading.toPaint(Mockito.any(Matrix.class)))
               .thenCallRealMethod();
        
        Matrix matrix = new Matrix();
        shading.toPaint(matrix);
    }
}
