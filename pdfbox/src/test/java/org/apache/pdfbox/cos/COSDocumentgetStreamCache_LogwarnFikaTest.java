package org.apache.pdfbox.cos;

import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.cos.ICOSParser;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

class COSDocumentgetStreamCache_LogwarnFikaTest {

    @Test
    void test() throws Exception {
        RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = 
            () -> {
                throw new IOException("Test exception to trigger warning");
            };
        
        ICOSParser parser = Mockito.mock(ICOSParser.class);
        
        new COSDocument(streamCacheCreateFunction, parser);
    }
}
