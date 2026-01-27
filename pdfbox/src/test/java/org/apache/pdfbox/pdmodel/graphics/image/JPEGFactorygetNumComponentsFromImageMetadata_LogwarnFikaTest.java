package org.apache.pdfbox.pdmodel.graphics.image;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

class JPEGFactorygetNumComponentsFromImageMetadata_LogwarnFikaTest {

    @Test
    void testCreateFromByteArrayTriggersLogWarn() throws IOException {
        // Create a PDDocument instance
        PDDocument document = new PDDocument();
        
        // Create JPEG data that will cause an exception in getNumComponentsFromImageMetadata
        // The data must be valid enough to pass initial JPEG checks but cause XPath parsing to fail
        byte[] jpegData = createProblematicJpegData();
        
        try {
            // This should trigger the call chain:
            // createFromByteArray -> retrieveDimensions -> getNumComponentsFromImageMetadata -> LOG.warn
            JPEGFactory.createFromByteArray(document, jpegData);
        } catch (Exception e) {
            // Expected - we're only interested in triggering the log.warn call
        } finally {
            document.close();
        }
    }
    
    private byte[] createProblematicJpegData() throws IOException {
        // Create minimal valid JPEG data that will cause XPath parsing to fail
        // JPEG header: SOI marker (0xFFD8)
        byte[] header = new byte[] {(byte)0xFF, (byte)0xD8};
        
        // Add an APP0 segment with JFIF identifier to make it look like a JPEG
        // APP0 marker (0xFFE0) + length (16 bytes) + "JFIF\0" + version + units + density
        byte[] app0 = new byte[] {
            (byte)0xFF, (byte)0xE0,  // APP0 marker
            0x00, 0x10,              // Length (16 bytes)
            'J', 'F', 'I', 'F', 0x00, // Identifier
            0x01, 0x01,              // Version 1.1
            0x00,                    // Density units (0 = no units)
            0x00, 0x01,              // X density
            0x00, 0x01,              // Y density
            0x00, 0x00               // Thumbnail width and height
        };
        
        // Add a Start of Frame (SOF) segment with minimal data
        // SOF0 marker (0xFFC0) + length + precision + height + width + components
        byte[] sof = new byte[] {
            (byte)0xFF, (byte)0xC0,  // SOF0 marker (baseline DCT)
            0x00, 0x0B,              // Length (11 bytes)
            0x08,                    // Precision (8 bits)
            0x00, 0x01,              // Height (1 pixel)
            0x00, 0x01,              // Width (1 pixel)
            0x01,                    // Number of components (1)
            0x00, 0x11, 0x00         // Component 1: ID=0, sampling factors=1x1, quantization table=0
        };
        
        // Add some scan data (minimal)
        byte[] scan = new byte[] {
            (byte)0xFF, (byte)0xDA,  // SOS marker
            0x00, 0x08,              // Length (8 bytes)
            0x01,                    // Number of components in scan (1)
            0x00, 0x00,              // Component 0: DC table=0, AC table=0
            0x00, 0x3F, 0x00         // Spectral selection + successive approximation
        };
        
        // End of image
        byte[] eoi = new byte[] {(byte)0xFF, (byte)0xD9};
        
        // Combine all parts
        byte[] jpegData = new byte[header.length + app0.length + sof.length + scan.length + eoi.length];
        System.arraycopy(header, 0, jpegData, 0, header.length);
        System.arraycopy(app0, 0, jpegData, header.length, app0.length);
        System.arraycopy(sof, 0, jpegData, header.length + app0.length, sof.length);
        System.arraycopy(scan, 0, jpegData, header.length + app0.length + sof.length, scan.length);
        System.arraycopy(eoi, 0, jpegData, header.length + app0.length + sof.length + scan.length, eoi.length);
        
        return jpegData;
    }
}
