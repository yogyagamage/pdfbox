package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationSquiggly;
import org.apache.pdfbox.pdmodel.interactive.annotation.handlers.PDSquigglyAppearanceHandler;
import org.junit.jupiter.api.Test;

class PDAnnotationSquiggly_PDSquigglyAppearanceHandlermethod_LogFactorygetLogFikaTest {

    @Test
    void testLogFactoryGetLogInvocation() throws Exception {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);
            
            PDAnnotationSquiggly annotation = new PDAnnotationSquiggly();
            annotation.setRectangle(new PDRectangle(100, 100, 200, 50));
            annotation.setContents("Test squiggly annotation");
            
            PDSquigglyAppearanceHandler handler = new PDSquigglyAppearanceHandler(annotation, document);
            
            // This will trigger the static initialization of PDSquigglyAppearanceHandler
            // which calls LogFactory.getLog(PDSquigglyAppearanceHandler.class)
            handler.generateAppearanceStreams();
        }
    }
}
