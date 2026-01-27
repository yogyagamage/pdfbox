package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;

class PDVisibleSigBuilder_PDAcroFormmethod_LogFactorygetLogFikaTest {

    @Test
    void testCreateAcroFormTriggersStaticInitializer() throws Exception {
        PDVisibleSigBuilder builder = new PDVisibleSigBuilder();
        try (PDDocument document = new PDDocument()) {
            builder.createAcroForm(document);
        }
    }
}
