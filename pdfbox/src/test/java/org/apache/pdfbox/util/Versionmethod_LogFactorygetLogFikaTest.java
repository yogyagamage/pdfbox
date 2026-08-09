package org.apache.pdfbox.util;

import org.junit.jupiter.api.Test;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Versionmethod_LogFactorygetLogFikaTest {

    @Test
    public void testGetVersionTriggersLogFactoryGetLog() {
        // Instantiate the class using the private constructor via reflection
        try {
            java.lang.reflect.Constructor<Version> constructor = Version.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            Version versionInstance = constructor.newInstance();
        } catch (Exception e) {
            // Ignore exceptions - we only need static initialization to occur
        }
        
        // Call the static entry point method
        String result = Version.getVersion();
    }
}
