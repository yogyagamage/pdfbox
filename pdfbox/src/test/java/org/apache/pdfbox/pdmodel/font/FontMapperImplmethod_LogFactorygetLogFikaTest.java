package org.apache.pdfbox.pdmodel.font;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.fontbox.FontBoxFont;
import org.apache.fontbox.ttf.OpenTypeFont;
import org.apache.fontbox.ttf.TTFParser;
import org.apache.fontbox.ttf.TrueTypeFont;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.junit.jupiter.api.Test;

public class FontMapperImplmethod_LogFactorygetLogFikaTest {

    @Test
    public void testGetFontCacheTriggersStaticInitializer() {
        FontMapperImpl fontMapper = new FontMapperImpl();
        fontMapper.getFontCache();
    }
}
