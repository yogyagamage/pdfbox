package org.apache.pdfbox.pdmodel.graphics.shading;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.ColorModel;
import java.awt.RenderingHints;
import org.apache.pdfbox.pdmodel.graphics.shading.PDShadingType5;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;

public class Type5ShadingPaint_Type5ShadingContextmethod_LogdebugFikaTest {

    @Test
    public void testCreateContextTriggersLogDebug() throws Exception {
        PDShadingType5 shading = mock(PDShadingType5.class);
        Type5ShadingPaint paint = new Type5ShadingPaint(shading, new Matrix());
        
        ColorModel cm = ColorModel.getRGBdefault();
        Rectangle deviceBounds = new Rectangle(0, 0, 100, 100);
        Rectangle2D userBounds = new Rectangle2D.Double(0, 0, 100, 100);
        AffineTransform xform = new AffineTransform();
        RenderingHints hints = new RenderingHints(null);
        
        paint.createContext(cm, deviceBounds, userBounds, xform, hints);
    }
}
