package org.apache.pdfbox.pdmodel.font.encoding;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.font.encoding.GlyphList;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

class GlyphListloadList_LogwarnFikaTest2 {

    @Test
    void test() throws Exception {
        // Create input that will trigger duplicate entry and cause LOG.warn() call
        String glyphListContent = 
            "A;0041\n" +           // First entry for 'A'
            "A;0042\n" +           // Duplicate entry for 'A' - will trigger warning
            "B;0042\n";            // Normal entry
        
        InputStream inputStream = new ByteArrayInputStream(
            glyphListContent.getBytes(StandardCharsets.ISO_8859_1));
        
        // Create GlyphList instance - this will call loadList() which may trigger LOG.warn()
        new GlyphList(inputStream, 10);
    }
}
