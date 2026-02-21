package org.apache.pdfbox.filter;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

class FlateFilterDecoderStreammethod_LogFactorygetLogFikaTest2 {

    @Test
    void testLogFactoryGetLogInvocation() throws Exception {
        byte[] dummyData = new byte[] { 120, -100, 99, 96, 0, 0, 0, 4, 0, 1 };
        InputStream inputStream = new ByteArrayInputStream(dummyData);
        
        // This will trigger static initialization which calls LogFactory.getLog
        new FlateFilterDecoderStream(inputStream);
    }
}
