package org.apache.pdfbox.multipdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.junit.jupiter.api.Test;

import java.awt.geom.AffineTransform;

public class LayerUtilitymethod_LogFactorygetLogFikaTest {

    @Test
    public void testAppendFormAsLayerTriggersLogFactoryGetLog() throws Exception {
        PDDocument targetDoc = new PDDocument();
        PDPage targetPage = new PDPage();
        targetDoc.addPage(targetPage);
        
        PDFormXObject form = new PDFormXObject(targetDoc);
        AffineTransform transform = new AffineTransform();
        String layerName = "TestLayer";
        
        LayerUtility layerUtility = new LayerUtility(targetDoc);
        layerUtility.appendFormAsLayer(targetPage, form, transform, layerName);
        
        targetDoc.close();
    }
}
