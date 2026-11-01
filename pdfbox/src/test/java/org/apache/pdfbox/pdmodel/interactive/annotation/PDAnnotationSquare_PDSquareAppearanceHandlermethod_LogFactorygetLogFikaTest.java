package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationSquare;
import org.apache.pdfbox.pdmodel.interactive.annotation.handlers.PDSquareAppearanceHandler;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class PDAnnotationSquare_PDSquareAppearanceHandlermethod_LogFactorygetLogFikaTest {

    @Test
    public void testLogFactoryGetLogInvocation() throws IOException {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);
            
            PDAnnotationSquare annotation = new PDAnnotationSquare();
            annotation.setRectangle(new PDRectangle(100, 100, 200, 100));
            
            PDSquareAppearanceHandler handler = new PDSquareAppearanceHandler(annotation, document);
            
            // This will trigger the static initialization of PDSquareAppearanceHandler
            // which calls LogFactory.getLog(PDSquareAppearanceHandler.class)
            handler.generateAppearanceStreams();
        }
    }
}
