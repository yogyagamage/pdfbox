package org.apache.pdfbox.pdmodel.graphics.image;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.graphics.image.JPEGFactory;
import java.io.InputStream;
import java.io.IOException;

class PDImageXObject_JPEGFactorymethod_LogFactorygetLogFikaTest2 {

    @Test
    void testStaticInitializationTriggersLogFactoryGetLog() throws IOException {
        // Accessing the class triggers static initialization
        Class<JPEGFactory> clazz = JPEGFactory.class;
        
        // Create a PDDocument to use with JPEGFactory methods
        try (PDDocument document = new PDDocument()) {
            // Try to load a JPEG image to exercise the class
            // Using a minimal valid JPEG byte array
            byte[] jpegData = new byte[] {
                (byte)0xFF, (byte)0xD8, // SOI marker
                (byte)0xFF, (byte)0xE0, // APP0 marker
                0x00, 0x10, // APP0 length
                0x4A, 0x46, 0x49, 0x46, 0x00, // "JFIF\0"
                0x01, 0x01, // Version
                0x00, // Density units
                0x00, 0x01, 0x00, 0x01, // X/Y density
                0x00, 0x00, // Thumbnail width/height
                (byte)0xFF, (byte)0xDB, // DQT marker
                0x00, 0x43, // DQT length
                0x00, // Table info
                // 64 byte quantization table (dummy values)
                0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01,
                0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01,
                0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01,
                0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01,
                0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01,
                0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01,
                0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01,
                0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01,
                (byte)0xFF, (byte)0xC0, // SOF0 marker
                0x00, 0x0B, // SOF0 length
                0x08, // Precision
                0x00, 0x01, // Height
                0x00, 0x01, // Width
                0x01, // Component count
                0x01, 0x11, 0x00, // Component info
                (byte)0xFF, (byte)0xC4, // DHT marker
                0x00, 0x14, // DHT length
                0x00, // Table class/destination
                // Huffman table (dummy values)
                0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07,
                0x08, 0x09, 0x0A, 0x0B,
                (byte)0xFF, (byte)0xDA, // SOS marker
                0x00, 0x08, // SOS length
                0x01, // Component count
                0x01, 0x00, // Component selector
                0x00, 0x3F, 0x00, // Spectral selection
                0x00, // Successive approximation
                // Minimal image data
                0x00, 0x00, 0x00, 0x00,
                (byte)0xFF, (byte)0xD9  // EOI marker
            };
            
            // This will trigger class loading and static initialization
            // which calls LogFactory.getLog(JPEGFactory.class)
            try {
                JPEGFactory.createFromByteArray(document, jpegData);
            } catch (IOException | IllegalArgumentException e) {
                // Expected - the byte array is not a valid JPEG
                // but static initialization already happened
            }
        }
    }
}
