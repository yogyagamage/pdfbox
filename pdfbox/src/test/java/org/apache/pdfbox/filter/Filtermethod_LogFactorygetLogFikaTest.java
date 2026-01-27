package org.apache.pdfbox.filter;

import org.junit.jupiter.api.Test;
import org.apache.commons.logging.LogFactory;

public class Filtermethod_LogFactorygetLogFikaTest {

    @Test
    public void testGetCompressionLevel() {
        // The static initializer will be triggered when we access the class
        // This will invoke LogFactory.getLog(Filter.class)
        int compressionLevel = Filter.getCompressionLevel();
    }
}
