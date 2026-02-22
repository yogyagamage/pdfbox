package org.apache.pdfbox.filter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.JRE;

@EnabledForJreRange(max = JRE.JAVA_21)
class FiltergetCompressionLevel_LogwarnFikaTest {

    @Test
    void testGetCompressionLevelTriggersLogWarn() throws Exception {
        // Set system property to trigger NumberFormatException
        System.setProperty(Filter.SYSPROP_DEFLATELEVEL, "invalid_number");
        
        try {
            // Invoke entry point - this should trigger the log warning
            Filter.getCompressionLevel();
        } finally {
            // Clean up system property
            System.clearProperty(Filter.SYSPROP_DEFLATELEVEL);
        }
    }
}
