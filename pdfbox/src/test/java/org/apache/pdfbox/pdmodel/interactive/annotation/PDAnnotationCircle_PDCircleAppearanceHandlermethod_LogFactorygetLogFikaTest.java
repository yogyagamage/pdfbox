package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCircle;
import org.apache.pdfbox.pdmodel.interactive.annotation.handlers.PDCircleAppearanceHandler;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class PDAnnotationCircle_PDCircleAppearanceHandlermethod_LogFactorygetLogFikaTest {

    @Test
    void testGetLogInvocation() throws IOException {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);
            
            PDAnnotationCircle annotation = new PDAnnotationCircle();
            annotation.setRectangle(new PDRectangle(100, 100, 200, 100));
            
            PDCircleAppearanceHandler handler = new PDCircleAppearanceHandler(annotation, document);
            
            // This will trigger the static initialization of LOG field
            // which calls LogFactory.getLog(PDCircleAppearanceHandler.class)
            handler.generateAppearanceStreams();
        }
    }
}
