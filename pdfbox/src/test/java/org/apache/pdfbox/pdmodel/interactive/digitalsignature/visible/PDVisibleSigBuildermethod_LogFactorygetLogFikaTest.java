package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible.PDVisibleSigBuilder;

public class PDVisibleSigBuildermethod_LogFactorygetLogFikaTest {

    @Test
    public void testLogFactoryGetLogInvocation() {
        // Accessing the static field will trigger the static initializer
        // which calls LogFactory.getLog(PDVisibleSigBuilder.class)
        PDVisibleSigBuilder builder = new PDVisibleSigBuilder();
        // The constructor doesn't need to do anything specific
        // The static field initialization happens when class is loaded
    }
}
