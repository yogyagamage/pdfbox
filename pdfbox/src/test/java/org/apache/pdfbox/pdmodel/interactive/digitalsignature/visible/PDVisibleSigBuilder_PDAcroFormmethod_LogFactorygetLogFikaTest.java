package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.junit.jupiter.api.Test;

public class PDVisibleSigBuilder_PDAcroFormmethod_LogFactorygetLogFikaTest {

    @Test
    public void testLogFactoryGetLogInvocation() throws Exception {
        try (PDDocument document = new PDDocument()) {
            PDAcroForm acroForm = new PDAcroForm(document);
            // The static field LOG triggers LogFactory.getLog(PDAcroForm.class)
            // during class loading, which happens when PDAcroForm is first referenced
        }
    }
}
