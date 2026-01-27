package org.apache.pdfbox.filter;

import org.junit.jupiter.api.Test;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;

class FiltergetCompressionLevel_LogwarnFikaTest {

    @Test
    void testGetCompressionLevelTriggersLogWarn() {
        // Set system property to trigger NumberFormatException
        System.setProperty(Filter.SYSPROP_DEFLATELEVEL, "invalidNumber");
        
        try {
            // Call static method - this should trigger LOG.warn() when parsing fails
            Filter.getCompressionLevel();
        } finally {
            // Clean up system property
            System.clearProperty(Filter.SYSPROP_DEFLATELEVEL);
        }
    }
}
