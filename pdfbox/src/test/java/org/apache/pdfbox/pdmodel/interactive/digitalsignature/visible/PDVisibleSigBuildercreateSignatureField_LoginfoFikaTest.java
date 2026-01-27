package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDSignatureField;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import java.io.IOException;

class PDVisibleSigBuildercreateSignatureField_LoginfoFikaTest {

    @Test
    void testCreateSignatureField() throws IOException {
        PDVisibleSigBuilder builder = new PDVisibleSigBuilder();
        
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(new PDRectangle(595, 842));
            document.addPage(page);
            
            PDAcroForm acroForm = new PDAcroForm(document);
            document.getDocumentCatalog().setAcroForm(acroForm);
            
            builder.createSignatureField(acroForm);
        }
    }
}
