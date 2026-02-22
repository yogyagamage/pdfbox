package org.apache.pdfbox.util;

import org.junit.jupiter.api.Test;

public class Hexmethod_LogFactorygetLogFikaTest {

    @Test
    public void testGetCharsTriggersStaticInitializer() {
        // This call will trigger the static initializer of Hex class
        // which calls LogFactory.getLog(Hex.class)
        Hex.getChars((short) 0x1234);
    }
}
