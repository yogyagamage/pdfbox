package org.apache.pdfbox.pdmodel.fdf;

import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Element;

public class FDFAnnotationPolylineinitVertices_LogdebugFikaTest {

    @Test
    public void initVerticesShouldInvokeLogDebug() throws Exception {
        FDFAnnotationPolyline annotation = new FDFAnnotationPolyline();
        Method initVertices = FDFAnnotationPolyline.class.getDeclaredMethod("initVertices", Element.class);
        initVertices.setAccessible(true);
        initVertices.invoke(annotation, new Object[] { null });
    }
}
