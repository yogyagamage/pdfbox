package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible.PDVisibleSigBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PDVisibleSigBuildercreateHolderFormStream_LoginfoFikaTest {

    @Test
    void createHolderFormStream_LoginfoFikaTest() throws Exception {
        PDVisibleSigBuilder builder = new PDVisibleSigBuilder();
        PDDocument template = new PDDocument();
        
        builder.createHolderFormStream(template);
        
        template.close();
    }
}
