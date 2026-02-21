package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationFreeText;
import org.apache.pdfbox.pdmodel.interactive.annotation.handlers.PDFreeTextAppearanceHandler;
import org.junit.jupiter.api.Test;

class PDAnnotationFreeText_PDFreeTextAppearanceHandlermethod_LogFactorygetLogFikaTest {

    @Test
    void testLogFactoryGetLogInvocation() throws Exception {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);
            
            PDAnnotationFreeText annotation = new PDAnnotationFreeText();
            annotation.setRectangle(new PDRectangle(100, 100, 200, 50));
            annotation.setContents("Test annotation");
            
            PDFreeTextAppearanceHandler handler = new PDFreeTextAppearanceHandler(
                annotation, 
                document
            );
            
            handler.generateAppearanceStreams();
        }
    }
}
