package org.apache.pdfbox.pdmodel.graphics.shading;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.ColorModel;
import java.awt.RenderingHints;
import org.apache.pdfbox.pdmodel.graphics.shading.PDShadingType4;
import org.apache.pdfbox.util.Matrix;

class Type4ShadingPaint_Type4ShadingContextmethod_LogdebugFikaTest {

    @Test
    void testCreateContextTriggersLogDebug() throws Exception {
        PDShadingType4 shading = Mockito.mock(PDShadingType4.class);
        Mockito.when(shading.getBitsPerFlag()).thenReturn(8);
        Mockito.when(shading.collectTriangles(Mockito.any(), Mockito.any()))
               .thenReturn(new java.util.ArrayList<>());

        Type4ShadingPaint paint = new Type4ShadingPaint(shading, new Matrix());

        ColorModel cm = ColorModel.getRGBdefault();
        Rectangle deviceBounds = new Rectangle(0, 0, 100, 100);
        Rectangle2D userBounds = new Rectangle2D.Double(0, 0, 100, 100);
        AffineTransform xform = new AffineTransform();
        RenderingHints hints = new RenderingHints(null);

        paint.createContext(cm, deviceBounds, userBounds, xform, hints);
    }
}
