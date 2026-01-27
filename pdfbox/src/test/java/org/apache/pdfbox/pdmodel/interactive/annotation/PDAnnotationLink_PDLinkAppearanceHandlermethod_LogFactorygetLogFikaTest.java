package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.interactive.annotation.handlers.PDLinkAppearanceHandler;

class PDAnnotationLink_PDLinkAppearanceHandlermethod_LogFactorygetLogFikaTest {

    @Test
    void testConstructAppearancesTriggersStaticInitializer() throws Exception {
        COSDictionary cosDict = new COSDictionary();
        PDAnnotationLink annotationLink = new PDAnnotationLink(cosDict);
        
        try (PDDocument document = new PDDocument()) {
            annotationLink.constructAppearances(document);
        }
    }
}
