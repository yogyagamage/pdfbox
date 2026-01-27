package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import java.awt.geom.AffineTransform;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.cos.COSName;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PDVisibleSigBuildercreateImageForm_LoginfoFikaTest {

    @Test
    public void testCreateImageForm() throws IOException {
        PDVisibleSigBuilder builder = new PDVisibleSigBuilder();
        
        PDDocument document = new PDDocument();
        
        PDResources imageFormResources = new PDResources();
        PDResources innerFormResource = new PDResources();
        PDStream imageFormStream = new PDStream(document);
        PDRectangle bbox = new PDRectangle(100, 100);
        AffineTransform at = new AffineTransform();
        
        BufferedImage image = new BufferedImage(10, 10, BufferedImage.TYPE_INT_RGB);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        PDImageXObject img = PDImageXObject.createFromByteArray(
            document, baos.toByteArray(), "test");
        
        builder.createImageForm(
            imageFormResources,
            innerFormResource,
            imageFormStream,
            bbox,
            at,
            img
        );
        
        document.close();
    }
}
