package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

class PDVisibleSigBuildercreateHolderForm_LoginfoFikaTest {

    @Test
    void testCreateHolderForm() throws Exception {
        PDVisibleSigBuilder builder = new PDVisibleSigBuilder();
        
        PDDocument document = new PDDocument();
        PDStream holderFormStream = new PDStream(document);
        PDResources holderFormResources = new PDResources();
        PDRectangle bbox = new PDRectangle(100, 100);
        
        builder.createHolderForm(holderFormResources, holderFormStream, bbox);
        
        document.close();
    }
}
