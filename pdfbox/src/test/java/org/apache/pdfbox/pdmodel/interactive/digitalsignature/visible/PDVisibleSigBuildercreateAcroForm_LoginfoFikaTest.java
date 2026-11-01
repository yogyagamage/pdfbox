package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PDVisibleSigBuildercreateAcroForm_LoginfoFikaTest {

    @Test
    void testCreateAcroForm() throws Exception {
        PDDocument template = new PDDocument();
        
        PDVisibleSigBuilder builder = new PDVisibleSigBuilder();
        builder.createAcroForm(template);
        
        template.close();
    }
}
