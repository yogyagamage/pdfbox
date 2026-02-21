package org.apache.pdfbox.multipdf;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;

class LayerUtilitymethod_LogFactorygetLogFikaTest {

    @Test
    void testGetLogInvocation() throws Exception {
        // Access the static field to trigger static initialization
        Field logField = LayerUtility.class.getDeclaredField("LOG");
        logField.setAccessible(true);
        logField.get(null);
    }
}
