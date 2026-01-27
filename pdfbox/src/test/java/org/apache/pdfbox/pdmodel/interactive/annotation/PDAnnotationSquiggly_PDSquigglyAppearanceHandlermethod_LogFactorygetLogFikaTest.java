package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.annotation.handlers.PDAppearanceHandler;
import org.apache.pdfbox.pdmodel.interactive.annotation.handlers.PDSquigglyAppearanceHandler;
import org.junit.jupiter.api.Test;

class PDAnnotationSquiggly_PDSquigglyAppearanceHandlermethod_LogFactorygetLogFikaTest {

    @Test
    void testConstructAppearancesTriggersLogFactoryGetLog() throws Exception {
        PDAnnotationSquiggly annotation = new PDAnnotationSquiggly();
        try (PDDocument document = new PDDocument()) {
            annotation.constructAppearances(document);
        }
    }
}
