package org.apache.pdfbox.filter;

import org.junit.jupiter.api.Test;
import org.apache.commons.logging.LogFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

class FlateFilterDecoderStreamfetch_LogwarnFikaTest {

    @Test
    void testReadTriggersFetchTriggersWarn() throws IOException {
        // Create input data that will cause a DataFormatException in inflater.inflate()
        byte[] inputData = new byte[] {
            // Zlib header (2 bytes) - will be skipped by constructor
            0x78, 0x01,
            // Invalid compressed data that will cause DataFormatException
            0x00, 0x00, 0x00, 0x00, 0x00, 0x00
        };
        
        ByteArrayInputStream bais = new ByteArrayInputStream(inputData);
        
        // Create a custom InputStream that will provide the invalid data
        FlateFilterDecoderStream stream = new FlateFilterDecoderStream(bais);
        
        // Try to read enough times to trigger fetch() and the DataFormatException
        // which will call LOG.warn()
        for (int i = 0; i < 10; i++) {
            try {
                stream.read();
            } catch (Exception e) {
                // Ignore exceptions - we just want to trigger the warn() call
            }
        }
        
        // Close the stream
        stream.close();
    }
}
