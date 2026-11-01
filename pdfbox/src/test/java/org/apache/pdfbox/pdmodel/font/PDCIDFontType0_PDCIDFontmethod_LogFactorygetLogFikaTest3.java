package org.apache.pdfbox.pdmodel.font;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.font.PDCIDFont;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import java.io.InputStream;
import java.io.IOException;

public class PDCIDFontType0_PDCIDFontmethod_LogFactorygetLogFikaTest3 {

    @Test
    public void testLogFactoryGetLogInvocation() throws IOException {
        try (PDDocument document = new PDDocument();
             InputStream fontStream = getClass().getResourceAsStream("/org/apache/pdfbox/resources/ttf/LiberationSans-Regular.ttf")) {
            
            if (fontStream != null) {
                PDFont font = PDType0Font.load(document, fontStream);
                // The static initialization of PDCIDFont.LOG will trigger LogFactory.getLog
                // when PDCIDFont class is loaded during PDType0Font.load()
            }
        }
    }
}
