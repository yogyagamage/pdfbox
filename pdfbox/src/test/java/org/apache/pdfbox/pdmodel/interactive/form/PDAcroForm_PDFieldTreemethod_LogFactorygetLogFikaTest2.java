package org.apache.pdfbox.pdmodel.interactive.form;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PDAcroForm_PDFieldTreemethod_LogFactorygetLogFikaTest2 {

    @Test
    public void testGetFieldTreeTriggersLogFactoryGetLog() throws Exception {
        PDDocument mockDocument = Mockito.mock(PDDocument.class);
        PDAcroForm acroForm = new PDAcroForm(mockDocument);
        
        // This triggers the static initialization of PDFieldTree
        // which calls LogFactory.getLog(PDFieldTree.class)
        acroForm.getFieldTree();
    }
}
