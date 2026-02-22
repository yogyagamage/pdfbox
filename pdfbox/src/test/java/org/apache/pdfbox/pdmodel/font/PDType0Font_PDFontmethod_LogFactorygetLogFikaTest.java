package org.apache.pdfbox.pdmodel.font;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class PDType0Font_PDFontmethod_LogFactorygetLogFikaTest {

    @Test
    public void testLoadVerticalTriggersStaticInitializer() throws Exception {
        PDDocument document = new PDDocument();
        InputStream inputStream = new ByteArrayInputStream(new byte[0]);
        
        try {
            PDType0Font.loadVertical(document, inputStream);
        } catch (Exception e) {
            // Ignored - we only care about triggering the static initializer
        } finally {
            document.close();
            inputStream.close();
        }
    }
}
