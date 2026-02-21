package org.apache.pdfbox.pdmodel.font;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import java.io.IOException;
import java.io.InputStream;

public class PDType0Font_PDFontmethod_LogFactorygetLogFikaTest {

    @Test
    public void testStaticInitializationTriggersLogFactoryGetLog() throws IOException {
        // Loading a PDFont subclass will trigger static initialization of PDFont
        // which calls LogFactory.getLog(PDFont.class)
        try (PDDocument document = new PDDocument();
             InputStream fontStream = getClass().getResourceAsStream("/org/apache/pdfbox/resources/ttf/LiberationSans-Regular.ttf")) {
            
            if (fontStream != null) {
                PDType0Font.load(document, fontStream);
            }
        }
    }
}
