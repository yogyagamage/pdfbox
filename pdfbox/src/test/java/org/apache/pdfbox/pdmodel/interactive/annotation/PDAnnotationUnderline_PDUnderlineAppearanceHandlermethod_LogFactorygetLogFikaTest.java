package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.annotation.handlers.PDAppearanceHandler;
import org.apache.pdfbox.pdmodel.interactive.annotation.handlers.PDUnderlineAppearanceHandler;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

class PDAnnotationUnderline_PDUnderlineAppearanceHandlermethod_LogFactorygetLogFikaTest {

    @Test
    void testConstructAppearancesTriggersLogFactoryGetLog() throws Exception {
        // Create a mock PDDocument to satisfy constructor requirements
        PDDocument mockDocument = mock(PDDocument.class);
        
        // Create instance using the no-arg constructor
        PDAnnotationUnderline annotation = new PDAnnotationUnderline();
        
        // Ensure customAppearanceHandler is null so the path goes through PDUnderlineAppearanceHandler
        annotation.setCustomAppearanceHandler(null);
        
        // This call should trigger the static initialization of PDUnderlineAppearanceHandler
        // which calls LogFactory.getLog(PDUnderlineAppearanceHandler.class)
        annotation.constructAppearances(mockDocument);
    }
}
