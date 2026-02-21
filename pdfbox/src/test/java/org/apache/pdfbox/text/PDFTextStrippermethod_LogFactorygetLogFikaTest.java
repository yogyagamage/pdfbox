package org.apache.pdfbox.text;

import org.junit.jupiter.api.Test;

class PDFTextStrippermethod_LogFactorygetLogFikaTest {

    @Test
    void testLogFactoryGetLogInvocation() {
        // Accessing the static field LOG will trigger the static initializer
        // which contains the LogFactory.getLog() call
        PDFTextStripper stripper = new PDFTextStripper();
        // The static initialization happens when class is loaded,
        // so just creating an instance ensures the static block runs
    }
}
