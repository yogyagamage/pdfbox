package org.apache.pdfbox.text;

import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

class PDFTextStrippersetEndPage_LogwarnFikaTest {

    @Test
    void testSetEndPageTriggersLogWarn() throws Exception {
        PDFTextStripper stripper = new PDFTextStripper();
        stripper.setEndPage(0);
    }
}
