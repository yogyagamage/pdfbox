package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.annotation.handlers.PDLineAppearanceHandler;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class PDAnnotationLine_PDLineAppearanceHandlermethod_LogFactorygetLogFikaTest {

    @Test
    public void testConstructAppearancesTriggersStaticInitializer() throws IOException {
        PDDocument document = Mockito.mock(PDDocument.class);
        PDAnnotationLine annotationLine = new PDAnnotationLine();
        
        annotationLine.constructAppearances(document);
        
        // The static initializer of PDLineAppearanceHandler will be triggered
        // when the class is first referenced, which happens during the
        // constructor call in constructAppearances()
    }
}
