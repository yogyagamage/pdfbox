package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.junit.jupiter.api.Test;

class PDVisibleSigBuilder_PDAcroFormmethod_LogFactorygetLogFikaTest {

    @Test
    void testGetLogInvocation() throws Exception {
        try (PDDocument document = new PDDocument()) {
            PDAcroForm acroForm = new PDAcroForm(document);
            // The static field LOG triggers LogFactory.getLog(PDAcroForm.class)
            // when PDAcroForm class is loaded, which happens during constructor execution
        }
    }
}
