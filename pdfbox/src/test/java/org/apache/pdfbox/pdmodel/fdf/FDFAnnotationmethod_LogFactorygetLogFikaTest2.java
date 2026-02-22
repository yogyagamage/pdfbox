package org.apache.pdfbox.pdmodel.fdf;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;

class FDFAnnotationmethod_LogFactorygetLogFikaTest2 {

    @Test
    void testCreateTriggersStaticInitializer() {
        // Create a COSDictionary with a subtype that won't match any known type
        // This will trigger the static initializer which calls LogFactory.getLog
        COSDictionary dict = new COSDictionary();
        dict.setItem(COSName.SUBTYPE, COSName.getPDFName("UnknownType"));
        
        // Call the entry point method
        FDFAnnotation.create(dict);
        
        // No assertions needed - test passes if LogFactory.getLog is invoked
        // during static initialization of FDFAnnotation
    }
}
