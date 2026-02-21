package org.apache.pdfbox.multipdf;

import org.junit.jupiter.api.Test;

class PDFMergerUtilitymethod_LogFactorygetLogFikaTest {

    @Test
    void testLogFactoryGetLogInvocation() {
        // Creating an instance will trigger static initialization
        // which includes the LogFactory.getLog() call
        PDFMergerUtility utility = new PDFMergerUtility();
        
        // Additional operations to ensure class loading and initialization
        utility.getClass();
    }
}
