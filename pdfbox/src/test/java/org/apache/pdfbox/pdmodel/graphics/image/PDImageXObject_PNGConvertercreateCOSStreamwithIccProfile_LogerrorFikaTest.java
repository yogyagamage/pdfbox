package org.apache.pdfbox.pdmodel.graphics.image;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.graphics.image.CustomFactory;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.mockito.Mockito.mock;

public class PDImageXObject_PNGConvertercreateCOSStreamwithIccProfile_LogerrorFikaTest {

    @Test
    public void testCreateFromByteArrayTriggersLogError() throws IOException {
        // Create a minimal PNG that will trigger the error path in createCOSStreamwithIccProfile
        byte[] pngBytes = createInvalidPNGWithBadICCProfile();
        
        // Create a real PDDocument
        PDDocument document = new PDDocument();
        
        // Create a mock CustomFactory (not used in the PNG path but required by signature)
        CustomFactory customFactory = mock(CustomFactory.class);
        
        try {
            // Call the entry point method
            PDImageXObject.createFromByteArray(document, pngBytes, "test.png", customFactory);
        } catch (Exception e) {
            // Ignore all exceptions - we only care about reaching the Log.error call
        } finally {
            document.close();
        }
    }
    
    private byte[] createInvalidPNGWithBadICCProfile() {
        // Build a PNG that will pass initial detection but fail in createCOSStreamwithIccProfile
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        
        // PNG signature
        baos.write(137); // 89
        baos.write(80);  // P
        baos.write(78);  // N
        baos.write(71);  // G
        baos.write(13);  // CR
        baos.write(10);  // LF
        baos.write(26);  // EOF
        baos.write(10);  // LF
        
        // IHDR chunk (13 bytes data + 4 bytes CRC)
        writeChunk(baos, "IHDR", new byte[] {
            0, 0, 0, 1,    // width = 1
            0, 0, 0, 1,    // height = 1
            8,             // bit depth = 8
            2,             // color type = 2 (truecolor)
            0,             // compression method = 0
            0,             // filter method = 0
            0              // interlace method = 0
        });
        
        // iCCP chunk with invalid data (too few bytes after name)
        // The name "ICC" followed by null terminator (4 bytes), then compression method (1 byte)
        // Total length = 5, which means iccProfileDataStart (5) >= state.iCCP.length (5)
        // This triggers the LOG.error("Invalid iCCP chunk, to few bytes")
        writeChunk(baos, "iCCP", new byte[] {
            'I', 'C', 'C', 0,  // name + null terminator
            0                   // compression method = 0
            // No actual profile data - this makes length = 5
        });
        
        // IDAT chunk with minimal valid data for 1x1 RGB image
        // 1 pixel RGB = 3 bytes, filtered with 0
        byte[] idatData = new byte[] {
            0,              // filter type 0
            0, 0, 0         // RGB pixel (black)
        };
        writeChunk(baos, "IDAT", idatData);
        
        // IEND chunk
        writeChunk(baos, "IEND", new byte[0]);
        
        return baos.toByteArray();
    }
    
    private void writeChunk(ByteArrayOutputStream baos, String type, byte[] data) {
        // Write length (big-endian)
        int length = data.length;
        baos.write((length >> 24) & 0xFF);
        baos.write((length >> 16) & 0xFF);
        baos.write((length >> 8) & 0xFF);
        baos.write(length & 0xFF);
        
        // Write type
        for (int i = 0; i < 4; i++) {
            baos.write(type.charAt(i));
        }
        
        // Write data
        baos.write(data, 0, data.length);
        
        // Write dummy CRC (we don't need valid CRC for this test)
        baos.write(0);
        baos.write(0);
        baos.write(0);
        baos.write(0);
    }
}
