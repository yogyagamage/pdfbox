package org.apache.pdfbox.text;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.PDDocument;
import java.io.StringWriter;
import org.apache.commons.logging.LogFactory;

public class PDFTextStripper_SetFontAndSizemethod_LogFactorygetLogFikaTest {

    @Test
    public void testEntryPointToThirdPartyMethod() throws Exception {
        // Create a real PDDocument to satisfy constructor dependencies
        PDDocument document = new PDDocument();
        
        // Instantiate PDFTextStripper using the provided constructor
        PDFTextStripper stripper = new PDFTextStripper();
        
        // Set up required fields to avoid NPE during execution
        stripper.setStartPage(1);
        stripper.setEndPage(1);
        
        // Create a writer for the writeText method
        StringWriter writer = new StringWriter();
        
        // Call writeText which will eventually trigger the constructor chain
        // and reach the static initializer of SetFontAndSize
        stripper.writeText(document, writer);
        
        // Clean up
        document.close();
    }
}
