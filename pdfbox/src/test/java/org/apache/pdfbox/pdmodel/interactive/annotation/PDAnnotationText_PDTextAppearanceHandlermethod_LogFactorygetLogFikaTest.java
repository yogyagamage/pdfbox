package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.interactive.annotation.handlers.PDAppearanceHandler;
import org.apache.pdfbox.pdmodel.interactive.annotation.handlers.PDTextAppearanceHandler;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

class PDAnnotationText_PDTextAppearanceHandlermethod_LogFactorygetLogFikaTest {

    @Test
    void testConstructAppearancesTriggersStaticInitializer() throws Exception {
        COSDictionary cosDict = new COSDictionary();
        cosDict.setItem(COSName.RECT, new PDRectangle(0, 0, 100, 100).getCOSArray());
        cosDict.setName(COSName.SUBTYPE, PDAnnotationText.SUB_TYPE);
        
        PDAnnotationText annotation = new PDAnnotationText(cosDict);
        
        try (PDDocument document = new PDDocument()) {
            annotation.constructAppearances(document);
        }
    }
}
