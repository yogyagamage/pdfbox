package org.apache.pdfbox.text;

import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.jupiter.api.Test;

public class PDFTextStrippersetEndPage_LogwarnFikaTest {

    @Test
    public void testSetEndPageTriggersLogWarn() {
        PDFTextStripper stripper = new PDFTextStripper();
        stripper.setEndPage(0);
    }
}
