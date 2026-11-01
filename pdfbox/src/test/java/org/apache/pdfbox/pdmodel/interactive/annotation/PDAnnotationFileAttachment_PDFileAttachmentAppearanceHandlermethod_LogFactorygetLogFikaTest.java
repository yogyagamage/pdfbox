package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationFileAttachment;
import org.apache.pdfbox.pdmodel.interactive.annotation.handlers.PDFileAttachmentAppearanceHandler;
import org.junit.jupiter.api.Test;

class PDAnnotationFileAttachment_PDFileAttachmentAppearanceHandlermethod_LogFactorygetLogFikaTest {

    @Test
    void testLogFactoryGetLogInvocation() throws Exception {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);
            
            PDAnnotationFileAttachment annotation = new PDAnnotationFileAttachment();
            annotation.setRectangle(new org.apache.pdfbox.pdmodel.common.PDRectangle(100, 100));
            
            PDFileAttachmentAppearanceHandler handler = new PDFileAttachmentAppearanceHandler(
                annotation, document);
            
            // This will trigger the static initialization which calls LogFactory.getLog
            handler.generateAppearanceStreams();
        }
    }
}
