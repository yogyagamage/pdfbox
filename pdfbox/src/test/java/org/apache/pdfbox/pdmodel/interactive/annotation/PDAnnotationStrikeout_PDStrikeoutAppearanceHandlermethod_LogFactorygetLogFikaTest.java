package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationStrikeout;
import org.apache.pdfbox.pdmodel.interactive.annotation.handlers.PDStrikeoutAppearanceHandler;
import org.junit.jupiter.api.Test;

class PDAnnotationStrikeout_PDStrikeoutAppearanceHandlermethod_LogFactorygetLogFikaTest {

    @Test
    void testGetLogInvocation() throws Exception {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);
            
            PDAnnotationStrikeout annotation = new PDAnnotationStrikeout();
            annotation.setRectangle(new PDRectangle(100, 100, 200, 50));
            
            PDStrikeoutAppearanceHandler handler = new PDStrikeoutAppearanceHandler(annotation, document);
            
            // This will trigger the static initialization of PDStrikeoutAppearanceHandler
            // which calls LogFactory.getLog(PDStrikeoutAppearanceHandler.class)
            handler.generateAppearanceStreams();
        }
    }
}
