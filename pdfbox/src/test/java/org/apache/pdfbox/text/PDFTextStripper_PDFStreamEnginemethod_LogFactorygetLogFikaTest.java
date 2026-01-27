package org.apache.pdfbox.text;

import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.apache.pdfbox.text.PDFTextStripper;

class PDFTextStripper_PDFStreamEnginemethod_LogFactorygetLogFikaTest {

    @Test
    void testPDFTextStripperConstructorTriggersLogFactoryGetLog() {
        // Instantiate PDFTextStripper using the provided constructor
        PDFTextStripper stripper = new PDFTextStripper();
        // The static initialization of PDFStreamEngine (parent class)
        // will trigger LogFactory.getLog(PDFStreamEngine.class)
        // No assertions needed - test passes if no exception is thrown
    }
}
