package org.apache.pdfbox.pdmodel.font;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class FontMapperImpl_FileSystemFontProvideraddType1Font_LogisTraceEnabledFikaTest {

    @TempDir
    Path tempDir;

    @Test
    public void testGetProviderTriggersLogIsTraceEnabled() throws IOException {
        // Create a dummy PFB file to trigger Type1 font processing
        File pfbFile = tempDir.resolve("test.pfb").toFile();
        
        // Write minimal PFB header bytes to make it recognizable as a PFB file
        try (FileOutputStream fos = new FileOutputStream(pfbFile)) {
            // PFB header: start marker 0x80, type 1 (ASCII), 4-byte length
            fos.write(0x80);
            fos.write(1);
            fos.write(new byte[]{0, 0, 0, 6});
            // Some minimal PostScript data
            fos.write("%!PS-AdobeFont-1.0".getBytes());
        }

        // Create FontMapperImpl instance
        FontMapperImpl fontMapper = new FontMapperImpl();
        
        // This will trigger the chain:
        // getProvider() -> DefaultFontProvider.<clinit> -> FileSystemFontProvider constructor
        // -> scanFonts() -> addType1Font() -> LOG.isTraceEnabled()
        fontMapper.getProvider();
    }
}
