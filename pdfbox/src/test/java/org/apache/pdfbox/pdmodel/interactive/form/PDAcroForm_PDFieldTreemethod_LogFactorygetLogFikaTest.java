package org.apache.pdfbox.pdmodel.interactive.form;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;

public class PDAcroForm_PDFieldTreemethod_LogFactorygetLogFikaTest {

    @Test
    public void testGetFieldIteratorTriggersPDFieldTreeStaticInitializer() {
        // Create a mock PDDocument since it's required for PDAcroForm constructor
        PDDocument mockDocument = mock(PDDocument.class);
        
        // Create a mock COSDictionary for the second constructor parameter
        COSDictionary mockDictionary = mock(COSDictionary.class);
        
        // Instantiate PDAcroForm using the two-parameter constructor
        PDAcroForm acroForm = new PDAcroForm(mockDocument, mockDictionary);
        
        // Call the entry point method - this will trigger PDFieldTree class initialization
        // which includes the static field initialization that calls LogFactory.getLog()
        acroForm.getFieldIterator();
    }
}
