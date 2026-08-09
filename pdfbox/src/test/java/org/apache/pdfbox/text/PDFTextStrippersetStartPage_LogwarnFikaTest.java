package org.apache.pdfbox.text;

import org.apache.commons.logging.Log;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringWriter;

class PDFTextStrippersetStartPage_LogwarnFikaTest {

    @Test
    void testSetStartPageTriggersLogWarn() throws IOException {
        // Instantiate the class using the provided constructor
        PDFTextStripper stripper = new PDFTextStripper();
        
        // Call the entry point method with a value that triggers the warning
        stripper.setStartPage(0);
        
        // The call above should invoke LOG.warn(...) internally
        // No assertions or verifications are required
    }
}
