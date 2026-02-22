package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDAnnotationStrikeout_PDStrikeoutAppearanceHandlermethod_LogFactorygetLogFikaTest {

    @Test
    void testConstructAppearancesTriggersStaticInitializer() throws Exception {
        PDDocument document = Mockito.mock(PDDocument.class);
        PDAnnotationStrikeout strikeout = new PDAnnotationStrikeout();
        
        strikeout.constructAppearances(document);
    }
}
