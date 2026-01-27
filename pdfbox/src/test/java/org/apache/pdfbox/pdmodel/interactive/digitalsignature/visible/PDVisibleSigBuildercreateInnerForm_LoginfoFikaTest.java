package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDSignatureField;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.geom.AffineTransform;
import java.util.List;

class PDVisibleSigBuildercreateInnerForm_LoginfoFikaTest {

    @Test
    void testCreateInnerForm() throws IOException {
        PDVisibleSigBuilder builder = new PDVisibleSigBuilder();
        
        PDDocument document = new PDDocument();
        PDStream innerFormStream = new PDStream(document);
        PDResources innerFormResources = new PDResources();
        PDRectangle bbox = new PDRectangle(100, 100);
        
        builder.createInnerForm(innerFormResources, innerFormStream, bbox);
        
        document.close();
    }
}
