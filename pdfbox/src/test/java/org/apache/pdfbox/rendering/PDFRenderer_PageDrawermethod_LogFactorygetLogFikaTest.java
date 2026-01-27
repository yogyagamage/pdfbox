package org.apache.pdfbox.rendering;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

class PDFRenderer_PageDrawermethod_LogFactorygetLogFikaTest {

    @Test
    void testRenderPageToGraphicsTriggersLogFactoryGetLog() throws IOException {
        // Create a minimal PDDocument with at least one page
        PDDocument document = new PDDocument();
        PDPage page = new PDPage(new PDRectangle(PDRectangle.A4.getWidth(), PDRectangle.A4.getHeight()));
        document.addPage(page);
        
        // Instantiate PDFRenderer using the provided constructor
        PDFRenderer renderer = new PDFRenderer(document);
        
        // Create a Graphics2D context to render into
        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        
        // Call the entry point method
        // This will trigger the chain: renderPageToGraphics -> createPageDrawer -> PageDrawer.<clinit> -> LogFactory.getLog
        renderer.renderPageToGraphics(0, graphics, 1.0f, 1.0f, RenderDestination.VIEW);
        
        // Cleanup
        graphics.dispose();
        document.close();
    }
}
