package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationPopup;

public class PDAnnotationPopup_PDAnnotationmethod_LogFactorygetLogFikaTest {

    @Test
    public void testStaticInitializationTriggersLogFactoryGetLog() throws Exception {
        try (PDDocument document = new PDDocument()) {
            PDAnnotationPopup popup = new PDAnnotationPopup();
            popup.setContents("Test");
            
            PDAnnotation annotation = popup;
            annotation.toString();
        }
    }
}
