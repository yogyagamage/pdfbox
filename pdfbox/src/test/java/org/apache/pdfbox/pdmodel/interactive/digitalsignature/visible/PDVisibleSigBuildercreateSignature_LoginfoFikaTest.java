package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible.PDVisibleSigBuilder;
import org.apache.pdfbox.pdmodel.interactive.form.PDSignatureField;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;

public class PDVisibleSigBuildercreateSignature_LoginfoFikaTest {

    @Test
    public void testCreateSignature() throws IOException {
        PDVisibleSigBuilder builder = new PDVisibleSigBuilder();
        
        PDSignatureField signatureField = Mockito.mock(PDSignatureField.class);
        PDPage page = new PDPage();
        
        PDAnnotationWidget widget = new PDAnnotationWidget();
        ArrayList<PDAnnotationWidget> widgets = new ArrayList<>();
        widgets.add(widget);
        
        Mockito.when(signatureField.getWidgets()).thenReturn(widgets);
        
        builder.createSignature(signatureField, page, "Test Signer");
    }
}
