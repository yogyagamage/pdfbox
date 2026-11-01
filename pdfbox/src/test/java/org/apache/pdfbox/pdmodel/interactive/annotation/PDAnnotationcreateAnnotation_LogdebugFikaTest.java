package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class PDAnnotationcreateAnnotation_LogdebugFikaTest {

    @Test
    public void testCreateAnnotationInvokesLogDebug() throws IOException {
        // Create a COSDictionary without SUBTYPE entry to trigger the null subtype path
        COSDictionary annotDic = new COSDictionary();
        // Do NOT add COSName.SUBTYPE to ensure getNameAsString returns null
        
        // Call the static method - this should invoke LOG.debug("Unknown annotation subtype")
        PDAnnotation.createAnnotation(annotDic);
    }
}
