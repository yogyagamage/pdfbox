package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import org.junit.jupiter.api.Test;

public class PDVisibleSigBuildermethod_LogFactorygetLogFikaTest {

    @Test
    public void testLogFactoryGetLogInvocation() {
        // Accessing the static field will trigger the static initializer
        // which contains the target method call: LogFactory.getLog(PDVisibleSigBuilder.class)
        PDVisibleSigBuilder builder = new PDVisibleSigBuilder();
        // The constructor doesn't need to do anything special;
        // the static field initialization already happened when class was loaded
    }
}
