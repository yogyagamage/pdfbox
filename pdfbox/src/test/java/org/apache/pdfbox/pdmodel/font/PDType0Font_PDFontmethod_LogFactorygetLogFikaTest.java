package org.apache.pdfbox.pdmodel.font;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

public class PDType0Font_PDFontmethod_LogFactorygetLogFikaTest {

    @Test
    public void testLogFactoryGetLogInvocation() throws Exception {
        try (PDDocument document = new PDDocument()) {
            PDFont font = PDType0Font.load(document, 
                PDType0Font_PDFontmethod_LogFactorygetLogFikaTest.class
                    .getResourceAsStream("/org/apache/pdfbox/resources/ttf/LiberationSans-Regular.ttf"));
            
            // Access the static field to trigger static initialization
            Class<?> fontClass = font.getClass().getSuperclass();
        }
    }
}
