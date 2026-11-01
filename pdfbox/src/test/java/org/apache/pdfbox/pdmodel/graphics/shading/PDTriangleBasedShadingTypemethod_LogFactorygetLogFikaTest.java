package org.apache.pdfbox.pdmodel.graphics.shading;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.lang.reflect.Field;

class PDTriangleBasedShadingTypemethod_LogFactorygetLogFikaTest {

    @Test
    void testLogFactoryGetLogInvocation() throws Exception {
        // Access the static field to trigger static initialization
        // which includes the LogFactory.getLog() call
        Field logField = PDTriangleBasedShadingType.class.getDeclaredField("LOG");
        logField.setAccessible(true);
        logField.get(null);
    }
}
