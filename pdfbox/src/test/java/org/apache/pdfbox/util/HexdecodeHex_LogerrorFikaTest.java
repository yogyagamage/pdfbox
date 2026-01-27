package org.apache.pdfbox.util;

import org.apache.commons.logging.Log;
import org.junit.jupiter.api.Test;

public class HexdecodeHex_LogerrorFikaTest {

    @Test
    public void testDecodeHexTriggersLogError() {
        // The decodeHex method is static, so no instance needed
        // Provide a string that will cause the error path to be taken
        // We need a string with invalid hex characters to trigger LOG.error()
        String invalidHex = "GG"; // 'G' is not a valid hex character
        
        // Call the static method - this should trigger LOG.error() internally
        Hex.decodeHex(invalidHex);
    }
}
