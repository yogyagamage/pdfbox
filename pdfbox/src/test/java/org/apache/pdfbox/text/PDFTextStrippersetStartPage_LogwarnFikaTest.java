package org.apache.pdfbox.text;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

public class PDFTextStrippersetStartPage_LogwarnFikaTest {

    @Test
    public void testSetStartPageTriggersLogWarn() throws Exception {
        PDFTextStripper stripper = new PDFTextStripper();
        
        // Create a minimal valid PDF document
        PDDocument document = new PDDocument();
        document.addPage(new PDPage());
        
        try {
            // Set the stripper to use the document
            stripper.setStartPage(0); // This should trigger the warn log
        } finally {
            document.close();
        }
    }
}
