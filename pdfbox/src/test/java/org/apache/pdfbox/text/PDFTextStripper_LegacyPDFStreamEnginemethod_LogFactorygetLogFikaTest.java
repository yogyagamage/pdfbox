package org.apache.pdfbox.text;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.PDDocument;
import java.io.StringWriter;
import org.apache.commons.logging.LogFactory;

public class PDFTextStripper_LegacyPDFStreamEnginemethod_LogFactorygetLogFikaTest {

    @Test
    public void testPDFTextStripperConstructorTriggersLogFactoryGetLog() throws Exception {
        // The static initialization of LegacyPDFStreamEngine (parent class)
        // will be triggered when PDFTextStripper class is loaded.
        // Creating an instance of PDFTextStripper will load the class,
        // which triggers the static initializer in LegacyPDFStreamEngine,
        // which calls LogFactory.getLog(LegacyPDFStreamEngine.class).
        
        // Instantiate PDFTextStripper using the provided constructor
        PDFTextStripper stripper = new PDFTextStripper();
        
        // To ensure the static initialization completes, we can optionally
        // call a method that uses the static LOG field from parent class.
        // However, the static initialization happens during class loading,
        // which occurs before constructor execution.
        
        // The test's goal is just to execute the chain, which happens
        // during class loading when PDFTextStripper class is first referenced.
        // The constructor call above ensures the class is loaded.
        
        // No assertions or verifications needed per requirements
    }
}
