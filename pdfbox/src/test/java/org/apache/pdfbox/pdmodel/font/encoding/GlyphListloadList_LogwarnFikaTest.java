package org.apache.pdfbox.pdmodel.font.encoding;

import org.junit.jupiter.api.Test;
import org.apache.pdfbox.pdmodel.font.encoding.GlyphList;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.apache.commons.logging.LogFactory;

public class GlyphListloadList_LogwarnFikaTest {

    @Test
    public void testEntryPointToThirdPartyMethod() throws Exception {
        // Create a glyph list input that will trigger duplicate entry warning
        String glyphListContent = 
            "alpha;0041\n" +           // A
            "beta;0042\n" +            // B
            "alpha;0043\n";            // Duplicate entry for "alpha"
        
        InputStream input = new ByteArrayInputStream(glyphListContent.getBytes());
        
        // Create base GlyphList using first constructor
        InputStream baseInput = new ByteArrayInputStream("gamma;0044".getBytes());
        GlyphList baseGlyphList = new GlyphList(baseInput, 1);
        
        // Call entry point constructor which will trigger loadList and potentially Log.warn
        GlyphList glyphList = new GlyphList(baseGlyphList, input);
    }
}
