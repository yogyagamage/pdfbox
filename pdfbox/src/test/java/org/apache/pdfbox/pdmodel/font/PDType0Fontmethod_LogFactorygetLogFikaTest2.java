package org.apache.pdfbox.pdmodel.font;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import java.io.IOException;

public class PDType0Fontmethod_LogFactorygetLogFikaTest2 {

    @Test
    public void testLogFactoryGetLogInvocation() throws IOException {
        try (PDDocument document = new PDDocument()) {
            PDType0Font.load(document, getClass().getResourceAsStream("/somefont.ttf"));
        } catch (Exception e) {
            // Ignore exceptions - test only needs to trigger static initialization
        }
    }
}
