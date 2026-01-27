package org.apache.pdfbox.pdmodel.font;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

class PDType0Fontmethod_LogFactorygetLogFikaTest2 {

    @Test
    void testLoadVerticalTriggersStaticInitializer() throws Exception {
        // Create a minimal valid TrueType font byte array
        // This represents a minimal TTF structure to avoid EOFException
        byte[] minimalTTF = new byte[] {
            0x00, 0x01, 0x00, 0x00, // version 1.0
            0x00, 0x00, // numTables
            0x00, 0x00, // searchRange
            0x00, 0x00, // entrySelector
            0x00, 0x00  // rangeShift
        };
        
        InputStream input = new ByteArrayInputStream(minimalTTF);
        PDDocument document = new PDDocument();
        
        try {
            // This call will trigger the static initializer which calls LogFactory.getLog
            PDType0Font.loadVertical(document, input);
        } catch (Exception e) {
            // Expected - the font data is invalid but static initializer already ran
        } finally {
            document.close();
        }
    }
}
