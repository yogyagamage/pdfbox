package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationUnderline;
import org.apache.pdfbox.pdmodel.interactive.annotation.handlers.PDUnderlineAppearanceHandler;
import org.junit.jupiter.api.Test;

class PDAnnotationUnderline_PDUnderlineAppearanceHandlermethod_LogFactorygetLogFikaTest {

    @Test
    void testGetLogInvocation() throws Exception {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);
            
            PDAnnotationUnderline annotation = new PDAnnotationUnderline();
            annotation.setRectangle(new PDRectangle(100, 100, 200, 50));
            
            PDUnderlineAppearanceHandler handler = new PDUnderlineAppearanceHandler(annotation, document);
            
            // This will trigger the static initialization of LOG field
            // which calls LogFactory.getLog(PDUnderlineAppearanceHandler.class)
            handler.generateAppearanceStreams();
        }
    }
}
