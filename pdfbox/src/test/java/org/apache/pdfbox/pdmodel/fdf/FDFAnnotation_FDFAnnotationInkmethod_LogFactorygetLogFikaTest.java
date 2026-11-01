package org.apache.pdfbox.pdmodel.fdf;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;

class FDFAnnotation_FDFAnnotationInkmethod_LogFactorygetLogFikaTest {

    @Test
    void testLogFactoryGetLogInvocation() throws Exception {
        // Create a real PDDocument to ensure proper initialization
        try (PDDocument document = new PDDocument()) {
            // Create a real COSDictionary for the annotation
            COSDictionary dict = new COSDictionary();
            dict.setName("Subtype", "Ink");
            
            // Instantiate FDFAnnotationInk - this will trigger static initialization
            // which calls LogFactory.getLog(FDFAnnotationInk.class)
            new FDFAnnotationInk(dict);
        }
    }
}
