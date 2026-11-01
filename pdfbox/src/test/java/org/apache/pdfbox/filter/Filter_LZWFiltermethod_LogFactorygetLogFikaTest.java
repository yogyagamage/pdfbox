package org.apache.pdfbox.filter;

import org.junit.jupiter.api.Test;

class Filter_LZWFiltermethod_LogFactorygetLogFikaTest {

    @Test
    void testGetLogInvocation() {
        // Accessing the static field will trigger the static initializer
        // which calls LogFactory.getLog(LZWFilter.class)
        LZWFilter filter = new LZWFilter();
        // The constructor doesn't need to do anything special
        // The static initialization already happened when class was loaded
    }
}
