package org.apache.pdfbox.pdmodel.font;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;

public class FontMapperImplmethod_LogFactorygetLogFikaTest {

    @Test
    public void testGetFontCacheTriggersStaticInitializer() {
        FontMapperImpl fontMapper = new FontMapperImpl();
        fontMapper.getFontCache();
    }
}
