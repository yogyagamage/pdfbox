package org.apache.pdfbox.pdmodel.interactive.form;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDAcroForm_PDFieldTreemethod_LogFactorygetLogFikaTest {

    @Test
    void testGetFieldTreeTriggersLogFactoryGetLog() {
        PDDocument mockDocument = Mockito.mock(PDDocument.class);
        COSDictionary mockDictionary = Mockito.mock(COSDictionary.class);
        
        PDAcroForm acroForm = new PDAcroForm(mockDocument, mockDictionary);
        
        acroForm.getFieldTree();
    }
}
