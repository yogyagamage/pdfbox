package org.apache.pdfbox.util;

import org.junit.jupiter.api.Test;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Hexmethod_LogFactorygetLogFikaTest {

    @Test
    public void testGetStringTriggersLogFactoryGetLog() {
        // The static initializer will be triggered when the class is loaded
        // Calling getString will ensure the class is loaded and static initializer runs
        Hex.getString((byte) 0x41);
    }
}
