package org.apache.pdfbox.pdmodel.interactive.annotation.handlers;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationFileAttachment;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class PDFileAttachmentAppearanceHandlermethod_LogFactorygetLogFikaTest {

    @Test
    public void testGenerateNormalAppearanceTriggersStaticInitializer() throws IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);
        
        PDAnnotationFileAttachment annotation = Mockito.mock(PDAnnotationFileAttachment.class);
        Mockito.when(annotation.getAttachmentName()).thenReturn("Paperclip");
        Mockito.when(annotation.getConstantOpacity()).thenReturn(1.0f);
        
        PDRectangle rect = new PDRectangle(100, 100);
        annotation.setRectangle(rect);
        
        PDFileAttachmentAppearanceHandler handler = new PDFileAttachmentAppearanceHandler(
            annotation, document
        );
        
        handler.generateNormalAppearance();
        
        document.close();
    }
}
