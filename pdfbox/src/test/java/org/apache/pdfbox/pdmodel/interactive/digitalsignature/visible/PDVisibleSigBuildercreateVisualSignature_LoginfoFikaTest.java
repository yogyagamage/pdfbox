package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDVisibleSigBuildercreateVisualSignature_LoginfoFikaTest {
    
    @Test
    void createVisualSignature_LoginfoFikaTest() throws Exception {
        PDVisibleSigBuilder builder = new PDVisibleSigBuilder();
        PDDocument template = Mockito.mock(PDDocument.class);
        
        builder.createVisualSignature(template);
    }
}
