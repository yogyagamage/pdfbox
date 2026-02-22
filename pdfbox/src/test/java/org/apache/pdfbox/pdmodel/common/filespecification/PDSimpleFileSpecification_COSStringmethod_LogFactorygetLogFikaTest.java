package org.apache.pdfbox.pdmodel.common.filespecification;

import org.apache.pdfbox.cos.COSString;
import org.junit.jupiter.api.Test;

class PDSimpleFileSpecification_COSStringmethod_LogFactorygetLogFikaTest {

    @Test
    void testSetFileTriggersLogFactoryGetLog() {
        PDSimpleFileSpecification spec = new PDSimpleFileSpecification();
        spec.setFile("test.pdf");
        
        // Access COSString class to trigger static initializer
        Class<COSString> cosStringClass = COSString.class;
    }
}
