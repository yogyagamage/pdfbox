package org.apache.pdfbox.pdfparser;

import org.junit.jupiter.api.Test;

class XrefTrailerResolvermethod_LogFactorygetLogFikaTest {

    @Test
    void testGetLogInvocation() {
        // Creating an instance will trigger static initialization
        // which includes the LogFactory.getLog() call
        new XrefTrailerResolver();
    }

}
