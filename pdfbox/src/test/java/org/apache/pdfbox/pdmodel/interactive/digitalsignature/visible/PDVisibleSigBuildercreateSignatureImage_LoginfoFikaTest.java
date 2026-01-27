package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.PDDocument;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.WritableRaster;
import java.io.IOException;

public class PDVisibleSigBuildercreateSignatureImage_LoginfoFikaTest {

    @Test
    public void testCreateSignatureImage() throws IOException {
        PDVisibleSigBuilder builder = new PDVisibleSigBuilder();
        
        try (PDDocument document = new PDDocument()) {
            BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
            builder.createSignatureImage(document, image);
        }
    }
}
