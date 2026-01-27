package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.Test;

class PDAnnotationLine_PDLineAppearanceHandlermethod_LogFactorygetLogFikaTest {

    @Test
    void testConstructAppearancesTriggersLogFactoryGetLog() throws Exception {
        COSDictionary cosDict = new COSDictionary();
        PDAnnotationLine annotation = new PDAnnotationLine(cosDict);
        
        try (PDDocument document = new PDDocument()) {
            annotation.constructAppearances(document);
        }
    }
}
