package org.apache.pdfbox.pdmodel.fdf;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.fdf.FDFAnnotationPolygon;

public class FDFDictionary_FDFAnnotationPolygonmethod_LogFactorygetLogFikaTest {

    @Test
    public void testLogFactoryGetLogInvocation() {
        // Accessing the static field will trigger the static initializer
        // which contains the target third-party method call
        Class<?> clazz = FDFAnnotationPolygon.class;
        
        // Create an instance to ensure class is fully initialized
        // The constructor may also trigger other initialization
        FDFAnnotationPolygon annotation = new FDFAnnotationPolygon();
    }
}
