package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.Test;

class PDAnnotationcreateAnnotation_LogdebugFikaTest {

    @Test
    void testCreateAnnotationInvokesLogDebug() throws Exception {
        COSDictionary dict = new COSDictionary();
        PDAnnotation.createAnnotation(dict);
    }
}
