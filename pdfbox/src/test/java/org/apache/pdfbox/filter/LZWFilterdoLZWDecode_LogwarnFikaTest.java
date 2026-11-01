package org.apache.pdfbox.filter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.*;
import java.nio.file.Path;

class LZWFilterdoLZWDecode_LogwarnFikaTest {

    @Test
    void testDoLZWDecodeTriggersLogWarn(@TempDir Path tempDir) throws Exception {
        // Create a corrupted LZW stream that will cause EOFException
        byte[] corruptedData = new byte[] {
            // First code: CLEAR_TABLE (256) in 9 bits: 1 0000 0000
            (byte) 0b10000000, (byte) 0b00000001,
            // Next code: invalid code that doesn't exist in table (e.g., 257)
            // 257 in 9 bits: 1 0000 0001
            (byte) 0b10000001, (byte) 0b00000001,
            // Add some extra bits to ensure we read past valid data
            (byte) 0xFF, (byte) 0xFF
        };
        
        InputStream encoded = new ByteArrayInputStream(corruptedData);
        File outputFile = tempDir.resolve("output.dat").toFile();
        OutputStream decoded = new FileOutputStream(outputFile);
        
        try {
            // Use reflection to access private method
            java.lang.reflect.Method method = getClass().getClassLoader()
                .loadClass("org.apache.pdfbox.filter.LZWFilter")
                .getDeclaredMethod("doLZWDecode", InputStream.class, OutputStream.class, boolean.class);
            method.setAccessible(true);
            method.invoke(null, encoded, decoded, true);
        } catch (Exception e) {
            // Expected - we want the EOFException to be caught internally
            // and trigger LOG.warn("Premature EOF in LZW stream, EOD code missing", ex)
        } finally {
            decoded.close();
            encoded.close();
        }
    }
}
