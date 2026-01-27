package org.apache.pdfbox.text;

import org.apache.commons.logging.Log;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class PDFTextStrippersetEndPage_LogwarnFikaTest {

    @Test
    void testSetEndPageTriggersLogWarn() throws IOException {
        // Create a real PDFTextStripper instance using the provided constructor
        PDFTextStripper stripper = new PDFTextStripper();
        
        // Call setEndPage with a value <= 0 to trigger the LOG.warn call
        stripper.setEndPage(0);
    }
}
