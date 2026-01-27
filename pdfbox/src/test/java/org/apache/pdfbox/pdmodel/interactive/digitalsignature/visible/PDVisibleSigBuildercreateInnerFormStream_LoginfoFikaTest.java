package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;

class PDVisibleSigBuildercreateInnerFormStream_LoginfoFikaTest {

    @Test
    void testCreateInnerFormStream() throws Exception {
        PDVisibleSigBuilder builder = new PDVisibleSigBuilder();
        
        try (PDDocument document = new PDDocument()) {
            builder.createInnerFormStream(document);
        }
    }
}
