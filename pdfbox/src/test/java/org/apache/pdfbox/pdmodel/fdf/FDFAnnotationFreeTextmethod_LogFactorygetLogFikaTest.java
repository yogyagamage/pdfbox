package org.apache.pdfbox.pdmodel.fdf;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.fdf.FDFAnnotationFreeText;

class FDFAnnotationFreeTextmethod_LogFactorygetLogFikaTest {

    @Test
    void testLogFactoryGetLogInvocation() {
        // Creating an instance will trigger static initialization
        // which calls LogFactory.getLog(FDFAnnotationFreeText.class)
        new FDFAnnotationFreeText();
    }
}
