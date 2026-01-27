package org.apache.pdfbox.pdmodel.interactive.form;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDAcroFormflatten_LogwarnFikaTest {

    @Test
    void testFlattenTriggersLogWarn() throws Exception {
        PDDocument mockDocument = Mockito.mock(PDDocument.class);
        COSDictionary mockForm = new COSDictionary();
        mockForm.setItem(COSName.XFA, new COSDictionary());
        
        PDAcroForm acroForm = new PDAcroForm(mockDocument, mockForm);
        acroForm.flatten();
    }
}
