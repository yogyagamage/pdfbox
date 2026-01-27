package org.apache.pdfbox.pdfparser;

import org.apache.commons.logging.Log;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.junit.jupiter.api.Test;

public class XrefTrailerResolversetStartxref_LogwarnFikaTest {

    @Test
    public void testSetStartxrefTriggersLogWarn() {
        XrefTrailerResolver resolver = new XrefTrailerResolver();
        
        // First call to setStartxref should succeed without warning
        resolver.setStartxref(100L);
        
        // Second call should trigger LOG.warn("Method must be called only ones with last startxref value.")
        resolver.setStartxref(200L);
    }
}
