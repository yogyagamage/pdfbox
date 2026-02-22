package org.apache.pdfbox.filter;

import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ASCIIHexFilterdecode_LogerrorFikaTest {

    @Test
    public void testDecodeTriggersLogError() throws IOException {
        ASCIIHexFilter filter = new ASCIIHexFilter();
        COSDictionary parameters = new COSDictionary();
        
        // Create input with invalid hex character to trigger LOG.error
        byte[] invalidHex = new byte[] { 'G' }; // 'G' is not a valid hex digit
        ByteArrayInputStream input = new ByteArrayInputStream(invalidHex);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        
        filter.decode(input, output, parameters, 0);
    }
}
