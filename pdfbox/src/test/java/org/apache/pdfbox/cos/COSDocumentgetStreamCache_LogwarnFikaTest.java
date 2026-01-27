package org.apache.pdfbox.cos;

import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.cos.ICOSParser;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class COSDocumentgetStreamCache_LogwarnFikaTest {

    @Test
    public void testGetStreamCacheTriggersLogWarn() throws Exception {
        // Create a StreamCacheCreateFunction that throws IOException
        RandomAccessStreamCache.StreamCacheCreateFunction failingFunction = () -> {
            throw new IOException("Test exception for triggering warn log");
        };
        
        // Mock the parser as it's required by the constructor but not directly related to the target method
        ICOSParser parser = Mockito.mock(ICOSParser.class);
        
        // Instantiate COSDocument with the failing function
        // This will trigger the IOException in getStreamCache, which should invoke Log.warn()
        COSDocument document = new COSDocument(failingFunction, parser);
    }
}
