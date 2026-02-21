package org.apache.pdfbox.pdmodel.interactive.form;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.junit.jupiter.api.Test;

class PDAcroForm_PDFieldTreemethod_LogFactorygetLogFikaTest {

    @Test
    void testGetLogInvocation() throws Exception {
        try (PDDocument document = new PDDocument()) {
            PDAcroForm acroForm = new PDAcroForm(document);
            PDFieldTree fieldTree = new PDFieldTree(acroForm);
        }
    }
}
