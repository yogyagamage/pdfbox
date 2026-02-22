package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class PDAnnotationUnderline_PDUnderlineAppearanceHandlermethod_LogFactorygetLogFikaTest {

    @Test
    public void testConstructAppearancesTriggersStaticInitializer() throws IOException {
        PDDocument document = Mockito.mock(PDDocument.class);
        PDAnnotationUnderline annotation = new PDAnnotationUnderline();
        
        annotation.constructAppearances(document);
    }
}
