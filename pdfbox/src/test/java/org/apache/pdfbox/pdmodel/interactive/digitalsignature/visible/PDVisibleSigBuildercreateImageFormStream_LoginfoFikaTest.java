package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;

class PDVisibleSigBuildercreateImageFormStream_LoginfoFikaTest {

    @Test
    void testCreateImageFormStream() throws Exception {
        PDVisibleSigBuilder builder = new PDVisibleSigBuilder();
        try (PDDocument document = new PDDocument()) {
            builder.createImageFormStream(document);
        }
    }
}
