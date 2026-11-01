package org.apache.pdfbox.pdfparser;

import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.Test;

class XrefTrailerResolversetTrailer_LogwarnFikaTest {
    
    @Test
    void testSetTrailer() {
        XrefTrailerResolver resolver = new XrefTrailerResolver();
        COSDictionary trailer = new COSDictionary();
        
        // This should trigger the Log.warn() call since curXrefTrailerObj is null
        resolver.setTrailer(trailer);
    }
}
