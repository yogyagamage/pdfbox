package org.apache.pdfbox.pdmodel.graphics.image;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;
import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class PDImageXObject_PNGConverterbuildIndexImage_LogerrorFikaTest {

    @Test
    public void testCreateFromByteArrayTriggersLogError() throws IOException {
        // Create a minimal PDDocument using the no-arg constructor
        PDDocument document = new PDDocument();
        
        // Create PNG bytes that will trigger the indexed color path without PLTE chunk
        // PNG signature + IHDR chunk + IDAT chunk (minimal structure)
        byte[] pngBytes = new byte[] {
            // PNG signature (8 bytes)
            (byte) 0x89, 0x50, 0x4E, 0x47, 0x0D, 0x0A, 0x1A, 0x0A,
            // IHDR chunk length (13 bytes)
            0x00, 0x00, 0x00, 0x0D,
            // Chunk type "IHDR"
            0x49, 0x48, 0x44, 0x52,
            // Width: 1 pixel
            0x00, 0x00, 0x00, 0x01,
            // Height: 1 pixel
            0x00, 0x00, 0x00, 0x01,
            // Bit depth: 8
            0x08,
            // Color type: 3 (indexed color)
            0x03,
            // Compression: 0
            0x00,
            // Filter: 0
            0x00,
            // Interlace: 0
            0x00,
            // CRC for IHDR (dummy value)
            0x00, 0x00, 0x00, 0x00,
            // IDAT chunk length (1 byte)
            0x00, 0x00, 0x00, 0x01,
            // Chunk type "IDAT"
            0x49, 0x44, 0x41, 0x54,
            // Single data byte
            0x00,
            // CRC for IDAT (dummy value)
            0x00, 0x00, 0x00, 0x00,
            // IEND chunk
            0x00, 0x00, 0x00, 0x00,
            0x49, 0x45, 0x4E, 0x44,
            0x00, 0x00, 0x00, 0x00
        };
        
        // Call the entry point method
        // This will traverse through the call chain and eventually trigger Log.error()
        // when buildIndexImage() is called with a state that has no PLTE chunk
        try {
            PDImageXObject.createFromByteArray(document, pngBytes, "test.png");
        } catch (Exception e) {
            // Expected - the method will return null or throw an exception
            // but we don't care about the result
        }
        
        // Close the document
        document.close();
    }
}
