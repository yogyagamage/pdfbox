package org.apache.pdfbox.text;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.text.PDFTextStripper;

class PDFTextStripper_PDFStreamEnginemethod_LogFactorygetLogFikaTest {

    @Test
    void testPDFTextStripperConstructorTriggersLogFactoryGetLog() {
        PDFTextStripper stripper = new PDFTextStripper();
    }
}
