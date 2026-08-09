package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.PDDocument;
import java.io.IOException;

public class PDVisibleSigBuildercreateSignatureField_LoginfoFikaTest {

    @Test
    public void testCreateSignatureField() throws IOException {
        PDVisibleSigBuilder builder = new PDVisibleSigBuilder();
        try (PDDocument document = new PDDocument()) {
            PDAcroForm acroForm = new PDAcroForm(document);
            builder.createSignatureField(acroForm);
        }
    }
}
