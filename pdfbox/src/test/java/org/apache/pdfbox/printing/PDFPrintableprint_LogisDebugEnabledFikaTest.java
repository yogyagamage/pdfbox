package org.apache.pdfbox.printing;

import org.junit.jupiter.api.Test;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.printing.PDFPrintable;
import org.apache.pdfbox.printing.Scaling;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.io.IOException;

public class PDFPrintableprint_LogisDebugEnabledFikaTest {

    @Test
    public void testPrint() throws PrinterException, IOException {
        // Create a minimal PDDocument with at least one page
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);
        
        // Create PDFPrintable with dpi set to trigger the rasterization path
        PDFPrintable printable = new PDFPrintable(
            document, 
            Scaling.SHRINK_TO_FIT, 
            false, 
            PDFPrintable.RASTERIZE_DPI_AUTO,  // This will trigger the LOG.isDebugEnabled() path
            true
        );
        
        // Create a mock Graphics object that can be cast to Graphics2D
        BufferedImage bi = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics2D = bi.createGraphics();
        
        // Create a PageFormat with non-zero imageable area
        PageFormat pageFormat = new PageFormat();
        
        try {
            // Call the entry point method - this should trigger LOG.isDebugEnabled()
            printable.print(graphics2D, pageFormat, 0);
        } finally {
            graphics2D.dispose();
            document.close();
        }
    }
}
