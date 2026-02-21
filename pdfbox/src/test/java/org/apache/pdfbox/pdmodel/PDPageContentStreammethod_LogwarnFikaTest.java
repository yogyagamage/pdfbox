package org.apache.pdfbox.pdmodel;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class PDPageContentStreammethod_LogwarnFikaTest {

    @Test
    public void testConstructorTriggersLogWarn() throws IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);
        
        // First call to create initial content
        new PDPageContentStream(document, page);
        
        // Second call should trigger the warning log
        new PDPageContentStream(document, page);
        
        document.close();
    }
}
