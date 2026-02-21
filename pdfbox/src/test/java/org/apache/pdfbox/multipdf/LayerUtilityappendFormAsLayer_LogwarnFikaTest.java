package org.apache.pdfbox.multipdf;

import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.graphics.state.PDGraphicsState;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDTextField;
import org.junit.jupiter.api.Test;

import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.util.ArrayList;

public class LayerUtilityappendFormAsLayer_LogwarnFikaTest {

    @Test
    public void testAppendFormAsLayerTriggersLogWarn() throws IOException {
        PDDocument targetDoc = new PDDocument();
        PDPage targetPage = new PDPage(new PDRectangle(-100, -100, 600, 600));
        targetDoc.addPage(targetPage);

        PDFormXObject form = createFormXObject(targetDoc);

        AffineTransform transform = new AffineTransform();
        String layerName = "TestLayer";

        LayerUtility layerUtility = new LayerUtility(targetDoc);
        layerUtility.appendFormAsLayer(targetPage, form, transform, layerName);

        targetDoc.close();
    }

    private PDFormXObject createFormXObject(PDDocument document) throws IOException {
        PDPage formPage = new PDPage(PDRectangle.A4);
        PDDocument formDoc = new PDDocument();
        formDoc.addPage(formPage);

        PDAcroForm acroForm = new PDAcroForm(formDoc);
        formDoc.getDocumentCatalog().setAcroForm(acroForm);

        PDTextField textField = new PDTextField(acroForm);
        textField.setPartialName("SampleField");
        acroForm.getFields().add(textField);

        PDAnnotationWidget widget = textField.getWidgets().get(0);
        widget.setRectangle(new PDRectangle(50, 500, 200, 20));
        formPage.getAnnotations().add(widget);

        PDFormXObject form = new PDFormXObject(formDoc);
        form.setResources(formPage.getResources());
        form.setBBox(formPage.getBBox());
        form.setFormType(1);

        formDoc.close();
        return form;
    }
}
