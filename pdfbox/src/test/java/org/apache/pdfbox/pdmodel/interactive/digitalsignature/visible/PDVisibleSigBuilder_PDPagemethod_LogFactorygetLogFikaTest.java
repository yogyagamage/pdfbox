package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.junit.jupiter.api.Test;

class PDVisibleSigBuilder_PDPagemethod_LogFactorygetLogFikaTest {

    @Test
    void testLogFactoryGetLogInvocation() throws Exception {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);
        }
    }
}
