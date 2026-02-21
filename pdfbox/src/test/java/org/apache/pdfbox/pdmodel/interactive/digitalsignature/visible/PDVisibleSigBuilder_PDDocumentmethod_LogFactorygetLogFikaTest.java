package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;

public class PDVisibleSigBuilder_PDDocumentmethod_LogFactorygetLogFikaTest {

    @Test
    public void testLogFactoryGetLogInvocation() throws Exception {
        // Trigger static initialization which calls LogFactory.getLog(PDDocument.class)
        Class<?> clazz = PDDocument.class;
        
        // Create an instance to ensure class is fully initialized
        // This will cause the static initializer to run, invoking LogFactory.getLog
        try (PDDocument document = new PDDocument()) {
            // No assertions needed - just ensure static initialization occurs
        }
    }
}
