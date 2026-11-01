package org.apache.pdfbox.filter;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.filter.Filter;
import java.util.zip.Deflater;

public class FiltergetCompressionLevel_LogwarnFikaTest {

    @Test
    public void testGetCompressionLevelTriggersLogWarn() throws Exception {
        // Set system property to trigger NumberFormatException
        System.setProperty(Filter.SYSPROP_DEFLATELEVEL, "invalidNumber");
        
        try {
            // This will trigger the NumberFormatException and call LOG.warn(ex.getMessage(), ex)
            Filter.getCompressionLevel();
        } finally {
            // Clean up system property
            System.clearProperty(Filter.SYSPROP_DEFLATELEVEL);
        }
    }
}
