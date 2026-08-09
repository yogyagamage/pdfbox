package org.apache.pdfbox.multipdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentProperties;
import org.junit.jupiter.api.Test;

import java.awt.geom.AffineTransform;

class LayerUtilityappendFormAsLayer_LogwarnFikaTest {

    @Test
    void testAppendFormAsLayerTriggersLogWarn() throws Exception {
        PDDocument targetDoc = new PDDocument();
        PDPage targetPage = new PDPage(new PDRectangle(-100, -100, 600, 800));
        targetDoc.addPage(targetPage);
        
        PDDocument formDoc = new PDDocument();
        PDPage formPage = new PDPage();
        formDoc.addPage(formPage);
        PDFormXObject form = new PDFormXObject(formDoc);
        
        LayerUtility layerUtility = new LayerUtility(targetDoc);
        
        layerUtility.appendFormAsLayer(targetPage, form, new AffineTransform(), "TestLayer");
        
        formDoc.close();
        targetDoc.close();
    }
}
