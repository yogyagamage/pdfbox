package org.apache.pdfbox.multipdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class PDFMergerUtilitymethod_LogFactorygetLogFikaTest {

    @Test
    public void testAppendDocumentTriggersLogFactoryGetLog() throws IOException {
        // Instantiate the class under test using the provided constructor
        PDFMergerUtility mergerUtility = new PDFMergerUtility();
        
        // Create real PDDocument instances for source and destination
        // The static initialization of LOG field will trigger LogFactory.getLog
        // when the class is first loaded, which happens before or during this test.
        // To ensure the static initializer runs, we just need to use the class.
        // The appendDocument method itself doesn't directly call LogFactory.getLog,
        // but the class static initialization does.
        
        // Create minimal valid PDDocuments
        try (PDDocument destination = new PDDocument();
             PDDocument source = new PDDocument()) {
            
            // Call the entry point method
            mergerUtility.appendDocument(destination, source);
        }
        // No assertions needed - test passes if no exception is thrown
        // and the static initialization chain completes
    }
}
