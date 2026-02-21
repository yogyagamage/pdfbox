package org.apache.pdfbox.filter;

import org.junit.jupiter.api.Test;

class ASCIIHexFiltermethod_LogFactorygetLogFikaTest {

    @Test
    void testLogFactoryGetLogInvocation() {
        // Accessing the class will trigger static initialization
        // which includes the call to LogFactory.getLog(ASCIIHexFilter.class)
        Class<ASCIIHexFilter> clazz = ASCIIHexFilter.class;
        
        // Create an instance to potentially trigger further initialization
        // if needed (though static initialization already happened above)
        new ASCIIHexFilter();
    }
}
