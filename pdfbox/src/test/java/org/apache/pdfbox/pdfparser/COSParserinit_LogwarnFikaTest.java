package org.apache.pdfbox.pdfparser;

import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class COSParserinit_LogwarnFikaTest {

    @Test
    void testInitTriggersLogWarn() throws IOException {
        // Create mock RandomAccessRead
        RandomAccessRead mockSource = Mockito.mock(RandomAccessRead.class);
        Mockito.when(mockSource.length()).thenReturn(1000L);
        
        // Set system property to trigger NumberFormatException in init
        System.setProperty(COSParser.SYSPROP_EOFLOOKUPRANGE, "not-a-number");
        
        try {
            // Create stream cache function
            RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = 
                Mockito.mock(RandomAccessStreamCache.StreamCacheCreateFunction.class);
            
            // Instantiate COSParser - this will call init() which should trigger Log.warn()
            new COSParser(
                mockSource,
                "password",
                new ByteArrayInputStream(new byte[0]),
                "keyAlias",
                streamCacheCreateFunction
            );
        } finally {
            // Clean up system property
            System.clearProperty(COSParser.SYSPROP_EOFLOOKUPRANGE);
        }
    }
}
