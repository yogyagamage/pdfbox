package org.apache.pdfbox.text;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;

import java.io.StringWriter;

public class PDFTextStrippermethod_LogwarnFikaTest2 {

    @Test
    public void testSetStartPageTriggersStaticInitializerAndLogWarn() throws Exception {
        // Create a PDFTextStripper instance using the provided constructor
        PDFTextStripper stripper = new PDFTextStripper();
        
        // Set system property to trigger the static initializer block
        // that reads pdftextstripper.indent property
        System.setProperty("pdftextstripper.indent", "invalidFloat");
        
        // Load the static LOG field to ensure class initialization
        // This triggers the static initializer blocks
        Log log = LogFactory.getLog(PDFTextStripper.class);
        
        // Create a minimal PDDocument to satisfy writeText method requirements
        PDDocument document = new PDDocument();
        StringWriter writer = new StringWriter();
        
        // Call writeText to ensure the class is fully initialized
        // This will also trigger static initializers if not already triggered
        stripper.writeText(document, writer);
        
        // Now call the entry point method with a value that triggers the warning
        // This should invoke LOG.warn() in setStartPage
        stripper.setStartPage(0);
        
        // Clean up
        document.close();
        writer.close();
        
        // Clear system property to avoid side effects
        System.clearProperty("pdftextstripper.indent");
    }
}
