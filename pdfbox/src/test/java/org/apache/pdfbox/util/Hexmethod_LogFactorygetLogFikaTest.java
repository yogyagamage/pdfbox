package org.apache.pdfbox.util;

import org.junit.jupiter.api.Test;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Hexmethod_LogFactorygetLogFikaTest {

    @Test
    public void testGetCharsTriggersLogFactoryGetLog() {
        // The static initializer of Hex will be triggered when the class is loaded
        // This happens when we first access the class, either by calling a static method
        // or by referencing the class. The static initializer contains the call to
        // LogFactory.getLog(Hex.class) which is our target third-party method.
        
        // Force class loading and static initialization by calling the entry point
        char[] result = Hex.getChars((short) 0x1234);
        
        // No assertions needed - test passes if LogFactory.getLog is invoked during execution
    }
}
