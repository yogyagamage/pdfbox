package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink;
import org.apache.pdfbox.pdmodel.interactive.annotation.handlers.PDLinkAppearanceHandler;
import org.junit.jupiter.api.Test;

class PDAnnotationLink_PDLinkAppearanceHandlermethod_LogFactorygetLogFikaTest {

    @Test
    void testGetLogInvocation() throws Exception {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);
            
            PDAnnotationLink linkAnnotation = new PDAnnotationLink();
            linkAnnotation.setRectangle(new PDRectangle(100, 100, 200, 50));
            
            PDLinkAppearanceHandler handler = new PDLinkAppearanceHandler(linkAnnotation, document);
            handler.generateAppearanceStreams();
        }
    }
}
