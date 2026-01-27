package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.annotation.handlers.PDAppearanceHandler;
import org.apache.pdfbox.pdmodel.interactive.annotation.handlers.PDHighlightAppearanceHandler;
import org.junit.jupiter.api.Test;

class PDAnnotationHighlight_PDHighlightAppearanceHandlermethod_LogFactorygetLogFikaTest {

    @Test
    void testConstructAppearancesTriggersLogFactoryGetLog() throws Exception {
        // Create a real PDDocument
        PDDocument document = new PDDocument();
        
        // Create annotation using default constructor
        PDAnnotationHighlight annotation = new PDAnnotationHighlight();
        
        // Ensure customAppearanceHandler is null to take the desired path
        annotation.setCustomAppearanceHandler(null);
        
        // This call should trigger static initialization of PDHighlightAppearanceHandler
        // which calls LogFactory.getLog(PDHighlightAppearanceHandler.class)
        annotation.constructAppearances(document);
        
        // Clean up
        document.close();
    }
}
