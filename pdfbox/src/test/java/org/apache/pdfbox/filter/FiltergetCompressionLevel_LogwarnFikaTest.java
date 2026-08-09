package org.apache.pdfbox.filter;

import org.junit.jupiter.api.Test;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FiltergetCompressionLevel_LogwarnFikaTest {

    @Test
    public void testGetCompressionLevelTriggersLogWarn() {
        // Set system property to trigger NumberFormatException
        System.setProperty(Filter.SYSPROP_DEFLATELEVEL, "invalidNumber");
        
        try {
            // Call the static entry point method
            Filter.getCompressionLevel();
        } finally {
            // Clean up system property
            System.clearProperty(Filter.SYSPROP_DEFLATELEVEL);
        }
    }
}
