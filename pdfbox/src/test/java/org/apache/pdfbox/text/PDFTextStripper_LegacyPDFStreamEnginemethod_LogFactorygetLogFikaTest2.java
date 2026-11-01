package org.apache.pdfbox.text;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.text.LegacyPDFStreamEngine;

public class PDFTextStripper_LegacyPDFStreamEnginemethod_LogFactorygetLogFikaTest2 {

    @Test
    public void testLogFactoryGetLogInvocation() {
        // Accessing the static field will trigger the static initializer
        // which contains the LogFactory.getLog() call
        LegacyPDFStreamEngine engine = new LegacyPDFStreamEngine();
        // The constructor may also trigger static initialization
        // No assertions needed
    }
}
