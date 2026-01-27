package org.apache.pdfbox.pdmodel;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class PDPageContentStreammethod_LogwarnFikaTest {

    @Test
    public void testEntryPointToThirdPartyMethod() throws IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        
        // Add content to the page to ensure sourcePageHadContents becomes true
        PDPageContentStream tempStream = new PDPageContentStream(document, page);
        tempStream.close();
        
        // This constructor call should trigger LOG.warn when sourcePageHadContents is true
        PDPageContentStream stream = new PDPageContentStream(document, page);
        stream.close();
        
        document.close();
    }
}
