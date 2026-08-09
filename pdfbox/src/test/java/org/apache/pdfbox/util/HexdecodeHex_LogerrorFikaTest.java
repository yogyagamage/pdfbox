package org.apache.pdfbox.util;

import org.apache.commons.logging.Log;
import org.junit.jupiter.api.Test;

public class HexdecodeHex_LogerrorFikaTest {

    @Test
    public void testDecodeHexTriggersLogError() {
        // Provide a string that will cause decodeHex to call LOG.error
        // The string must contain an invalid hex character to trigger the error path
        String invalidHex = "GG"; // 'G' is not a valid hex character
        
        // Call the static entry point method
        Hex.decodeHex(invalidHex);
        
        // No assertions or verifications - just executing the path
    }
}
