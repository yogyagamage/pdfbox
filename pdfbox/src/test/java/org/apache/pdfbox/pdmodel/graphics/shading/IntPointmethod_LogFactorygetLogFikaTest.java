package org.apache.pdfbox.pdmodel.graphics.shading;

import org.junit.jupiter.api.Test;

class IntPointmethod_LogFactorygetLogFikaTest {

    @Test
    void testGetLogInvocation() {
        // Accessing the static field will trigger the static initializer
        // which contains the target method call
        IntPoint point = new IntPoint(1, 2);
        // The constructor doesn't use LOG, but the class initialization
        // already triggered the static field initialization
    }
}
