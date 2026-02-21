package org.apache.pdfbox.filter;

import org.junit.jupiter.api.Test;

class JBIG2Filtermethod_LogFactorygetLogFikaTest {

    @Test
    void testGetLogInvocation() {
        // Accessing the static field will trigger the static initializer
        // which contains the target method call: LogFactory.getLog(JBIG2Filter.class)
        JBIG2Filter filter = new JBIG2Filter();
        // The constructor doesn't need to do anything - static initialization
        // already happened when the class was loaded
    }
}
