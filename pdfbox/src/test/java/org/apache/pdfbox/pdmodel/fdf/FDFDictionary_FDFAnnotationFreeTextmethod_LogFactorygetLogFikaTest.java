package org.apache.pdfbox.pdmodel.fdf;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.fdf.FDFAnnotationFreeText;

public class FDFDictionary_FDFAnnotationFreeTextmethod_LogFactorygetLogFikaTest {

    @Test
    public void testLogFactoryGetLogInvocation() {
        // Accessing the static field will trigger the static initializer
        // which calls LogFactory.getLog(FDFAnnotationFreeText.class)
        FDFAnnotationFreeText annotation = new FDFAnnotationFreeText();
        // The constructor doesn't need to do anything specific
        // The static initialization already happened when class was loaded
    }
}
