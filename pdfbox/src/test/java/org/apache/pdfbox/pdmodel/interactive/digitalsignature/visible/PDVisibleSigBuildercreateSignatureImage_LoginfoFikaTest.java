package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;
import java.awt.image.BufferedImage;

class PDVisibleSigBuildercreateSignatureImage_LoginfoFikaTest {
    
    @Test
    void testCreateSignatureImage() throws Exception {
        PDVisibleSigBuilder builder = new PDVisibleSigBuilder();
        PDDocument document = new PDDocument();
        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        
        builder.createSignatureImage(document, image);
    }
}
