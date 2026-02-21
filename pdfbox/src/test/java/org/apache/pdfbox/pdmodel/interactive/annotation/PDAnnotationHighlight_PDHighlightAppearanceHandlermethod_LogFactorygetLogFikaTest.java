package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationHighlight;
import org.apache.pdfbox.pdmodel.interactive.annotation.handlers.PDHighlightAppearanceHandler;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class PDAnnotationHighlight_PDHighlightAppearanceHandlermethod_LogFactorygetLogFikaTest {

    @Test
    void testGetLogInvocation() throws IOException {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);
            
            PDAnnotationHighlight annotation = new PDAnnotationHighlight();
            annotation.setRectangle(new PDRectangle(100, 100, 200, 50));
            
            PDHighlightAppearanceHandler handler = new PDHighlightAppearanceHandler(annotation, document);
            handler.generateAppearanceStreams();
        }
    }
}
