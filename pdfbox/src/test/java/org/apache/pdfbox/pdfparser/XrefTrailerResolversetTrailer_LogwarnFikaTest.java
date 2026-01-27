package org.apache.pdfbox.pdfparser;

import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.Test;

class XrefTrailerResolversetTrailer_LogwarnFikaTest {

    @Test
    void testSetTrailerTriggersLogWarn() {
        XrefTrailerResolver resolver = new XrefTrailerResolver();
        // Don't call nextXrefObj, so curXrefTrailerObj remains null
        COSDictionary trailer = new COSDictionary();
        resolver.setTrailer(trailer);
        // This should trigger LOG.warn("Cannot add trailer because XRef start was not signalled.")
    }
}
