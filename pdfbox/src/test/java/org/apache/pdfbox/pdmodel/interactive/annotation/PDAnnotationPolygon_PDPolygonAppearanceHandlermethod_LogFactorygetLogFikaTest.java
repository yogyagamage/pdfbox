package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PDAnnotationPolygon_PDPolygonAppearanceHandlermethod_LogFactorygetLogFikaTest {

    @Test
    public void testConstructAppearancesTriggersStaticInitializer() throws Exception {
        PDDocument document = Mockito.mock(PDDocument.class);
        PDAnnotationPolygon annotation = new PDAnnotationPolygon();
        
        annotation.constructAppearances(document);
    }
}
