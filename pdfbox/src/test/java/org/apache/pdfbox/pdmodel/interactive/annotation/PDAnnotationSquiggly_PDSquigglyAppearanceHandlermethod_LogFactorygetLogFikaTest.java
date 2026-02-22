package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDAnnotationSquiggly_PDSquigglyAppearanceHandlermethod_LogFactorygetLogFikaTest {

    @Test
    void testConstructAppearancesTriggersStaticInitializer() throws Exception {
        PDDocument document = Mockito.mock(PDDocument.class);
        PDAnnotationSquiggly annotation = new PDAnnotationSquiggly();
        
        annotation.constructAppearances(document);
    }
}
