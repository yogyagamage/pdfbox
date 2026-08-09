package org.apache.pdfbox.rendering;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

class PDFRenderer_PDFStreamEnginemethod_LogFactorygetLogFikaTest {

    @Test
    void testRenderPageToGraphicsTriggersLogFactoryGetLog() throws IOException {
        // Create a minimal PDDocument with at least one page
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);
        
        // Create PDFRenderer instance using the provided constructor
        PDFRenderer renderer = new PDFRenderer(document);
        
        // Create a Graphics2D object to render to
        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = image.createGraphics();
        
        try {
            // Call the entry point method
            // This should trigger the static initialization of PDFStreamEngine
            // which calls LogFactory.getLog(PDFStreamEngine.class)
            renderer.renderPageToGraphics(
                0,              // pageIndex
                graphics,       // graphics
                1.0f,           // scaleX
                1.0f,           // scaleY
                RenderDestination.VIEW // destination
            );
        } finally {
            graphics.dispose();
            document.close();
        }
    }
}
