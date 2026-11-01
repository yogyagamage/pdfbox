package org.apache.pdfbox.pdmodel.interactive.form;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDFieldTree;

class PDAcroForm_PDFieldTreemethod_LogFactorygetLogFikaTest2 {

    @Test
    void testLogFactoryGetLogInvocation() throws Exception {
        try (PDDocument document = new PDDocument()) {
            PDAcroForm acroForm = new PDAcroForm(document);
            PDFieldTree fieldTree = new PDFieldTree(acroForm);
            // The static field LOG initialization will trigger LogFactory.getLog
            // when PDFieldTree class is loaded/initialized
        }
    }
}
