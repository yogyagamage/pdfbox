package org.apache.pdfbox.pdmodel.interactive.annotation.handlers;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationHighlight;
import java.io.IOException;

class PDHighlightAppearanceHandlermethod_LogFactorygetLogFikaTest {

    @Test
    void testGetLogInvocation() throws IOException {
        try (PDDocument document = new PDDocument()) {
            PDAnnotation annotation = new PDAnnotationHighlight();
            PDHighlightAppearanceHandler handler = new PDHighlightAppearanceHandler(annotation, document);
            // The static field LOG triggers LogFactory.getLog during class initialization
            // which happens when the class is first referenced
            Class<?> clazz = PDHighlightAppearanceHandler.class;
        }
    }
}
