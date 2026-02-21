package org.apache.pdfbox.text;

import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.jupiter.api.Test;

class PDFTextStrippersetStartPage_LogwarnFikaTest {

    @Test
    void testSetStartPage_TriggersLogWarn() {
        PDFTextStripper stripper = new PDFTextStripper();
        stripper.setStartPage(0);
    }
}
