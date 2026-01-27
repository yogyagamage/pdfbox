package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible.PDVisibleSigBuilder;

class PDVisibleSigBuilder_PDSignatureFieldmethod_LogFactorygetLogFikaTest {

    @Test
    void testCreateSignatureFieldTriggersStaticInitializer() throws Exception {
        PDVisibleSigBuilder builder = new PDVisibleSigBuilder();
        try (PDDocument document = new PDDocument()) {
            PDAcroForm acroForm = new PDAcroForm(document);
            builder.createSignatureField(acroForm);
        }
    }
}
