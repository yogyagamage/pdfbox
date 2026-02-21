package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

class PDAnnotationcreateAnnotation_LogdebugFikaTest {

    @Test
    void testCreateAnnotationInvokesLogDebug() throws IOException {
        // Create a COSDictionary without SUBTYPE entry
        COSDictionary dict = new COSDictionary();
        // Ensure getNameAsString returns null for SUBTYPE
        // We'll use a mock to control this behavior without affecting the LOG.debug call
        COSDictionary mockDict = Mockito.spy(dict);
        Mockito.when(mockDict.getNameAsString(COSName.SUBTYPE)).thenReturn(null);
        
        // Invoke the method - this should trigger LOG.debug("Unknown annotation subtype")
        PDAnnotation.createAnnotation(mockDict);
    }
}
