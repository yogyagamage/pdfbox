package org.apache.pdfbox.pdmodel.interactive.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.junit.jupiter.api.Test;

public class PDAcroForm_PDSignatureFieldconstructAppearances_LogwarnFikaTest {

    @Test
    void constructAppearancesShouldInvokeLogWarn() throws Exception {
        PDDocument document = new PDDocument();
        PDAcroForm acroForm = new PDAcroForm(document);
        PDSignatureField signatureField = new PDSignatureField(acroForm);

        PDAnnotationWidget widget = new PDAnnotationWidget();
        widget.setRectangle(new PDRectangle(100f, 100f));

        List<PDAnnotationWidget> widgets = new ArrayList<>();
        widgets.add(widget);
        signatureField.setWidgets(widgets);

        signatureField.constructAppearances();
    }
}
