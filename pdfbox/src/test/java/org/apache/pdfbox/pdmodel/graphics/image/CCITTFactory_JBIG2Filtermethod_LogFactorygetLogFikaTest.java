package org.apache.pdfbox.pdmodel.graphics.image;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.PDDocument;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.stream.MemoryCacheImageOutputStream;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.filter.FilterFactory;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;

class CCITTFactory_JBIG2Filtermethod_LogFactorygetLogFikaTest {

    @Test
    void testCreateFromImageTriggersLogFactoryGetLog() throws IOException {
        // Create a minimal 1-bit black/white image
        int width = 2;
        int height = 2;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);
        
        // Set pixels to ensure it's valid
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                image.setRGB(x, y, 0xFFFFFFFF); // white pixels
            }
        }
        
        // Create PDDocument
        PDDocument document = new PDDocument();
        
        try {
            // This call will trigger the static initialization chain:
            // 1. CCITTFactory.createFromImage(...)
            // 2. CCITTFactory.prepareImageXObject(...)
            // 3. FilterFactory.INSTANCE.getFilter(...) triggers FilterFactory static initialization
            // 4. FilterFactory constructor creates JBIG2Filter instance
            // 5. JBIG2Filter static initialization calls LogFactory.getLog(JBIG2Filter.class)
            org.apache.pdfbox.pdmodel.graphics.image.CCITTFactory.createFromImage(document, image);
        } finally {
            document.close();
        }
    }
}
