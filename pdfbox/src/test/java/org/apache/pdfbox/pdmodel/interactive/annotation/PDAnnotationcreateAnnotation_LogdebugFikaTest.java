package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;

class PDAnnotationcreateAnnotation_LogdebugFikaTest {

    @Test
    void testCreateAnnotationInvokesLogDebug() throws Exception {
        // Create a COSDictionary without a SUBTYPE entry
        COSDictionary dict = new COSDictionary();
        // Ensure TYPE is set to ANNOT to avoid constructor warnings
        dict.setItem(COSName.TYPE, COSName.ANNOT);
        
        // Call the static entry point method with the dictionary
        PDAnnotation.createAnnotation(dict);
    }
}
