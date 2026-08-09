package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;

class PDVisibleSigBuildercreateVisualSignature_LoginfoFikaTest {

    @Test
    void testCreateVisualSignature() throws Exception {
        PDVisibleSigBuilder builder = new PDVisibleSigBuilder();
        PDDocument document = new PDDocument();
        builder.createVisualSignature(document);
        document.close();
    }
}
