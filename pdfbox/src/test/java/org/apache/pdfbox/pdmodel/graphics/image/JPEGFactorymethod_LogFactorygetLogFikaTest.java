package org.apache.pdfbox.pdmodel.graphics.image;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class JPEGFactorymethod_LogFactorygetLogFikaTest {

    @Test
    public void testCreateFromStreamTriggersLogFactoryGetLog() throws Exception {
        // Create a minimal valid JPEG stream
        byte[] jpegData = new byte[] {
            (byte)0xFF, (byte)0xD8, // SOI marker
            (byte)0xFF, (byte)0xE0, // APP0 marker
            0x00, 0x10, // APP0 length (16 bytes)
            'J', 'F', 'I', 'F', 0x00, // JFIF identifier
            0x01, 0x01, // Version
            0x00, // Density units
            0x00, 0x01, // X density
            0x00, 0x01, // Y density
            0x00, 0x00, // Thumbnail width/height
            (byte)0xFF, (byte)0xDB, // DQT marker
            0x00, 0x43, // DQT length (67 bytes)
            0x00, // Table info
            // Fill with zeros for quantization table data (64 bytes)
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            (byte)0xFF, (byte)0xC0, // SOF0 marker
            0x00, 0x0B, // SOF0 length (11 bytes)
            0x08, // Precision
            0x00, 0x01, // Height
            0x00, 0x01, // Width
            0x01, // Components
            0x01, 0x11, 0x00, // Component info
            (byte)0xFF, (byte)0xDA, // SOS marker
            0x00, 0x08, // SOS length (8 bytes)
            0x01, // Components in scan
            0x01, 0x00, // Component selector
            0x00, 0x3F, 0x00, // Spectral selection
            (byte)0x00, // Image data (1 byte)
            (byte)0xFF, (byte)0xD9  // EOI marker
        };
        
        InputStream stream = new ByteArrayInputStream(jpegData);
        PDDocument document = new PDDocument();
        
        try {
            // This will trigger the static initialization which calls LogFactory.getLog
            JPEGFactory.createFromStream(document, stream);
        } finally {
            document.close();
            stream.close();
        }
    }
}
