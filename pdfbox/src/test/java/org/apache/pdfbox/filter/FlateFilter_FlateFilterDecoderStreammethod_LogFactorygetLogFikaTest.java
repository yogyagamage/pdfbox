package org.apache.pdfbox.filter;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

class FlateFilter_FlateFilterDecoderStreammethod_LogFactorygetLogFikaTest {

    @Test
    void testLogFactoryGetLogInvocation() throws Exception {
        // Create a minimal input stream for the decoder
        byte[] inputData = new byte[] { 120, -100, 99, 96, 0, 0, 0, 4, 0, 1 };
        InputStream inputStream = new ByteArrayInputStream(inputData);
        
        // Instantiate FlateFilterDecoderStream which will trigger static initialization
        // including LogFactory.getLog(FlateFilterDecoderStream.class)
        new FlateFilterDecoderStream(inputStream);
    }
}
