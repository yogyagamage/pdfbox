package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.interactive.form.PDSignatureField;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

public class PDVisibleSigBuildercreateAppearanceDictionary_LoginfoFikaTest {

    @Test
    public void testCreateAppearanceDictionary() throws IOException {
        PDVisibleSigBuilder builder = new PDVisibleSigBuilder();
        
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);
        
        PDAcroForm acroForm = new PDAcroForm(document);
        document.getDocumentCatalog().setAcroForm(acroForm);
        
        PDSignatureField signatureField = new PDSignatureField(acroForm);
        List<PDAnnotationWidget> widgets = new ArrayList<>();
        PDAnnotationWidget widget = new PDAnnotationWidget();
        widgets.add(widget);
        signatureField.setWidgets(widgets);
        
        COSStream cosStream = document.getDocument().createCOSStream();
        PDFormXObject holderForm = new PDFormXObject(cosStream);
        
        builder.createAppearanceDictionary(holderForm, signatureField);
        
        document.close();
    }
}
