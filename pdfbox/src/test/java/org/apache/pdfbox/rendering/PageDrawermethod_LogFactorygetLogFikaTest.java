package org.apache.pdfbox.rendering;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;

class PageDrawermethod_LogFactorygetLogFikaTest {

    @Test
    void testGetLogInvocation() throws Exception {
        // Access the static field to trigger static initialization
        Field logField = PageDrawer.class.getDeclaredField("LOG");
        logField.setAccessible(true);
        logField.get(null);
    }
}
