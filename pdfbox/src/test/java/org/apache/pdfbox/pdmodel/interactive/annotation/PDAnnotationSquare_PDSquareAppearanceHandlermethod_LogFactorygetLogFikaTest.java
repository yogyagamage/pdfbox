package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationSquare;
import org.apache.pdfbox.pdmodel.interactive.annotation.handlers.PDSquareAppearanceHandler;
import org.junit.jupiter.api.Test;

class PDAnnotationSquare_PDSquareAppearanceHandlermethod_LogFactorygetLogFikaTest {

    @Test
    void testGetLogInvocation() throws Exception {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);
            
            PDAnnotationSquare annotation = new PDAnnotationSquare();
            annotation.setRectangle(new PDRectangle(100, 100, 200, 100));
            
            PDSquareAppearanceHandler handler = new PDSquareAppearanceHandler(annotation, document);
            handler.generateAppearanceStreams();
        }
    }
}
