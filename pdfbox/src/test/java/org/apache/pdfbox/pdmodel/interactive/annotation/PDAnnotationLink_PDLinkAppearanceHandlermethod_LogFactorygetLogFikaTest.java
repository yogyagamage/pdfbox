package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PDAnnotationLink_PDLinkAppearanceHandlermethod_LogFactorygetLogFikaTest {

    @Test
    public void testConstructAppearancesTriggersStaticInitializer() throws Exception {
        PDDocument document = Mockito.mock(PDDocument.class);
        PDAnnotationLink link = new PDAnnotationLink();
        
        link.constructAppearances(document);
    }
}
