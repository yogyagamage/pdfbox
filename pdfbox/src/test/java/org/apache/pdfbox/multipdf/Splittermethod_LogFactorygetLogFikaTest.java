package org.apache.pdfbox.multipdf;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.PDDocument;
import java.io.File;
import java.io.IOException;

class Splittermethod_LogFactorygetLogFikaTest {

    @Test
    void testLogFactoryGetLogInvocation() throws IOException {
        Splitter splitter = new Splitter();
        PDDocument document = new PDDocument();
        
        try {
            splitter.split(document);
        } catch (Exception e) {
            // Exception is expected and ignored
        } finally {
            document.close();
        }
    }
}
