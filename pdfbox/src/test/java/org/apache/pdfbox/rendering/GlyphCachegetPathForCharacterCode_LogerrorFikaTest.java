package org.apache.pdfbox.rendering;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.apache.pdfbox.pdmodel.font.PDVectorFont;
import org.apache.pdfbox.pdmodel.font.PDFontLike;
import java.io.IOException;
import java.awt.geom.GeneralPath;

public class GlyphCachegetPathForCharacterCode_LogerrorFikaTest {

    @Test
    public void testGetPathForCharacterCodeTriggersLogError() throws Exception {
        PDVectorFont font = Mockito.mock(PDVectorFont.class, Mockito.withSettings()
                .extraInterfaces(PDFontLike.class));
        
        PDFontLike fontLike = (PDFontLike) font;
        Mockito.when(fontLike.getName()).thenReturn("TestFont");
        
        Mockito.when(font.hasGlyph(Mockito.anyInt())).thenReturn(true);
        Mockito.when(font.getNormalizedPath(Mockito.anyInt()))
                .thenThrow(new IOException("Test exception"));
        
        GlyphCache glyphCache = new GlyphCache(font);
        glyphCache.getPathForCharacterCode(65);
    }
}
