package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDAnnotationPolyline_PDPolylineAppearanceHandlermethod_LogFactorygetLogFikaTest {

    @Test
    void testConstructAppearancesTriggersLogFactoryGetLog() throws Exception {
        COSDictionary dict = Mockito.mock(COSDictionary.class);
        PDAnnotationPolyline annotation = new PDAnnotationPolyline(dict);
        
        PDDocument document = Mockito.mock(PDDocument.class);
        
        annotation.constructAppearances(document);
    }
}
