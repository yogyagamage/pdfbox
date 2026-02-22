package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDAnnotationInk_PDInkAppearanceHandlermethod_LogFactorygetLogFikaTest {

    @Test
    void testConstructAppearancesTriggersLogFactoryGetLog() throws Exception {
        PDDocument document = Mockito.mock(PDDocument.class);
        PDAnnotationInk annotation = new PDAnnotationInk();
        
        annotation.constructAppearances(document);
    }
}
