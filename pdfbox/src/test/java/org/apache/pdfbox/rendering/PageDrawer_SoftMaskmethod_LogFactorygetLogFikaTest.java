package org.apache.pdfbox.rendering;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;

public class PageDrawer_SoftMaskmethod_LogFactorygetLogFikaTest {

    @Test
    public void testSoftMaskStaticInitialization() throws Exception {
        // Access the static field to trigger static initialization
        Field logField = SoftMask.class.getDeclaredField("LOG");
        logField.setAccessible(true);
        logField.get(null);
    }
}
