package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;
import org.apache.pdfbox.cos.COSDictionary;

class PDAnnotationInk_PDInkAppearanceHandlermethod_LogFactorygetLogFikaTest {

    @Test
    void testConstructAppearancesTriggersLogFactoryGetLog() throws Exception {
        COSDictionary dict = new COSDictionary();
        PDAnnotationInk annotation = new PDAnnotationInk(dict);
        
        try (PDDocument document = new PDDocument()) {
            annotation.constructAppearances(document);
        }
    }
}
