package org.apache.pdfbox;

import org.apache.pdfbox.pdmodel.fdf.FDFDocument;
import org.junit.jupiter.api.Test;

public class Loader_FDFDocumentmethod_LogFactorygetLogFikaTest {

    @Test
    public void testLogFactoryGetLogInvocation() throws Exception {
        // Creating an FDFDocument instance will trigger static initialization
        // which calls LogFactory.getLog(FDFDocument.class)
        FDFDocument document = new FDFDocument();
        
        // Additional operations to ensure the static field is accessed
        // This may trigger logging operations that use the LOG field
        document.getClass();
    }
}
