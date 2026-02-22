package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDAnnotationPolyline_PDPolylineAppearanceHandlermethod_LogFactorygetLogFikaTest {

    @Test
    void testConstructAppearancesTriggersStaticInitializer() throws Exception {
        PDDocument document = Mockito.mock(PDDocument.class);
        PDAnnotationPolyline annotation = new PDAnnotationPolyline();
        
        annotation.constructAppearances(document);
    }
}
