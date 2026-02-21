package org.apache.pdfbox.pdmodel.encryption;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.encryption.SecurityHandler;

public class StandardSecurityHandler_SecurityHandlermethod_LogFactorygetLogFikaTest3 {

    @Test
    public void testLogFactoryGetLogInvocation() throws Exception {
        // Accessing the static field will trigger the static initializer
        // which contains the target method call: LogFactory.getLog(SecurityHandler.class)
        Class<?> clazz = SecurityHandler.class;
        
        // Force class initialization if not already initialized
        Class.forName(clazz.getName());
    }
}
