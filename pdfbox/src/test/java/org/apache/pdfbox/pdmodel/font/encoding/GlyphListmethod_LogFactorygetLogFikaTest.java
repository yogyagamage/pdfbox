package org.apache.pdfbox.pdmodel.font.encoding;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class GlyphListmethod_LogFactorygetLogFikaTest {

    @Test
    void testGetAdobeGlyphListTriggersLogFactoryGetLog() throws IOException {
        // Create a minimal input stream to satisfy constructor requirements
        ByteArrayInputStream dummyStream = new ByteArrayInputStream("test;0041".getBytes());
        
        // Instantiate GlyphList using the first constructor
        // This triggers static initialization which calls LogFactory.getLog
        new GlyphList(dummyStream, 1);
        
        // Call the entry point method which returns the DEFAULT static field
        // The static initialization already happened during class loading,
        // but we call it to complete the required chain
        GlyphList.getAdobeGlyphList();
    }
}
