package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.interactive.form.PDSignatureField;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

public class PDVisibleSigBuildercreateWidgetDictionary_LoginfoFikaTest {

    @Test
    public void testCreateWidgetDictionary() throws IOException {
        PDVisibleSigBuilder builder = new PDVisibleSigBuilder();
        
        PDDocument document = new PDDocument();
        PDAcroForm acroForm = new PDAcroForm(document);
        PDSignatureField signatureField = new PDSignatureField(acroForm);
        
        PDAnnotationWidget widget = new PDAnnotationWidget();
        List<PDAnnotationWidget> widgets = new ArrayList<>();
        widgets.add(widget);
        signatureField.setWidgets(widgets);
        
        PDResources holderFormResources = new PDResources();
        
        builder.createWidgetDictionary(signatureField, holderFormResources);
    }
}
