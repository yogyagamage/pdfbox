package org.apache.pdfbox.rendering;

import org.junit.jupiter.api.Test;

class GlyphCachemethod_LogFactorygetLogFikaTest {

    @Test
    void testGetLogInvocation() {
        // Accessing the static field will trigger the static initializer
        // which contains the target third-party method call
        GlyphCache cache = new GlyphCache(null);
        // The constructor doesn't use the LOG field, but the class loading
        // already triggered the static initialization
    }
}
