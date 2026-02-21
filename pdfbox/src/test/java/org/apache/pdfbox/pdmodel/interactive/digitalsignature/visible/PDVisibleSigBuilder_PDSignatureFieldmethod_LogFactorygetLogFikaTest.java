package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDSignatureField;
import org.junit.jupiter.api.Test;

public class PDVisibleSigBuilder_PDSignatureFieldmethod_LogFactorygetLogFikaTest {

    @Test
    public void testGetLogInvocation() throws Exception {
        try (PDDocument document = new PDDocument()) {
            PDAcroForm acroForm = new PDAcroForm(document);
            PDSignatureField signatureField = new PDSignatureField(acroForm);
            // The static field LOG triggers LogFactory.getLog(PDSignatureField.class)
            // when PDSignatureField class is loaded, which happens during constructor execution
        }
    }
}
