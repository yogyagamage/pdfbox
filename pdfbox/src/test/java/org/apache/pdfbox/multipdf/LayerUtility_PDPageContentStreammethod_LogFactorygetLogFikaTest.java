package org.apache.pdfbox.multipdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.junit.jupiter.api.Test;

import java.awt.geom.AffineTransform;

public class LayerUtility_PDPageContentStreammethod_LogFactorygetLogFikaTest {

    @Test
    public void testAppendFormAsLayerTriggersLogFactoryGetLog() throws Exception {
        PDDocument targetDoc = new PDDocument();
        PDPage targetPage = new PDPage();
        targetDoc.addPage(targetPage);
        
        LayerUtility layerUtility = new LayerUtility(targetDoc);
        
        PDFormXObject form = new PDFormXObject(new org.apache.pdfbox.cos.COSStream());
        AffineTransform transform = new AffineTransform();
        String layerName = "TestLayer";
        
        layerUtility.appendFormAsLayer(targetPage, form, transform, layerName);
        
        targetDoc.close();
    }
}
