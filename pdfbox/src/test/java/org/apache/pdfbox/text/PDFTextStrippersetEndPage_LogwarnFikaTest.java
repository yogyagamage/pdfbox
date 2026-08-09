package org.apache.pdfbox.text;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFTextStrippersetEndPage_LogwarnFikaTest {

    @Test
    public void testSetEndPageTriggersLogWarn() {
        // Instantiate the class using the provided constructor
        PDFTextStripper stripper = new PDFTextStripper();
        
        // Call the entry point method with a value that triggers the warning
        // The condition is: if (endPageValue <= 0)
        stripper.setEndPage(0);
    }
}
