package org.apache.pdfbox.rendering;

import org.junit.jupiter.api.Test;

class PageDrawer_SoftMaskmethod_LogFactorygetLogFikaTest {

    @Test
    void testSoftMaskStaticInitialization() {
        // Accessing SoftMask class will trigger static initialization
        // which calls LogFactory.getLog(SoftMask.class)
        Class<SoftMask> softMaskClass = SoftMask.class;
        
        // Force class initialization by accessing a static field
        try {
            // This will trigger static initializer
            Class.forName("org.apache.pdfbox.rendering.SoftMask");
        } catch (ClassNotFoundException e) {
            // Should not happen
        }
    }
}
