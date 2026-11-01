package org.apache.pdfbox.pdmodel.graphics.color;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;

public class PDIndexed_PDColormethod_LogFactorygetLogFikaTest {

    @Test
    public void testLogFactoryGetLogInvocation() {
        // Creating a PDColor object will trigger static initialization
        // which calls LogFactory.getLog(PDColor.class)
        new PDColor(new float[]{0.5f, 0.5f, 0.5f}, PDDeviceRGB.INSTANCE);
    }
}
