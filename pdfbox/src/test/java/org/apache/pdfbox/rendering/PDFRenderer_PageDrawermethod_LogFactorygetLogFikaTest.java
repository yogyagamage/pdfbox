package org.apache.pdfbox.rendering;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

class PDFRenderer_PageDrawermethod_LogFactorygetLogFikaTest {

    @Test
    void testRenderPageToGraphicsTriggersLogFactoryGetLog() throws IOException {
        // Create minimal PDF document with one page
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);
            
            // Create PDFRenderer instance
            PDFRenderer renderer = new PDFRenderer(document);
            
            // Create Graphics2D context
            BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics = image.createGraphics();
            
            try {
                // This call should trigger the static initialization of PageDrawer,
                // which calls LogFactory.getLog(PageDrawer.class)
                renderer.renderPageToGraphics(
                    0, 
                    graphics, 
                    1.0f, 
                    1.0f, 
                    RenderDestination.VIEW
                );
            } finally {
                graphics.dispose();
            }
        }
    }
}
