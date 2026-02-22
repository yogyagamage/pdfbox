package org.apache.pdfbox.pdmodel.graphics.image;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;
import java.awt.image.BufferedImage;

class CCITTFactory_DCTFiltermethod_LogFactorygetLogFikaTest {

    @Test
    void testCreateFromImageTriggersLogFactoryGetLog() throws Exception {
        // Create a minimal 1-bit black/white image
        int width = 2;
        int height = 2;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);
        
        // Set pixels to ensure it's valid
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                image.setRGB(x, y, 0xFF000000); // Black pixel
            }
        }
        
        // Create document - this will trigger the static initialization chain
        try (PDDocument document = new PDDocument()) {
            // This call will traverse through:
            // 1. CCITTFactory.createFromImage()
            // 2. CCITTFactory.prepareImageXObject()
            // 3. FilterFactory.<clinit>() and <init>()
            // 4. DCTFilter.<clinit>() -> LogFactory.getLog()
            CCITTFactory.createFromImage(document, image);
        }
    }
}
