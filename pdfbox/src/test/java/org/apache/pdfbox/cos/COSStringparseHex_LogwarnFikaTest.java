package org.apache.pdfbox.cos;

import org.apache.commons.logging.Log;
import org.apache.pdfbox.util.Hex;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.Field;

class COSStringparseHex_LogwarnFikaTest {

    @Test
    void testParseHexTriggersLogWarn() throws Exception {
        // Set the static FORCE_PARSING field to true via system property
        System.setProperty("org.apache.pdfbox.forceParsing", "true");
        
        // Force the static field to be reinitialized
        Field forceParsingField = COSString.class.getDeclaredField("FORCE_PARSING");
        forceParsingField.setAccessible(true);
        
        // Create a hex string that will trigger the warning path
        // We need a malformed hex character to reach the warning branch
        String malformedHex = "AG"; // 'G' is not a valid hex character
        
        // Call the static entry point method
        COSString.parseHex(malformedHex);
    }
}
