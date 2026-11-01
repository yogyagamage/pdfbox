package org.apache.pdfbox.pdmodel.interactive.form;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDNonTerminalField;
import org.junit.jupiter.api.Test;

public class PDNonTerminalFieldmethod_LogFactorygetLogFikaTest {

    @Test
    public void testGetLogInvocation() throws Exception {
        PDDocument document = new PDDocument();
        PDAcroForm acroForm = new PDAcroForm(document);
        
        PDNonTerminalField field = new PDNonTerminalField(acroForm);
        
        // The static field LOG triggers LogFactory.getLog during class initialization
        // Creating an instance ensures the static initializer runs
        PDNonTerminalField anotherField = new PDNonTerminalField(acroForm);
        
        document.close();
    }
}
