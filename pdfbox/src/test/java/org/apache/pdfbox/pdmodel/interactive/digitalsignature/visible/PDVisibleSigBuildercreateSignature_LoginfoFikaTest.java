package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDSignatureField;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import java.io.IOException;

public class PDVisibleSigBuildercreateSignature_LoginfoFikaTest {

    @Test
    public void testCreateSignature() throws IOException {
        // Create the builder instance using the provided constructor
        PDVisibleSigBuilder builder = new PDVisibleSigBuilder();
        
        // Create required objects for the method call
        PDDocument document = new PDDocument();
        PDPage page = new PDPage(new PDRectangle(100, 100));
        document.addPage(page);
        
        // Create an acroform and signature field
        PDAcroForm acroForm = new PDAcroForm(document);
        PDSignatureField signatureField = new PDSignatureField(acroForm);
        
        // Call the entry point method
        builder.createSignature(signatureField, page, "TestSigner");
        
        // Clean up
        document.close();
    }
}
