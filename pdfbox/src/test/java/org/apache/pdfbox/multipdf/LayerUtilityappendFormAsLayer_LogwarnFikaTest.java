package org.apache.pdfbox.multipdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.junit.jupiter.api.Test;

import java.awt.geom.AffineTransform;

public class LayerUtilityappendFormAsLayer_LogwarnFikaTest {

    @Test
    public void testAppendFormAsLayerTriggersLogWarn() throws Exception {
        PDDocument targetDoc = new PDDocument();
        PDPage targetPage = new PDPage(new PDRectangle(-100, -100, 600, 600));
        targetDoc.addPage(targetPage);
        
        LayerUtility layerUtility = new LayerUtility(targetDoc);
        
        PDFormXObject form = new PDFormXObject(targetDoc);
        AffineTransform transform = new AffineTransform();
        String layerName = "TestLayer";
        
        layerUtility.appendFormAsLayer(targetPage, form, transform, layerName);
        
        targetDoc.close();
    }
}
