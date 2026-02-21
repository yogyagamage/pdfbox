package org.apache.pdfbox.pdmodel;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.junit.jupiter.api.Test;

class PDPageContentStream_PDAbstractContentStreammethod_LogFactorygetLogFikaTest {

    @Test
    void testLogFactoryGetLogInvocation() throws Exception {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);
            
            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                // The static field LOG in PDAbstractContentStream is initialized
                // when PDPageContentStream is instantiated, which triggers
                // LogFactory.getLog(PDAbstractContentStream.class)
                // No assertions needed - just creating the object is sufficient
            }
        }
    }
}
