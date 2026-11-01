package org.apache.pdfbox.pdmodel.encryption;

import org.junit.jupiter.api.Test;

class StandardSecurityHandlermethod_LogFactorygetLogFikaTest {
    
    @Test
    void testGetLogInvocation() {
        // Accessing the static field LOG will trigger the static initializer
        // which calls LogFactory.getLog(StandardSecurityHandler.class)
        StandardSecurityHandler handler = new StandardSecurityHandler();
        // The constructor doesn't need to do anything - static initialization
        // happens when the class is loaded, which occurs when we reference it
    }
}
