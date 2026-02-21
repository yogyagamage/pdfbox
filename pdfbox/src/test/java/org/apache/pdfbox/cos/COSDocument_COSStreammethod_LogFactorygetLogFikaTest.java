package org.apache.pdfbox.cos;

import org.junit.jupiter.api.Test;

class COSDocument_COSStreammethod_LogFactorygetLogFikaTest {

    @Test
    void testLogFactoryGetLogInvocation() {
        // Accessing the static field will trigger the static initializer
        // which contains the target method call: LogFactory.getLog(COSStream.class)
        COSStream unused = new COSStream();
        // The static field LOG is initialized when the class is loaded,
        // which happens when we create an instance or access the class
    }
}
