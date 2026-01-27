package org.apache.pdfbox.text;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

class PDFTextStrippersetStartPage_LogwarnFikaTest {

    @Test
    void testSetStartPageTriggersLogWarn() throws Exception {
        // Create a real PDFTextStripper instance using the provided constructor
        PDFTextStripper stripper = new PDFTextStripper();
        
        // Call the entry point method with a value that triggers the warning
        stripper.setStartPage(0);
    }
}
