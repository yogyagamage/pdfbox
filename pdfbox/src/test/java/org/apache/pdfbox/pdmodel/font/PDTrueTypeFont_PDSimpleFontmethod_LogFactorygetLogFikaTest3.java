package org.apache.pdfbox.pdmodel.font;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.font.encoding.Encoding;
import org.apache.pdfbox.pdmodel.font.encoding.WinAnsiEncoding;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;

public class PDTrueTypeFont_PDSimpleFontmethod_LogFactorygetLogFikaTest3 {

    @Test
    public void testLoadTriggersStaticInitializer() throws IOException {
        // Create a temporary TTF file
        File tempFile = File.createTempFile("test", ".ttf");
        tempFile.deleteOnExit();
        
        // Create a mock PDDocument
        PDDocument document = new PDDocument();
        
        // Use WinAnsiEncoding as a concrete Encoding implementation
        Encoding encoding = WinAnsiEncoding.INSTANCE;
        
        try {
            // This will trigger the static initializer of PDSimpleFont
            // which calls LogFactory.getLog(PDSimpleFont.class)
            PDTrueTypeFont.load(document, tempFile, encoding);
        } catch (IOException e) {
            // Expected for invalid TTF file - ignore since we only care about
            // triggering the static initializer chain
        } finally {
            document.close();
        }
    }
}
