package org.apache.pdfbox.pdmodel.interactive.form;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class PDAcroFormmethod_LogFactorygetLogFikaTest {

    @Test
    public void testFlattenTriggersStaticInitializer() throws IOException {
        PDDocument mockDocument = Mockito.mock(PDDocument.class);
        PDAcroForm acroForm = new PDAcroForm(mockDocument);
        
        // This will trigger the static initializer which calls LogFactory.getLog
        acroForm.flatten();
    }
}
