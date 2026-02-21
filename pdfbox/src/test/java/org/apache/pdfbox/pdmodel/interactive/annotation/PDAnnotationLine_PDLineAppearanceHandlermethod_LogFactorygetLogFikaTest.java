package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLine;
import org.apache.pdfbox.pdmodel.interactive.annotation.handlers.PDLineAppearanceHandler;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class PDAnnotationLine_PDLineAppearanceHandlermethod_LogFactorygetLogFikaTest {

    @Test
    void testGetLogInvocation() throws IOException {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);
            
            PDAnnotationLine lineAnnotation = new PDAnnotationLine();
            lineAnnotation.setRectangle(new PDRectangle(100, 100, 200, 50));
            
            PDLineAppearanceHandler handler = new PDLineAppearanceHandler(lineAnnotation, document);
            handler.generateNormalAppearance();
        }
    }
}
