package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.annotation.handlers.PDAppearanceHandler;
import org.apache.pdfbox.pdmodel.interactive.annotation.handlers.PDStrikeoutAppearanceHandler;
import org.junit.jupiter.api.Test;

class PDAnnotationStrikeout_PDStrikeoutAppearanceHandlermethod_LogFactorygetLogFikaTest {

    @Test
    void testConstructAppearancesTriggersLogFactoryGetLog() throws Exception {
        PDAnnotationStrikeout annotation = new PDAnnotationStrikeout();
        PDDocument document = new PDDocument();
        
        annotation.constructAppearances(document);
        
        document.close();
    }
}
