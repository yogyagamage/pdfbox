package org.apache.pdfbox.pdmodel.interactive.annotation.handlers;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationStrikeout;
import java.io.IOException;

class PDStrikeoutAppearanceHandlermethod_LogFactorygetLogFikaTest {

    @Test
    void testLogFactoryGetLogInvocation() throws IOException {
        try (PDDocument document = new PDDocument()) {
            PDAnnotation annotation = new PDAnnotationStrikeout();
            PDStrikeoutAppearanceHandler handler = new PDStrikeoutAppearanceHandler(annotation, document);
            
            // Trigger initialization that causes static field initialization
            // The static field LOG will be initialized when class is loaded/accessed
            Class<?> handlerClass = PDStrikeoutAppearanceHandler.class;
        }
    }
}
