package org.apache.pdfbox.pdmodel.interactive.form;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDNonTerminalField;
import org.junit.jupiter.api.Test;

class PDNonTerminalFieldmethod_LogFactorygetLogFikaTest {

    @Test
    void testGetLogInvocation() throws Exception {
        try (PDDocument document = new PDDocument()) {
            PDAcroForm acroForm = new PDAcroForm(document);
            PDNonTerminalField field = new PDNonTerminalField(acroForm);
            // The static field LOG triggers LogFactory.getLog during class initialization
            // which happens when PDNonTerminalField class is loaded
        }
    }
}
