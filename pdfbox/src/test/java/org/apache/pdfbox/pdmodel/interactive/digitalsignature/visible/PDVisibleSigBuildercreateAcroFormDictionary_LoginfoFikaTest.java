package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDSignatureField;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import java.io.IOException;

class PDVisibleSigBuildercreateAcroFormDictionary_LoginfoFikaTest {

    @Test
    void testCreateAcroFormDictionary() throws IOException {
        PDVisibleSigBuilder builder = new PDVisibleSigBuilder();
        
        PDDocument document = new PDDocument();
        PDPage page = new PDPage(new PDRectangle());
        document.addPage(page);
        
        PDAcroForm acroForm = new PDAcroForm(document);
        document.getDocumentCatalog().setAcroForm(acroForm);
        
        PDSignatureField signatureField = new PDSignatureField(acroForm);
        
        builder.createAcroFormDictionary(acroForm, signatureField);
        
        document.close();
    }
}
