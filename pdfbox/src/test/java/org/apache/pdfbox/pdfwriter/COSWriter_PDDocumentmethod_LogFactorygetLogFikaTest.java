package org.apache.pdfbox.pdfwriter;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;

public class COSWriter_PDDocumentmethod_LogFactorygetLogFikaTest {

    @Test
    public void test() throws Exception {
        // Accessing the static field LOG will trigger the static initializer
        // which contains the LogFactory.getLog(PDDocument.class) call
        @SuppressWarnings("unused")
        Class<?> clazz = PDDocument.class;
        
        // Create a PDDocument instance which may also trigger static initialization
        // through class loading if not already initialized
        try (PDDocument document = new PDDocument()) {
            // No assertions needed
        }
    }
}
