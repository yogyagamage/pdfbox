package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.Test;

class PDAnnotationcreateAnnotation_LogdebugFikaTest {

    @Test
    void testCreateAnnotationInvokesLogDebug() throws Exception {
        // Create a COSDictionary without SUBTYPE entry to trigger the debug log
        COSDictionary dict = new COSDictionary();
        
        // Call the static entry point method
        PDAnnotation.createAnnotation(dict);
    }
}
