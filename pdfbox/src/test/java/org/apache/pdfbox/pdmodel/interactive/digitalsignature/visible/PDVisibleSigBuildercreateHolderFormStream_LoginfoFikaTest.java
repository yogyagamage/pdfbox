package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible.PDVisibleSigBuilder;

class PDVisibleSigBuildercreateHolderFormStream_LoginfoFikaTest {

    @Test
    void testCreateHolderFormStream() throws Exception {
        PDVisibleSigBuilder builder = new PDVisibleSigBuilder();
        PDDocument document = new PDDocument();
        
        builder.createHolderFormStream(document);
        
        document.close();
    }
}
