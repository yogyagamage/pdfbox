package org.apache.pdfbox.multipdf;

import org.junit.jupiter.api.Test;

class PDFMergerUtilitymethod_LogFactorygetLogFikaTest {

    @Test
    void testLogFactoryGetLogInvocation() {
        PDFMergerUtility utility = new PDFMergerUtility();
        // The static field LOG is initialized when the class is loaded,
        // which triggers the call to LogFactory.getLog(PDFMergerUtility.class)
        // Simply creating an instance ensures class loading occurs
    }
}
