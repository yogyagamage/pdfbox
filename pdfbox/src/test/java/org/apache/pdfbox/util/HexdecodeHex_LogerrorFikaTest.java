package org.apache.pdfbox.util;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.util.Hex;

public class HexdecodeHex_LogerrorFikaTest {

    @Test
    public void testDecodeHexTriggersLogError() {
        // Create a hex string with an invalid character to trigger the error log
        String invalidHex = "0G"; // 'G' is not a valid hex character
        
        // This should trigger getHexValue('G') to return -1, 
        // making value negative and entering the error logging branch
        Hex.decodeHex(invalidHex);
    }
}
