package org.apache.pdfbox.pdmodel.graphics.image;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;

class JPEGFactorymethod_LogFactorygetLogFikaTest2 {

    @Test
    void testCreateFromImageTriggersLogFactoryGetLog() throws Exception {
        PDDocument document = new PDDocument();
        BufferedImage image = new BufferedImage(10, 10, BufferedImage.TYPE_INT_RGB);
        
        JPEGFactory.createFromImage(document, image, 0.8f);
        
        document.close();
    }
}
