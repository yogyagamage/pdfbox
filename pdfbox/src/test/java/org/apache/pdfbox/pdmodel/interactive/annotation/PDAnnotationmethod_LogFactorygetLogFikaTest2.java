package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationText;

class PDAnnotationmethod_LogFactorygetLogFikaTest2 {

    @Test
    void testGetLogInvocation() throws Exception {
        try (PDDocument document = new PDDocument()) {
            PDAnnotation annotation = new PDAnnotationText();
            // Accessing the class triggers static initialization
            Class<?> clazz = annotation.getClass();
        }
    }
}
