package org.apache.pdfbox.pdmodel;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class PDPageContentStream_PDAbstractContentStreammethod_LogFactorygetLogFikaTest {

    @Test
    public void testLogFactoryGetLogInvocation() throws IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        
        new PDPageContentStream(document, page);
        
        document.close();
    }
}
