package org.apache.pdfbox.pdmodel;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class PDPageContentStreammethod_LogFactorygetLogFikaTest {

    @Test
    public void testEntryPoint() throws IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        PDPageContentStream stream = new PDPageContentStream(document, page);
        stream.close();
        document.close();
    }
}
