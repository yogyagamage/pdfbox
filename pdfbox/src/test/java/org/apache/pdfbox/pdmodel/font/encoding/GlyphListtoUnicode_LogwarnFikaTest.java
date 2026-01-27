package org.apache.pdfbox.pdmodel.font.encoding;

import org.apache.commons.logging.Log;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class GlyphListtoUnicode_LogwarnFikaTest {

    @Test
    public void testToUnicodeTriggersLogWarn() throws IOException {
        // Create a minimal input stream to satisfy constructor
        String glyphData = "a;0061\nb;0062\n";
        ByteArrayInputStream inputStream = 
            new ByteArrayInputStream(glyphData.getBytes(StandardCharsets.ISO_8859_1));
        
        // Create GlyphList instance using the first constructor
        GlyphList glyphList = new GlyphList(inputStream, 2);
        
        // Call toUnicode with a name that will trigger the LOG.warn path
        // Name format: "uniXXXX" where XXXX is hex in disallowed code area (between 0xD7FF and 0xE000)
        glyphList.toUnicode("uniD800"); // D800 is in the disallowed surrogate range
    }
}
