package org.apache.pdfbox.util;

import org.junit.jupiter.api.Test;
import org.apache.commons.logging.LogFactory;

public class Versionmethod_LogFactorygetLogFikaTest {

    @Test
    public void testGetVersionTriggersLogFactoryGetLog() {
        // The static initializer will be triggered when the class is loaded
        // Calling getVersion() ensures the class is loaded and static initializer runs
        Version.getVersion();
    }
}
