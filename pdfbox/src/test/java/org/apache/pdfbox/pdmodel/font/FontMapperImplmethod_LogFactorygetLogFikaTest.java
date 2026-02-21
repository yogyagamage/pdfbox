package org.apache.pdfbox.pdmodel.font;

import org.junit.jupiter.api.Test;

class FontMapperImplmethod_LogFactorygetLogFikaTest {

    @Test
    void testGetLogInvocation() {
        // Accessing the static field will trigger the static initializer
        // which contains the target method call: LogFactory.getLog(FontMapperImpl.class)
        FontMapperImpl mapper = new FontMapperImpl();
        // The constructor doesn't matter; static initialization already happened
        // when the class was loaded, which occurs before this test runs.
    }
}
