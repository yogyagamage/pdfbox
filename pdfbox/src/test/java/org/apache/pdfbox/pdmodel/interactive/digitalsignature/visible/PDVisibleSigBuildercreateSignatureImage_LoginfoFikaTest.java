package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.image.BufferedImage;
import java.io.IOException;

class PDVisibleSigBuildercreateSignatureImage_LoginfoFikaTest {

    @Test
    void testCreateSignatureImage() throws IOException {
        PDDocument template = new PDDocument();
        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        
        PDVisibleSigBuilder builder = new PDVisibleSigBuilder();
        builder.createSignatureImage(template, image);
        
        template.close();
    }
}
